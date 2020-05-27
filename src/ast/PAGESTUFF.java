package ast;

import libs.Node;

public class PAGESTUFF extends Node{
    // PAGESTUFF::== POINT | PARAGRAPH | IMAGES
    POINT point;
    PARAGRAPH paragraph;
    IMAGES IMAGES;
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
                IMAGES = new IMAGES();
                IMAGES.parse();
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



