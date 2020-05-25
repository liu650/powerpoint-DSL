package ast;
import java.util.ArrayList;
import java.util.List;

import libs.Node;
// CONTENT::= "Content:"( ("SETTINGS")?  (STRING) )| FORMULA)
public class CONTENT extends Node {
    SIZE size;
    COLOR color;
    BI bi;
    List<SENTENCE> sentences = new ArrayList<SENTENCE>();
    String content;
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("Content:");
        // Parse Content
        switch (tokenizer.getNext()) {
            case "Settings:":
                // Parse Settings
                SETTINGS settings = new SETTINGS();
                settings.parse();
                content=tokenizer.getNext();
                break;
            case "Formula:":
                FORMULA formula = new FORMULA();
                formula.parse();
                break;//TODO can formula follow with content?
            default:
                content=tokenizer.getNext();

        }
    }

    @Override
    public void evaluate() { // TODO: refactor
        // TODO
    }
}
