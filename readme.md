# Spark Setup 
set SPARK_HOME=E:\apps\spark-3.0.1-hadoop3.2.0
set HADOOP_HOME=E:\apps\winutils-master\hadoop-3.2.0
set PATH=%PATH%;%HADOOP_HOME%\bin

## 
    cd /cygdrive/e/git-repos/spark-training-java

##
    docker-compose --file docker/spark/docker-compose.yaml up -d

##
    docker-compose --file docker/spark/docker-compose.yaml down

docker exec spark-master /usr/local/spark/bin/spark-submit \
--master spark://spark-master:7077 \
--deploy-mode cluster \
--conf spark.eventLog.dir=file:///apps/hostpath/spark/logs \
--class com.spark.java.tutorial.rdd.airports.AirportsByLatitudeSolution \
/usr/local/spark/work-dir/spark-java-examples.jar %params%