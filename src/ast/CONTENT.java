package ast;
import java.util.ArrayList;
import java.util.List;
import libs.Node;
public class CONTENT extends Node {
    SIZE size = null;
    COLOR color = null;
    BI bi = new BI();
    String sentence = ""; // from list of sentence to single sentence
    @Override
    public void parse() {
        //TODO
        // Parse Content
        // the following has been changed in the latest github version

//            case "Settings:":
//                // Parse Settings
//                SETTINGS settings = new SETTINGS();
//                settings.parse();
//                content=tokenizer.getNext();
//                break;
//            case "Formula:":
//                FORMULA formula = new FORMULA();
//                formula.parse();
//                break;
        // TODO: debug
        // modified grammar by adding keywords "Size: " "BI: "...
        if (tokenizer.checkToken("@\\(")) {
            tokenizer.getNext();
            while (tokenizer.moreTokens() && !tokenizer.checkToken("\\)@")) {
                if (tokenizer.checkToken("Size:")) {
                    size = new SIZE();
                    size.parse();
                }
                if (tokenizer.checkToken("Bi:")) {

                    bi.parse();
                }
                if (tokenizer.checkToken("Color:")) {
                    color = new COLOR();
                    color.parse();
                }
            }
            tokenizer.getAndCheckNext("\\)@");
        }
        sentence = tokenizer.getNext();
        System.out.println("SENTENCE IS __:    " + sentence);

        /*
        // take sentences input
        while (tokenizer.moreTokens() && !tokenizer.checkToken("FORMULA:")){
            // TODO: need to add termination symbol for sentences
            SENTENCE s = new SENTENCE();
            s.parse();
            sentences.add(s);
        }
        */
    }

    @Override
    public void evaluate() {
        // TODO: change this method to toString later
        // TODO: implement a real evaluate()
        // TODO {\it {\bf{\Large {\color{blue} Large bold italic blue } } }}\newline
        System.out.println("process CONTENT: ");
        /*
        if (size != null){
            System.out.println("process SIZE = " + size.toString());
        } if (bi != null) {
            System.out.println("process BI = " + bi.toString());
        } if (color != null) {
            System.out.println("process COLOR = " + color.toString());
        }
         */

            System.out.println("process SENTENCE: " + sentence.toString());
            // TODO ==================================================================
            if (!bi.italic && !bi.bold && size == null && color == null) {
                //0000
                writer.println(sentence);
            }
            if (!bi.italic && !bi.bold && size == null && color != null) {
                // 0001
                writer.println("{\\color{" + color.color + "}" + sentence + "}");
            }
            if (!bi.italic && !bi.bold && size != null && color == null) {
                //0010
                writer.println("{\\" + size.size + " " + sentence + "}");
            }
            if (!bi.italic && !bi.bold && size != null && color != null) {
                // 0011
                writer.println("{\\" + size.size + "{\\color{" + color.color + "}" + sentence + "}}" );
            }
            if (!bi.italic && bi.bold && size == null && color == null) {
                //0100
                writer.println("{\\bf "  + sentence + "}");
            }
            if (!bi.italic && bi.bold && size == null && color != null) {
                //0101
                // TODO {\it {\bf{\Large {\color{blue} Large bold italic blue } } }}\newline
                writer.println("{\\bf{\\color{" +color.color +"}" + sentence + "}}" );
            }
            if (!bi.italic && bi.bold && size != null && color == null) {
                //0110
                writer.println("{\\bf{\\" + size.size + " " + sentence + "}}");
            }
            if (!bi.italic && bi.bold && size != null && color != null) {
                // 0111
                writer.println("{\\bf{\\" + size.size + "{\\color{" + color.color + "}" + sentence + "}}}");
            }
            if (bi.italic && !bi.bold && size == null && color == null) {
                // 1000
                writer.println("{\\it " + sentence + "}");
            }
            if (bi.italic && !bi.bold && size == null && color != null) {
                // 1001
                writer.println("{\\it{\\color{" + color.color + "}" +sentence + "}}" );
            }
            if (bi.italic && !bi.bold && size != null && color == null) {
                // 1010
                writer.println("{\\it{\\" + size.size + " " + sentence + "}}");
            }
            if (bi.italic && !bi.bold && size != null && color != null) {
                // 1011
                writer.println("{\\it{\\" + size.size + "{\\color{" + color.color + "}" + sentence + "}}}");
            }
            if (bi.italic && bi.bold && size == null && color == null) {
                // 1100
                writer.println("{\\it{\\bf " + sentence + "}}");
            }
            if (bi.italic && bi.bold && size == null && color != null) {
                // 1101
                writer.println("{\\it{\\bf{\\color{" + color.color + "}" + sentence + "}}}");
            }
            if (bi.italic && bi.bold && size != null && color == null) {
                // 1110
                writer.println("{\\it{\\bf{\\" + size.size + " " + sentence + "}}}");
            }
            if (bi.italic && bi.bold && size != null && color != null) {
                // 1111
                writer.println("{\\it{\\bf{\\" + size.size + "{\\color{" + color.color +"}" + sentence + "}}}}");
            }
    }
}
