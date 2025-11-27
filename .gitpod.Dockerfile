# .gitpod.Dockerfile
FROM gitpod/workspace-full

# Install Java 21
RUN sudo apt-get update && \
    sudo apt-get install -y openjdk-21-jdk

# Set JAVA_HOME
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH

# Install Maven
RUN sudo apt-get install -y maven
