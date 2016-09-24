# hello-boron
This is an hello app example of Opendaylight controller which version is 0.5.0-Boron.
It runs within the ODL controller and provides a simple RESTful API for using.

## Bundle configuration
Bean and RPC service is implemented throught Blueprint, a dependency injection framework designed specifically for use in an OSGi container.


## How to build and run

    # git clone https://github.com/siwind/hello-boron.git
    # cd hello-boron
    # mvn clean install
    # ./karaf/target/assembly/bin/karaf

