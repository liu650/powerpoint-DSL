package ast;

import libs.Node;

public class PAGETITLE extends TITLE{
    Content c;

    @Override
    public void evaluate() {
        writer.print("\\begin{frame}{");
        c.evaluate();
        writer.print("}\n");
    }
}





