#!/bin/bash
echo "==============================> Pulling Chrome" 
docker pull selenoid/vnc_chrome:84.0
echo "==============================> Pulling Firefox"
docker pull selenoid/vnc_firefox:77.0
echo "Starting Selenoid Service ... "
docker-compose up --force-recreate -d
