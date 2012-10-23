#!/bin/sh

echo "Stop catalina..."
cd ~/Downloads/software/apache-tomcat-7.0.30/bin
./catalina.sh stop

echo "Build & Deploy war..."
cd ~/IdeaProjects/untitled1/myMVC
gradle clean gogo

echo "Start catalina..."
cd ~/Downloads/software/apache-tomcat-7.0.30/bin
./catalina.sh start

cd ~/IdeaProjects/untitled1/myMVC