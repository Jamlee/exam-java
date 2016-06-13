#!/bin/bash

jenv local  1.8
jenv shell  1.8
export JAVA_HOME="$HOME/.jenv/versions/`jenv version-name`"
export JRE_HOME="$JAVA_HOME/jre"

