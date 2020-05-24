package ast;

import libs.Node;

public class SECTIONTITLE extends TITLE{
    Content c;

    @Override
    public void evaluate() {
        writer.print("\\section{");
        c.evaluate();
        writer.print("}\n");
    }
}

