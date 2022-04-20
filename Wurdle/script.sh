#!/bin/bash

javac -d bin src/constructGame/*.java  src/userPlay/*.java
clear
java -cp bin constructGame.Wurdle

