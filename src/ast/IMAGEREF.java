package ast;

import libs.Node;
import libs.Tokenizer;

public class IMAGEREF extends Node{

    String address;

    public static IMAGEREF make(){

        Tokenizer tokenizer = Tokenizer.getTokenizer();
        if (tokenizer.checkToken("Path: ")) {
            return new IMAGEPATH();

        } else if (tokenizer.checkToken("Url: ")) {
            return new IMAGEURL();
        } else {
            throw new RuntimeException("Invalid value: " + tokenizer.getNext());
        }
    }
    @Override
    public void parse() {
    }

    @Override
    public void evaluate() {
        writer.print(address);
    }
}





