package Math;

import java.util.List;
import java.util.ArrayList;

enum Mode {
    SUMDIFF, MULTDIV
}
public class Parser {

    public Term Parse(String expr) {
        List<Term> lst = BuildList(expr);
        Term res = StartParsing(lst);

        return res;
    }
    private Term StartParsing(List<Term> lst) {
        while (lst.size() != 3) {
            if (lst.get(1).IsOper(Mode.SUMDIFF)) {
                lst = A(lst);
                lst = B(lst, 2);
            }
            else if (lst.get(1).IsOper(Mode.MULTDIV)) {
                lst = B(lst, 0);
            }
        }

        return new Term(lst.get(1), lst.get(0), lst.get(2));
    }
    private List<Term> A(List<Term> lst) {
        while (lst.size() > 3 && lst.get(3).IsOper(Mode.SUMDIFF)) {
            Term t = new Term(lst.get(1), lst.get(0), lst.get(2));
            for (int i = 0; i < 3; i++) {
                lst.remove(0);
            }
            lst.add(0, t);

            // lst = lst.subList(3, lst.size());
        }

        return lst;
    }
    private List<Term> B(List<Term> lst, int start) {
        while (lst.size() > start + 1 && lst.get(start + 1).IsOper(Mode.MULTDIV)) {
            Term t = new Term(lst.get(start + 1), lst.get(start + 0), lst.get(start + 2));
            for (int i = 0; i < 3; i++) {
                lst.remove(start);
            }
            lst.add(start, t);
        }

        return lst;
    }
    private ArrayList<Term> BuildList(String expr) {
        ArrayList<Term> res = new ArrayList<Term>();
        int i = 0;
        while (i < expr.length()) {
            if (!Character.isDigit(expr.charAt(i))) {
                res.add(new Term(Character.toString(expr.charAt(i))));
                i++;
            } else {
                int j = i;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    i++;
                }
                res.add(new Term(expr.substring(j, i)));
            }
        }

        return res;
    }
}
