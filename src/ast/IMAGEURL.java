package ast;

import libs.Node;

public class IMAGEURL extends IMAGEREF{
    String address;
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("Url:");
        address=tokenizer.getNext();
    }

    @Override
    public void evaluate() {
        writer.print(address);
    }

}


