package ast;

import libs.Node;

public class AUTHOR extends Node {
    // AUTHOR::= "Author: " CONTENT
    CONTENT author;
    @Override
    public void parse() {
        //tokenizer.getAndCheckNext("Author:");
        // Parse Author
        author = new CONTENT();
        author.parse();
    }

    @Override
    public void evaluate() {
        String start = "\\author{";
        String end = "}\n";
        writer.println(start);
        author.evaluate();
        writer.println(end);
    }
}
/*
\author{Me}
 */
