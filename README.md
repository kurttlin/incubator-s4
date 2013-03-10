Apache S4
=========

Overview
--------
S4 is a general-purpose,near real-time, distributed, decentralized, scalable, 
event-driven, modular platform that allows programmers to easily implement applications 
for processing continuous unbounded streams of data.

S4 0.5 focused on providing a functional complete refactoring.

S4 0.6 builds on this basis and brings plenty of exciting features, in particular:

- major performance improvements: stream throughput improved (measured up to ~200k messages per second and per stream)
- major configurability improvements, for both the S4 platform and deployed applications



Documentation
-------------

For the latest information about S4, please visit our website at:

   http://incubator.apache.org/s4

Source code is available here: https://git-wip-us.apache.org/repos/asf?p=incubator-s4.git


Requirements
------------
* JDK 6 or higher
* *nix or macosx (you may build the project and develop S4 applications with 
microsoft windows though, the only limitation is that the "s4" script has not 
been ported to windows yet)


How to build
------------
This only applies if you checkout from the source repository or if you download a 
released source package.


We use gradle http://gradle.org as the build system.

* From the root directory of the S4 project:

./gradlew install

This will build the packages and install the artifacts in the local maven repository.

* Then, build the tools:

./gradlew s4-tools:installApp

This will build the tools so that you can drive the platform through the "s4" command.


Directory structure
-------------------
* If you have a  source package:

	- root directory contains build and utility scripts, as well as informative files
	- config/ directory contains configuration files for source code formatting
	- doc/ directory contains the javadoc
	- gradle/ directory contains libraries used by the gradle build tool
	- lib/ directory contains some other gradle libraries 
	- subproject/ directory contains the plaftorm subprojects: base, comm, core, tools, 
	as well as example (example is not fully ported to 0.5.0)
	- test-apps/ directory contains some examples (some of them very trivial are used 
	in regression tests)



* If you have a binary package:

	- root directory contains the s4 utility script as well as informative files
	- doc/ directory contains the javadoc
	- lib/ directory contains :
		* the platform libraries (prefixed with "s4")
		* the dependencies
	- bin/ directory contains some scripts that are used by the s4 script
	- gradle/ directory contains libraries used for building S4 projects



