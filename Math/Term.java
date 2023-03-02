package Math;

public class Term {
    public String Value;
    public Term Left;
    public Term Right;

    public Term(String val) {
        Value = val;
    }
    public Term(Term t) {
        Value = new String(t.Value);
        Left = t.Left;
        Right = t.Right;
    }
    public Term(Term root, Term left, Term right) {
        Value = new String(root.Value);
        Left = left;
        Right = right;
    }

    @Override
    public String toString() {
        if (IsSingle()) {
            String str = new String(Value);
            return str;
        }
        else {
            String str = new String("(").concat(Left.toString()).concat(")");
            str = str.concat(Value);
            str = str.concat("(").concat(Right.toString()).concat(")");
            return str;
        }
    }
    public boolean IsOper(Mode mode) {
        return (mode == Mode.SUMDIFF && (Value.equals("+") || Value.equals("-"))) ||
                (mode == Mode.MULTDIV && (Value.equals("*") || Value.equals("/")));
    }
    public boolean IsSingle() {
        return Left == null && Right == null;
    }
}
