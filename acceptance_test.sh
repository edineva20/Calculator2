#!/bin/sh

set -x 
echo $(hostname)
test $(curl docker:8765/sum?a=1\&b=2) -eq 3

