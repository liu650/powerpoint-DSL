package ast;

import libs.Node;

public class SIZE extends Node {
    // SIZE::= "Size: " ("LARGE" or "Large" or "large" or "small")
    String size = null;
    @Override
    public void parse() {
        // throw exception if size != one of (LARGE, Large, large)
    }

    @Override
    public void evaluate() {
        // do nothing
    }
}
