import edu.princeton.cs.algs4.*;
@SuppressWarnings("unchecked")

public class EvaluateInfix {

    private static double evaluate(double d1, String operator, double d2) {
        if (operator.equals("+"))
            return d1 + d2;
        else if (operator.equals("-"))
            return d1 - d2;
        else if (operator.equals("*"))
            return d1 * d2;
        else if (operator.equals("/"))
            return d1 / d2;
        else // if (operator.equals("^"))
            return Math.pow(d1, d2);
    }

    private static boolean precedenceGE(String op1, String op2) {
        return precedence(op1) >= precedence(op2);
    }

    private static int precedence(String op) {
        if (op.equals("+")) return 1;
        if (op.equals("-")) return 1;
        if (op.equals("*")) return 2;
        if (op.equals("/")) return 2;
        if (op.equals("^")) return 3;
        if (op.equals("(")) return 0; // low: what's in () is done before the parens themselves
        else return 0; // if (op.equals(")")) return 0;
    }

    private static boolean isOperator(String token) {
        return (token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/") ||
                token.equals("^"));
    }

    public static void main(String[] args) {

        Stack<String> operatorStack = new ResizingArrayStack<String>();
        Stack<Double> valueStack = new ResizingArrayStack<Double>();

        StdOut.print(">> ");
        while (!StdIn.isEmpty()) {
            String token = StdIn.readString();

            if (token.equals("("))
                operatorStack.push(token);
            else if (token.equals(")")) {
                while (!operatorStack.peek().equals("(")) {
                    String operator = operatorStack.pop();
                    double d2 = valueStack.pop();
                    double d1 = valueStack.pop();
                    double val = evaluate(d1, operator, d2);
                    valueStack.push(val);
                }
                operatorStack.pop(); // discard the left paren
            }
            else if (isOperator(token)) {
                String thisOp = token;
                while (!operatorStack.isEmpty() && precedenceGE(operatorStack.peek(), thisOp)) {
                    String operator = operatorStack.pop();
                    double d2 = valueStack.pop();
                    double d1 = valueStack.pop();
                    double val = evaluate(d1, operator, d2);
                    valueStack.push(val);
                }
                operatorStack.push(token /* operator */);
            }
            else valueStack.push(Double.parseDouble(token));
        }
        StdOut.println(valueStack.pop());
    }
}