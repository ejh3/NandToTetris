// File: projects/p6/ComputerRect-external.tst
// This file is part of the CSE 390B
// project series, adapted from the
// Nand2Tetris project.

load Computer.hdl,
output-file ComputerRect-external.out,
compare-to ComputerRect-external.cmp,
output-list time%S1.4.1;

// Load a program written in the Hack machine language.
// The program draws a rectangle of width 16 pixels and 
// length RAM[0] at the top left of the screen.
ROM32K load Rect.hack,

echo "Before you run this script, select the 'Screen' option from the 'View' menu";

echo "A small rectangle should be drawn at the top left of the screen (the 'Screen' option of the 'View' menu should be selected.)";

// draw a rectangle 16 pixels wide and 4 pixels long
set RAM16K[0] 4,
output;

repeat 63 {
    tick, tock, output;
}
