package compiler.AST;

public class Equals extends Expression {
    public Expression left;
    public Expression right;

    public Equals(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void printDebug(int indent) {
        printIndentation(indent); System.out.println("[EQUALS]");
        printIndentation(indent); System.out.println(" -Left:");
        left.printDebug(indent + 1);
        printIndentation(indent); System.out.println(" -Right:");
        right.printDebug(indent + 1);
    }

    @Override
    public void printASM() {
        int uniqueID = getUniqueID();
        comment("Start Equals");

        // evaluate `left`
        left.printASM();
        // grab the result of evaluating `left` from R0
        instr("@R0");
        instr("D=M");
        // push onto the stack (see ASTNode.java for the code generated by push())
        push();
        // evaluate `right`
        right.printASM();
        // grab the result of evaluating `right` from R0
        instr("@R0");
        instr("D=M");
        // grab the previously stored value by "dereferencing" R1 (the stack pointer)
        instr("@R1");
        instr("A=M");
        // perform the equality check!
        // (Subtract the two values. If they're equal we want a 1 (boolean true) and if they're not
        // equal we want a 0 (boolean false). Though it is very verbose, the simplest approach with
        // the Hack CPU's limited operations is to use branches to check the result and jump to
        // the correct boolean value).
        instr("D=M-D", "subtract to check equality");
        instr("@EQUALSBRANCH" + uniqueID);
        instr("D;JEQ");
        instr("D=0");
        instr("@EQUALSEND" + uniqueID);
        instr("0;JMP");
        label("EQUALSBRANCH" + uniqueID);
        instr("D=1");
        label("EQUALSEND" + uniqueID);
        // store in R0
        instr("@R0");
        instr("M=D");
        // pop from the stack (see ASTNode.java for the code generated by pop())
        pop();

        comment("End Equals");
    }
}