#!/bin/bash
set -e

PROJECT_DIR="$(cd "$(dirname "$0")" && pwd)"
ANTLR_JAR=/usr/local/lib/antlr-4.7-complete.jar
JFX_LIB=/usr/share/openjfx/lib
OUT="$PROJECT_DIR/out"

echo "==> Checking dependencies..."

if [ ! -f "$ANTLR_JAR" ]; then
    echo "==> Downloading ANTLR 4.7..."
    sudo curl -o "$ANTLR_JAR" https://www.antlr.org/download/antlr-4.7-complete.jar
else
    echo "    ANTLR jar found."
fi

if [ ! -d "$JFX_LIB" ]; then
    echo "==> Installing OpenJFX..."
    sudo apt install -y openjfx
else
    echo "    OpenJFX found."
fi

echo "==> Compiling sources..."
mkdir -p "$OUT"
javac --module-path "$JFX_LIB" --add-modules javafx.controls,javafx.fxml \
    -cp "$ANTLR_JAR" \
    -d "$OUT" \
    "$PROJECT_DIR"/src/*.java

echo "==> Copying resources..."
cp "$PROJECT_DIR"/src/*.fxml "$OUT"/

echo "==> Done. Run ./run.sh to launch the app."
