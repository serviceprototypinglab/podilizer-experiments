#!/bin/sh

rm -rf results
./run.sh 2>&1 | tee runlog
