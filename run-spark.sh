#!/bin/bash

set SPARK_HOME=/apps/spark

read name
docker exec namenode hdfs dfs -rm -f -R /user/root/outputs/*