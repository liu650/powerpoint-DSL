package ast;

import libs.Node;

public class PAGESTUFF extends Node{
    // PAGESTUFF::== POINT | PARAGRAPH | IMAGE
    POINT point;
    PARAGRAPH paragraph;
    IMAGE image;
    @Override
    public void parse() {
        // Parse PAGESTUFF
        switch (tokenizer.getNext()) {
            case "BulletPoint:":
                point = new POINT();
                point.parse();
                break;
            case "Paragraph:":
                paragraph = new PARAGRAPH();
                paragraph.parse();
                break;
            case "Image:":
                image = new IMAGE();
                image.parse();
                break;
            default:
                throw new RuntimeException("Unexpected token!");
        }
    }

    @Override
    public void evaluate() {

    }
    // nothing
}



