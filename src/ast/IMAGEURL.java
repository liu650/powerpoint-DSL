package ast;

import libs.Node;

public class IMAGEURL extends Node{
    String url;
    @Override
    public void parse() {
        //tokenizer.getAndCheckNext("Image Url:");
        url=tokenizer.getNext(); //TODO Should we verify yrl?
    }

    @Override
    public void evaluate() {

    }
}


