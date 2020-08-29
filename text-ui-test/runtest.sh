#!/usr/bin/env bash

# change to script directory
# shellcheck disable=SC2164
cd "${0%/*}"

cd ..
./gradlew shadowJar

# shellcheck disable=SC2164
cd text-ui-test

# shellcheck disable=SC2046
java  -jar $(find ../build/libs/ -mindepth 1 -print -quit) < input.txt > ACTUAL.TXT

diff EXPECTED.TXT ACTUAL.TXT
if [ $? -eq 0 ]
then
    echo "Test passed!"
    exit 0
else
    echo "Test failed!"
    exit 1
fi
