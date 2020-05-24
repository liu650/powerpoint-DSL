package ast;

import libs.Node;

public class TITLE extends Node{
    // TITLE::="Title= " CONTENT “;”
    Content c;
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("Title:");
        title=tokenizer.getNext();
    }

    @Override
    public void evaluate() {
        writer.print("\\title{");
        c.evaluate();
        writer.print("}\n");
    }
}
/*
\title{Test}
* */