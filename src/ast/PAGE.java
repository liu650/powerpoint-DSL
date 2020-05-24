package ast;

import libs.Node;

public class PAGE extends Node {
    PAGETITLE title;
    List<PAGESTUFF> pstf = new ArrayList<>();

    @Override
    public void parse() {

    }

    @Override
    public void evaluate() {
        title.evaluate();
        for (PAGESTUFF ps: pstf) {
            ps.evaluate();
        }
        String end  = "\\end{frame}";
        writer.println(end);
    }
}
/*
* sample page:
* \begin{frame}{title(as string)}
   ......
\end{frame}
* */