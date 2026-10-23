#!/usr/bin/env bash
# Generates the Gradle wrapper in a temp dir (so the project's own plugins
# are not configured by whatever Gradle version the container ships with),
# then copies it into the project.
set -e
cd "$(dirname "$0")/.."

if [ -f gradlew ]; then
  echo "Gradle wrapper already present."
  exit 0
fi

TMP=$(mktemp -d)
( cd "$TMP" && gradle wrapper --gradle-version 8.10.2 )
cp -r "$TMP/gradlew" "$TMP/gradlew.bat" "$TMP/gradle" .
chmod +x gradlew
echo "Gradle wrapper created. Try: ./gradlew build"
