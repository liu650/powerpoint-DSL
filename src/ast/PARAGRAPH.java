package ast;

import libs.Node;

public class PARAGRAPH extends Node {
    CONTENT c;
    @Override
    public void parse() {

    }

    @Override
    public void evaluate() {
        c.evaluate();
        String end  = "\\newline";
        writer.println(end);
    }
}

/*
        sample paragraph:
        line 1 (string) \newline
        */