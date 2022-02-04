#!/bin/bash
CHECK_DIRECTORY="/home/kira/draft1/draft"
WORKING_DIRECTORY="/home/kira/draft1"
cd /home/kira
if [ ! -d $CHECK_DIRECTORY ]; then
mkdir -p $WORKING_DIRECTORY;
cd $WORKING_DIRECTORY;
git clone https://github.com/dennys9415/draft.git;
cd $CHECK_DIRECTORY
git checkout dev
git pull
else
cd $CHECK_DIRECTORY
git checkout dev
git pull
fi