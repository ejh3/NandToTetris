package compiler.AST;

import java.util.List;

public class While extends Statement {
    public Expression condition;
    public List<Statement> statements;

    public While(Expression condition, List<Statement> statements) {
        this.condition = condition;
        this.statements = statements;
    }

    @Override
    public void printDebug(int indent) {
        printIndentation(indent); System.out.println("[WHILE]");
        printIndentation(indent); System.out.println(" -Condition:");
        condition.printDebug(indent + 1);
        printIndentation(indent); System.out.println(" -Body:");
        for (Statement statement : statements) {
            statement.printDebug(indent + 1);
        }
    }

    @Override
    public void printASM() {
        int uniqueID = getUniqueID();
        comment("Start While");

        // PROJECT 8 TODO
        // (Step 7)

        // Implement the assembly generation for While. This is the final and most difficult part
        // of this project. We recommend looking back at the loops you've written in the past,
        // especially in Project 4, for inspiration about the "general" skeleton of a While loop.
        // This node is fairly unique among all the AST nodes, but you may be able to draw some
        // inspiration from If. Remember that a while loop should evaluate its condition,
        // execute the statements in its body if the condition is true, and then at the end of
        // the body re-evaluate the condition, only exiting the loop once the condition is false.

        // Hint: you will likely want to consider the following things while designing your
        // implementation:
        // - Do you need to generate labels? If so, how will you make sure those labels are unique?
        // - When will you cause the expression and statements to be evaluated at runtime?
        // - Would there be any interference if you had nested While loops?

        // Estimated lines of code in solution: ~14 lines (yours may vary a bit)

        // generate the assembly code for the condition
        label("WHILESTART" + uniqueID);
        condition.printASM();
        // grab the result from R0
        instr("@R0");
        instr("D=M");

        instr("@WHILEEND" + uniqueID);
        instr("D;JEQ", "jump to end if condition is false");
        
        comment("start of while loop contents");
        for (Statement statement : statements) {
            statement.printASM();
        }
        comment("end of while loop contents");

        instr("@WHILESTART" + uniqueID);
        instr("0;JMP", "jump to beginning and reevaluate the condition");

        label("WHILEEND" + uniqueID);

        comment("End While");
    }
}