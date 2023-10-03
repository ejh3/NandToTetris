# Project 8: Debugging & Implementing a Compiler
Due Date: Tuesday, December 6th, 2022 at 11:59pm

**The full specification for this project can be found online at [https://courses.cs.washington.edu/courses/cse390b/22au/projects/project8.html](https://courses.cs.washington.edu/courses/cse390b/22au/projects/project8.html)**

### Instructions
Navigate to the Project 8 assignment on Canvas (linked [here](https://canvas.uw.edu/courses/1605861/assignments/7828084)). Download the document template titled `Project 8.docx`. Open the document, read the instructions on the first page, and estimate the amount of time you think it will take you to complete this project. Then, complete Parts I and II of the project (in that specified order).

### Part I: Building a Compiler (25 points)
- Complete the provided buggy, unfinished compiler code. The work can be broken down into these steps, many of which are only a few lines of code. See instructions in full specification, as well as tips and an overview of the Jack language subset being compiled.
    - Step 1: Read and familiarize yourself with the provided code.
    - Step 2: Implement `src/AST/NumberLiteral.java`.
    - Step 3: Debug `src/AST/Plus.java`.
    - Step 4: Implement `src/AST/Minus.java`.
    - Step 5: Implement `src/AST/NotEquals.java`.
    - Step 6: Finish Implementing `src/AST/ArrayVarAccess.java`.
    - Step 7: Debug `src/AST/If.java`.
    - Step 8: Implement `src/AST/While.java`.

### Part II: Project 8 Reflection (5 points)
- Estimate how long it will take you to complete Project 8 on the last page of this
document. Keep track of the amount of time you spent completing this project.
- Answer the Project 8 reflection questions on the last page of the document.

## Submitting Your Work
Submit Part I by tagging your latest commit as `project-8` and pushing the tag to GitLab:
- `git tag project-8`
- `git push --tags`

Once you have completed the `Project 8.docx` document with your reflection for Part II, submit the document as a PDF on [Gradescope](https://www.gradescope.com/courses/451576) under the assignment named “Project 8: Debugging & Implementing a Compiler.”