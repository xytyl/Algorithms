package altext;

import java.util.Stack;

public class eva {
    public static void main(String[] args) { 
        Stack<String> ops  = new Stack<String>();
        Stack<String> vals = new Stack<String>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if      (s.equals("("))               ;
            else if (s.equals("+"))    ops.push(s);
            else if (s.equals("-"))    ops.push(s);
            else if (s.equals("*"))    ops.push(s);
            else if (s.equals("/"))    ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                String v = vals.pop();
                Double v1 = Double.parseDouble(v);
                if      (op.equals("+"))    v1 = Double.parseDouble(vals.pop()) + v1;
                else if (op.equals("-"))    v1 = Double.parseDouble(vals.pop()) - v1;
                else if (op.equals("*"))    v1 = Double.parseDouble(vals.pop()) * v1;
                else if (op.equals("/"))    v1 = Double.parseDouble(vals.pop()) / v1;
                v=v1+" ";
                vals.push(v);
            }
            else vals.push(s);
        }
        StdOut.println(vals.pop());
    }
}