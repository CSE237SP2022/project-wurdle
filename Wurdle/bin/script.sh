#!/bin/bash
echo "Please type in your first guess - all lowercase"
        if [[ -f "main.java" ]];
                then
                        javac main.java
                        OUTPUT=$(java main)
				echo "$OUTPUT" 
        else
                echo "error"
        fi


