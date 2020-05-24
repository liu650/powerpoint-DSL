package ast;

import libs.Node;

public class SECTION extends Node {
    SECTIONTITLE title;
    List<PAGE> pages = new ArrayList<PAGE>();
    @Override
    public void parse() {

    }

    @Override
    public void evaluate() {
        title.evaluate();
        for (PAGE p: pages){
            p.evaluate();
        }
    }
}
