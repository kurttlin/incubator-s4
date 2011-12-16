package org.apache.s4.appmaker;

import org.apache.s4.base.Event;
import org.apache.s4.core.KeyFinder;

import com.google.common.base.Preconditions;

/**
 * Helper class to add a stream to an S4 application.
 * 
 * @see example {@link S4Maker}
 * 
 */
public class StreamMaker {

    final private AppMaker app;
    final private Class<? extends Event> type;
    final private String propName; // Must match a property name in a PE class that will receive this stream.
    private String name;
    private KeyFinder<? extends Event> keyFinder;
    private String keyDescriptor = null;

    StreamMaker(AppMaker app, String propName, Class<? extends Event> type) {

        Preconditions.checkNotNull(propName);
        Preconditions.checkNotNull(type);
        this.app = app;
        this.propName = propName;
        this.name = propName; // Default name if one is not specified.
        this.type = type;
        app.add(null, this);
    }

    /**
     * Name the stream.
     * 
     * @param name
     *            the stream name, default is an empty string.
     * @return the stream maker object
     */
    public StreamMaker withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Define the key finder for this stream.
     * 
     * @param keyFinder
     *            a function to lookup the value of the key.
     * @return the stream maker.
     */
    public <T extends Event> StreamMaker withKey(KeyFinder<T> keyFinder) {
        this.keyFinder = keyFinder;
        return this;
    }

    /**
     * Define the key finder for this stream using a descriptor.
     * 
     * @param keyFinderString
     *            a descriptor to lookup the value of the key.
     * @return the stream maker.
     */
    public StreamMaker withKey(String keyDescriptor) {

        this.keyDescriptor = keyDescriptor;
        return this;
    }

    /**
     * Send events from this stream to a PE.
     * 
     * @param pe
     *            a target PE.
     * 
     * @return the stream maker.
     */
    public StreamMaker to(PEMaker pe) {
        app.add(this, pe);
        return this;
    }

    /**
     * Send events from this stream to various PEs.
     * 
     * @param pe
     *            a target PE array.
     * 
     * @return the stream maker.
     */
    public StreamMaker to(PEMaker[] pes) {
        for (int i = 0; i < pes.length; i++)
            app.add(this, pes[i]);
        return this;
    }

    /**
     * @return the app
     */
    AppMaker getApp() {
        return app;
    }

    /**
     * @return the type
     */
    Class<? extends Event> getType() {
        return type;
    }

    /**
     * @return the name
     */
    String getName() {
        return name;
    }

    /**
     * @return the keyFinder
     */
    KeyFinder<? extends Event> getKeyFinder() {
        return keyFinder;
    }

    /**
     * @return the keyDescriptor
     */
    String getKeyDescriptor() {
        return keyDescriptor;
    }

    /**
     * @return the propName
     */
    public String getPropName() {
        return propName;
    }

}
