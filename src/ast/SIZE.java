package ast;

import libs.Node;

public class SIZE extends Node {
    // SIZE::= "Size: " ("LARGE" or "Large" or "large" or "small")
    String size = null;
    @Override
    public void parse() {
        switch (tokenizer.getNext()) {
            case "small":
                size = "\\tiny";
                break;
            case "normal":
                size = "\\normalsize";
                break;
            case "big":
                size = "\\Large";
                break;
            case "large":
                size = "\\LARGE";
                break;
            case "huge":
                size = "\\Huge";
                break;
            default:
                throw new RuntimeException("Unexpected token!");
        }
    }

    @Override
    public void evaluate() {
        // do nothing
    }
}
