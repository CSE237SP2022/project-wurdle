#!/bin/bash
echo "Please type in your first guess - all lowercase"
        if [[ -f "wurdle.java" ]];
                then
                        javac wurdle.java
                        OUTPUT=$(java wurdle)
				echo "$OUTPUT" 
        else
                echo "error"
        fi


