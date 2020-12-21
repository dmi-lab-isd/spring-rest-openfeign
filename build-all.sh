#!/bin/bash -x

for service in client server; do
	cd $service
	./build.sh
	cd ..
done