package ast;

import libs.Node;

public class POINT extends PAGESTUFF {
    List<CONTENT> loc = new ArrayList<>();
    @Override
    public void parse() {

    }

    @Override
    public void evaluate() {
        writer.print("\\begin{itemize}\n");
        for (CONTENT c: loc) {
            writer.print("\\item ");
            c.evaluate();
        }
        writer.println("\\end{itemize}\n");
    }
}

/*
* sample:
* \begin{itemize}
        \item {\bf{bold font item}}
        \item {\Large{Large item}}
        \item {\color{blue} blue item}
        \item {plain item}
    \end{itemize}
* */
