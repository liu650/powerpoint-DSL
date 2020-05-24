package ast;

import libs.Node;

public class BI extends Node {
    // BI:: = "bi:" ("Bold" or "Italic")
    boolean bold;
    boolean italic;
    @Override
    public void parse() {

    }

    @Override
    public void evaluate() {
        // do nothing
    }
}
