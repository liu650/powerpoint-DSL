package ast;

import libs.Node;

public class FORMULA extends SENTENCE {
    String formula;
    @Override
    public void parse() {
        //tokenizer.getAndCheckNext("Formula:");
        // Parse Color
        formula=tokenizer.getNext();
    }

    @Override
    public void evaluate() {
        // TODO
    }
}
/*
$\sum_{x = 0} ^{\infty} \frac{1}{x}$
 */