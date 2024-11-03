# Dockerfile
FROM mcr.microsoft.com/devcontainers/base:alpine-3.20

# Install dependencies
RUN apk add --no-cache bash curl wget openjdk8
SHELL ["/bin/bash", "-c"]

# Set environment variables for Spark
# As of the day of this commit, supported spark version 3.4.4 and 3.5.3 
# Check https://downloads.apache.org/spark for the versions in cas you encounter any error
ENV SPARK_VERSION=3.4.4 \
    HADOOP_VERSION=3 \
    SCALA_VERSION=2.12.15 \
    SBT_VERSION=1.9.8 \
    SPARK_HOME=/usr/local/spark \
    JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk

# Install Scala
RUN wget -q https://downloads.lightbend.com/scala/$SCALA_VERSION/scala-$SCALA_VERSION.tgz && \
    tar xzf scala-$SCALA_VERSION.tgz -C /usr/local/ && \
    ln -s /usr/local/scala-$SCALA_VERSION/bin/scala /bin/scala && \
    ln -s /usr/local/scala-$SCALA_VERSION/bin/scalac /bin/scalac && \
    rm scala-$SCALA_VERSION.tgz

# Install SBT
RUN wget -qO- "https://github.com/sbt/sbt/releases/download/v${SBT_VERSION}/sbt-${SBT_VERSION}.tgz" | tar -xz -C /usr/local && \
    ln -s /usr/local/sbt/bin/sbt /usr/local/bin/sbt

# Download and extract Apache Spark
RUN curl -sL "https://downloads.apache.org/spark/spark-${SPARK_VERSION}/spark-${SPARK_VERSION}-bin-hadoop${HADOOP_VERSION}.tgz" | \
    tar -xz -C /usr/local && \
    mv /usr/local/spark-${SPARK_VERSION}-bin-hadoop${HADOOP_VERSION} $SPARK_HOME

RUN echo 'export PATH="$JAVA_HOME/bin:$SPARK_HOME/bin:$SPARK_HOME/sbin:$PATH"' >> /home/vscode/.bashrc