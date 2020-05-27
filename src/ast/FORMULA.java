package ast;

import libs.Node;

public class FORMULA extends SENTENCE {
    String formula;
    @Override
    public void parse() {
        //TODO: take string temporary, need to convert it to a LaTex expression
        tokenizer.getAndCheckNext("Formula:");
        // Parse Color
        formula=tokenizer.getNext();
    }

    @Override
    public void evaluate() {
        // TODO
        System.out.println("Process formula:" + formula);
    }
}
/*
$\sum_{x = 0} ^{\infty} \frac{1}{x}$
 */