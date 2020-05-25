package ast;

import libs.Node;

public class IMAGEREF extends Node{
    //IMAGEREF::= URL|PATH
    String ref;
    IMAGEURL imageurl;
    IMAGEPATH imagepath;

    @Override
    public void parse() {

        // Parse IMAGEREF
        switch (tokenizer.getNext()) {
            case "Image Url:":
                imageurl=new IMAGEURL();
                imageurl.parse();
                break;
            case "Image PATH:":
                imagepath =new IMAGEPATH();
                imagepath.parse();
                break;
            default:
                throw new RuntimeException("Unexpected token!");
        }
    }

    @Override
    public void evaluate() {
        writer.print(ref);
    }
}





