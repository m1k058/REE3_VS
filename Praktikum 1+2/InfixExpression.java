import java.util.*;

/**
 * Write a description of class InfixExpression here.
 *
 * @author Michal Kos
 * @version 15.10.2025
 */
public class InfixExpression
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class InfixExpression
     */
    public InfixExpression()
    {
        System.out.println("infix2postfix Test:\n-----------------------------------------------------------");
        String[] ti = {
        "( ( 8.8 / 2.2 ) * 0.2 )",
        "( ( ( ( 6 + 4 ) ^ 2 ) - 5 ) / 2 )",
        "( ( 3 * 8 ) + ( ( sqrt 9 ) / 3 ) )",
        "( ( ( 4 * ( e 4 ) ) - 1 ) + ( sqrt 2 ) )",
        "( ( ( ( ( 3 - 2 ) * 4 ) / 2 ) * ( sqrt 4 ) ) ^ 2 )",
        "( ( ( ( ( ( 5 ^ 4 ) ^ 2 ) ^ 4 ) + 9 ) - 8 ) / 2 )",
        "( ( ( ( sqrt ( 4 ) * sqrt ( 9 ) ) - 6 ) * 6 ) + 4 )"};
        
        for (String e: ti){
            System.out.println(" Infix: " + e + "\n Postfix: " + infix2postfix(e) + "\n-----------------------------------------------------------");
        }
        for (String e: ti){
            System.out.println(infix2postfix(e));
        }

    }

    /**
     * Converts infix expressions to postfix expressions.
     *
     * @param  String of a infix expression
     * @return  String of converted input to postfix
     */
    private String infix2postfix(String infix)
    {
        StringTokenizer st = new StringTokenizer(infix);
        Stack op = new Stack();
        String out = "";
        while(st.hasMoreTokens()){
            String t = st.nextToken();
            if (isDouble(t)){
                out = out + " " + t;
            }
            else if (t.contains("+") || t.contains("-") || t.contains("*") || t.contains("/") || t.contains("^") || t.contains("sqrt") || t.contains("e")){
                op.push(t);
            }
            else if(t.contains(")")){
                out = out + " " + op.pop();
            }
            else{
                // nichts
            }
        }
        return out;
    }
    
    private boolean isDouble(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
