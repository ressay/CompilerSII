#!/bin/zsh

antlr4 TinyLangageSII.g4
javac TinyLangageSII*.java
grun TinyLangageSII prog -tokens -gui  input.txt
