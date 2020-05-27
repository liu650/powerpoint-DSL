package ast;

import libs.Node;
import java.util.ArrayList;
import java.util.List;

public class IMAGE extends PAGESTUFF {
    //IMAGE ::= “Image:” (IMAGEREF)*
    List<IMAGEREF> images = new ArrayList<>();
    @Override
    public void parse() {
        //tokenizer.getAndCheckNext("Image:");
        while(tokenizer.moreTokens()){
            //tokenizer.getNext();
            IMAGEREF i = new IMAGEREF();
            i.parse();
            images.add(i);
        }
    }

    @Override
    public void evaluate() {
        int len = images.size();
        switch(len) {
            switch (len) {
                case 0:
                    break;
                case 1:
                    writer.print("\\includegraphics[width=\\textwidth]{");
                    images.get(0).evaluate();
                    writer.print("}\n");
                    break;
                case 2:
                    for (IMAGE i: images ) {
                        writer.print("\\includegraphics[width=.5\\textwidth]{");
                        i.evaluate();
                        writer.print("}\n");
                    }
                    break;
                case 3:
                    for (IMAGE i: images ) {
                        writer.print("\\includegraphics[width=.3\\textwidth]{");
                        i.evaluate();
                        writer.print("}\n");
                    }
                    break;
                default:
                    for (int i = 0; i < 2; i++) {
                        writer.print("\\includegraphics[width=.5\\textwidth]{");
                        i.evaluate();
                        writer.print("}\n");
                    }
                    writer.print("\\newline");
                    for (int i = 2; i < 4; i++) {
                        writer.print("\\includegraphics[width=.5\\textwidth]{");
                        i.evaluate();
                        writer.print("}\n");
                    }
                    writer.print("\\newline");
                    break;
            }
        }
    }
}
/*
        sample image:
        \includegraphics[width=.5\textwidth]{p1}
 */