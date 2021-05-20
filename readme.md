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