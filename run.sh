#!/bin/bash
set -e

PROJECT_DIR="$(cd "$(dirname "$0")" && pwd)"
ANTLR_JAR=/usr/local/lib/antlr-4.7-complete.jar
JFX_LIB=/usr/share/openjfx/lib
OUT="$PROJECT_DIR/out"

if [ ! -d "$OUT" ] || [ -z "$(ls -A "$OUT")" ]; then
    echo "Project not compiled. Run ./install.sh first."
    exit 1
fi

java --module-path "$JFX_LIB" --add-modules javafx.controls,javafx.fxml \
    -cp "$OUT:$ANTLR_JAR" UIpart
