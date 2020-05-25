package ast;

import libs.Node;

public class COLOR extends Node {
    // COLOR:: = "Color: " ("red" or "green" or ...)
    String color;
    @Override
    public void parse() {
        //tokenizer.getAndCheckNext("Color:");
        // Parse Color
        color=tokenizer.getNext(); // TODO case sensitive?

        // TODO let the user know if the current color is not supported.
        // throw exception? illegal input
    }

    @Override
    public void evaluate() {
        writer.print(color);
    }
}
