package ui;

import ast.PROGRAM;
import libs.Node;
import libs.Tokenizer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        List<String> literals = Arrays.asList("Title:", "Table:","[","]","|", "Content:", "COLOR:", "SIZE:", "BI:"
                , " "); // TODO: space, in theory, should not be a literal.
        Tokenizer.makeTokenizer("input.thtml",literals);
        Node.setWriter("output.html");
        PROGRAM p = new PROGRAM();
        System.out.println("Done tokenizing");
        p.parse();
        System.out.println("Done parsing");
        p.evaluate();
        System.out.println("Done evaluation");
        Node.closeWriter();
    }

}
