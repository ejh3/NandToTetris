package compiler.AST;

public class Minus extends Expression {
    public Expression left;
    public Expression right;

    public Minus(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void printDebug(int indent) {
        printIndentation(indent); System.out.println("[MINUS]");
        printIndentation(indent); System.out.println(" -Left:");
        left.printDebug(indent + 1);
        printIndentation(indent); System.out.println(" -Right:");
        right.printDebug(indent + 1);
    }

    @Override
    public void printASM() {
        comment("Start Minus");

        // PROJECT 8 TODO
        // (Step 3)

        // After debugging the starter code in Plus, implement the assembly generation for
        // Minus. You may copy and paste some or all of Plus and modify as you see fit.

        // Estimated lines of code in solution: ~13 lines.
        // Evaluating Plus.left.
        left.printASM();

        // grab the result of evaluating `left` from R0
        instr("@R0");
        instr("D=M");

        // Pushing result of evaluating Plus.left onto stack.
        push();
    
        // Evaluating Plus.right.
        right.printASM();

        // grab the result of evaluating `right` from R0
        instr("@R0");
        instr("D=M");

        // grab the previously stored value by dereferencing R1 (the stack pointer)
        instr("@R1");
        instr("A=M");

        // perform the addition!
        instr("D=M-D", "perform the subtraction");

        // store in R0
        instr("@R0", "storing in R0");
        instr("M=D");
        // pop from the stack (see ASTNode.java for the code generated by pop())
        // the value popped is not used; it was already used above when we did @R1.
        pop();


        comment("End Minus");
    }
}