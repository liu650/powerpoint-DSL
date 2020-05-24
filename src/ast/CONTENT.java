package ast;

import libs.Node;
// CONTENT::= "Content:"( ("SETTINGS")?  (STRING) )| FORMULA)
public class CONTENT extends Node {
    SIZE size;
    COLOR color;
    BI bi;
    List<SENTENCE> sentences = new ArrayList<SENTENCE>();
    @Override
    public void parse() {

    }

    @Override
    public void evaluate() { // TODO: refactor
        // TODO
    }
}
