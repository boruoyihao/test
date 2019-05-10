#!/bin/bash

ORIG_DIR=`pwd -P`
SCRIPT_DIR=`cd $(dirname $0); pwd -P`
cd $SCRIPT_DIR
mvn clean package

wwwprj="ketangpai"
echo "replace $wwprj war file"
scp target/ketangpai-0.0.1-SNAPSHOT.war  root@121.41.74.241:/opt/resin/webapps/ketangpai.war

cd $ORIG_DIR
