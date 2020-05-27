package ast;

import libs.Node;

public class IMAGEPATH extends IMAGEREF{
    //IMAGEPATH::= "Image PATH: " STRING
    String path;
    @Override
    public void parse() {
        //tokenizer.getAndCheckNext("Image PATH:");
        path=tokenizer.getNext();
    }

    @Override
    public void evaluate() {

    }
}



