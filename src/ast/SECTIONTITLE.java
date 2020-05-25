package ast;

import libs.Node;

public class SECTIONTITLE extends TITLE{
    CONTENT sectiontitle;
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("Title:");
        sectiontitle=new CONTENT();
        sectiontitle.parse();
    }
    @Override
    public void evaluate() {
        writer.print("\\section{");
        sectiontitle.evaluate();
        writer.print("}\n");
    }
}

