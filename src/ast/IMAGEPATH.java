package ast;

import libs.Node;

public class IMAGEPATH extends IMAGEREF{
    //IMAGEPATH::= "Image PATH: " STRING
    String address;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("Path:");
        address=tokenizer.getNext();
    }

    @Override
    public void evaluate() {
        writer.print(address);
    }
}



