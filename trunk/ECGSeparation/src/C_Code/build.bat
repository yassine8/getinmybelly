REM This loads the edflib as a linked dll instead of compiling it every time.
gcc -o ReadSignals ReadSignals.c -L./ -ledflib