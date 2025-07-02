#!/bin/bash


# This script demonstrates how to use curl to interact with a REST API for managing countries.
# Get a list of all countries
# get country as per arg 0


if [ -z "$1" ]; then
  echo "Usage: $0 <country_id>"
  exit 1
fi

curl -v -X GET "http://localhost:8081/countries/$1" -H "Accept: application/json"
