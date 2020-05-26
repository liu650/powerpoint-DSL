package ast;

import java.util.ArrayList;
import java.util.List;

public class IMAGES extends PAGESTUFF {
    //IMAGES ::= “Image:” (IMAGEREF)*
    List<IMAGES> images = new ArrayList<>();

    @Override
    public void parse() {
        //tokenizer.getAndCheckNext("Image:");
        while(tokenizer.moreTokens()){
            //tokenizer.getNext();
            IMAGEREF image = new IMAGEREF();
            image.parse();
            // TODO: fix this
            // images.add(image);
        }
    }

    @Override
    public void evaluate() {
        int len = images.size();
            switch (len) {
                case 0:
                    break;
                case 1:
                    writer.print("\\includegraphics[width=\\textwidth]{");
                    images.get(0).evaluate();
                    writer.print("}\n");
                    break;
                case 2:
                    for (IMAGES i : images) {
                        writer.print("\\includegraphics[width=.5\\textwidth]{");
                        i.evaluate();
                        writer.print("}\n");
                    }
                    break;
                case 3:
                    for (IMAGES i : images) {
                        writer.print("\\includegraphics[width=.3\\textwidth]{");
                        i.evaluate();
                        writer.print("}\n");
                    }
                    break;
                default:
                    for (int i = 0; i < 2; i++) {
                        writer.print("\\includegraphics[width=.5\\textwidth]{");
                        images.get(i).evaluate();
                        writer.print("}\n");
                    }
                    writer.print("\\newline");
                    for (int i = 2; i < 4; i++) {
                        writer.print("\\includegraphics[width=.5\\textwidth]{");
                        images.get(i).evaluate();
                        writer.print("}\n");
                    }
                    writer.print("\\newline");
                    break;
        }
    }
}
/*
        sample IMAGES:
        \includegraphics[width=.5\textwidth]{p1}
 */