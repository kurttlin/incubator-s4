package org.apache.s4.comm.tcp;

import org.apache.s4.base.Destination;
import org.apache.s4.comm.topology.ClusterNode;

public class TCPDestination extends ClusterNode implements Destination {

    public TCPDestination(ClusterNode clusterNode) {
        this(clusterNode.getPartition(), clusterNode.getPort(), clusterNode.getMachineName(), clusterNode.getTaskId());
    }

    public TCPDestination(int partition, int port, String machineName, String taskId) {
        super(partition, port, machineName, taskId);
    }

}