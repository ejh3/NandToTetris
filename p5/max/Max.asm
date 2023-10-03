// File: projects/p5/max/Max.asm
// This file is part of the CSE 390B
// project series, adapted from the
// Nand2Tetris project.

// Compares R0 and R1 and stores the max value in R2 and
// the address of the max value in R3.
// If the two values in R0 and R1 are equal, then R0 should be considered the max.
// (R0, R1, R2, R3 refer to RAM[0], RAM[1], and RAM[2], RAM[3] respectively.)

// Put your code here.


// // Compare R0 to R1 and jump accordingly
//     @R0
//     D=M
//     @R1
//     D = D-M
//     @ENDIF
//     D; JLT // Jumps to ENDIF if (R0-R1 >= 0)

// // Saves R0 or R1 in D and the address in R3 according to whichever is the max
//     @R0
//     D = A
//     @ENDELSE
//     0; JMP
// (ENDIF)
//     @R1
//     D = A
// (ENDELSE)
//     @R3
//     M = D
//     A = D
//     D = M

// Equivalent to the above ;)
@0
@-1008
@1
@-2864
@10
@-7420
@0
@-5104
@12
@-5497
@1
@-5104
@3
@-7416
@-7392
@-1008
@2
@-7416
@18
@-5497






// Another way to do it :)
// // Saves R0 or R1 in D and the address in R3 according to whichever is the max
//     @R3
//     M = 0
//     @R0
//     D = M
//     @ENDELSE
//     0; JMP
// (ENDIF)
//     @R3
//     M = 1
//     @R1
//     D = M
// (ENDELSE)

// Puts D in R2
    @R2
    M = D

// End program
(END)
    @END
    0; JMP