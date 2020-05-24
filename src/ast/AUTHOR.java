package ast;

import libs.Node;

public class AUTHOR extends Node {
    // AUTHOR::= "Author: " CONTENT
    CONTENT ccontent;
    @Override
    public void parse() {

    }

    @Override
    public void evaluate() {
        String start = "\\author{";
        String end = "}\n";
        writer.println(start);
        c.evaluate();
        writer.println(end);
    }
}
/*
\author{Me}
 */
