package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;


public class PROGRAM extends Node {
    TITLE title;
    AUTHOR author;
   List<SECTION> sections = new ArrayList<>();
    String start = "";
    String end = "\\end{document}";

    public void parse(){
        // Parse Title
        title = new TITLE();
        title.parse();

        // Parse Tables
//        while(tokenizer.moreTokens()){
//            TABLE t = new TABLE();
//            t.parse();
//            tables.add(t);
//        }
    }

    @Override
    public void evaluate() {
        writer.println(start);

        // Evaluate Title
        title.evaluate();
        // Evaluate author
        author.evaluate();

        // print \maketitle
        String make = "\\maketitle\n";
        writer.println(make);

        // table of contents
        writer.print("\\begin{frame}{Table of contents}\n" +
                "  \\setbeamertemplate{section in toc}[sections numbered]\n" +
                "  \\tableofcontents%[hideallsubsections]\n" +
                "\\end{frame}\n");

        // Evaluate sections
       for (SECTION s : sections){
            s.evaluate();
        }

        writer.println(end);
    }
}
