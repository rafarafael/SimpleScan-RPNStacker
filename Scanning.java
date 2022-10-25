import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scanning {
    private static boolean isInteger(String str) {
        return str.matches("-?(0|[1-9]\\d*)");
    }

    private static TokenType op (String operator) {
        if (operator.equals("+")) return TokenType.PLUS;
        else if (operator.equals("-")) return TokenType.MINUS;
        else if (operator.equals("*")) return TokenType.STAR;
        else return TokenType.SLASH;
    }

    public static List<Token> scan(String exp) throws Exception {
        String[] simbolos = exp.split(",");
        List<Token> l = new ArrayList<Token>();
        for (String s : simbolos) {
            if (isInteger(s)) {
                Token t = new Token(TokenType.NUM, s);
                l.add(t);
            } else if ("+-/*".indexOf(s) == -1) {
                throw new Exception("Error: Unexpected Token: " + s);
            } else {
                Token t = new Token(op(s), s);
                l.add(t);
            }
        }  
        return l;  
    } 
}
