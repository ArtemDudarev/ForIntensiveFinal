#!/bin/bash

#Define the path to the JAR file
JAR_FILE="D:\4курс\1семестр\Final\IntensiveFinal\target\ForIntensive-1.0-SNAPSHOT.jar"

#Check if the JAR file exists
if [ ! -f "$JAR_FILE" ]; then
  echo "Error: JAR file not found at $JAR_FILE"
  exit 1
fi

#Run the Java application
java -jar $JAR_FILE

#Check if the application exited successfully
if [ $? -eq 0 ]; then
  echo "Java application executed successfully."
else
  echo "Java application failed to execute."
  exit 1
fi