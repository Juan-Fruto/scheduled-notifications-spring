#!/bin/bash

# load environment variables from .env
set -a
. .env
set +a

# run jar app with environment variables
java -jar app.jar