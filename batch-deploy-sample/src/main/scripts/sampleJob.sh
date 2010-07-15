#!/bin/bash

CP=resources/

LIB=lib/*
for f in $LIB
do
 CP=$CP:$f
done

java -cp $CP org.springframework.batch.core.launch.support.CommandLineJobRunner \
jobs/sampleJob.xml sampleJob