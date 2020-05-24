
import libs.Node;

public class IMAGEREF extends Node{
    String ref;
    @Override
    public void parse() {

    }

    @Override
    public void evaluate() {
        writer.print(ref);
    }
}





