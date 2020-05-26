package ast;

import libs.Node;

public class PAGETITLE extends TITLE{
    CONTENT pagetitle;
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("Title:");
        pagetitle=new CONTENT();
        pagetitle.parse();
    }
    @Override
    public void evaluate() {
        writer.print("\\begin{frame}{");
        pagetitle.evaluate();
        writer.print("}\n");
    }
}




