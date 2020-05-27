package ast;

import libs.Node;

public class BI extends Node {
    // BI:: = "bi:" ("Bold" or "Italic")
    //String bi;
    boolean bold;
    boolean italic;
    @Override
    public void parse() {
        //tokenizer.getAndCheckNext("bi:");
        // Parse BI
        switch (tokenizer.getNext()) {
            case "Bold":
                this.bold = true;
                break;
            case "Italic":
                this.italic = true; // TODO case sensitive?
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
