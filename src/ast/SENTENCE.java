package ast;

import libs.Node;
public class SENTENCE extends Node {
    String s;
    @Override
    public void parse() {

    }

    @Override
    public void evaluate() {
        writer.print(s);
    }
}



