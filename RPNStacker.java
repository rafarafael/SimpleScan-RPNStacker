import java.util.Scanner;
import java.util.List;
import java.util.Stack;

public class RPNStacker {

    public static int avaliar(List<Token> tokens){
        
        Stack<String> stack = new Stack<String>();

        for (Token token : tokens) {
            if (token.type == TokenType.NUM) {
                stack.push(token.lexeme);
            } else {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                if (token.type == TokenType.PLUS) stack.push(String.valueOf(op1 + op2));
                else if (token.type == TokenType.MINUS) stack.push(String.valueOf(op1 - op2));
                else if (token.type == TokenType.STAR) stack.push(String.valueOf(op1 * op2));
                else stack.push(String.valueOf(op1 / op2));
            }
        }
        int resultado = Integer.parseInt(stack.pop());
        return resultado;
    } 

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String linha;
        StringBuilder exp = new StringBuilder();
        
        while (in.hasNextLine()) {
            linha = in.nextLine();
            exp.append(linha);
            exp.append(",");
        }

        try {
            List<Token> tokens = Scanning.scan(exp.toString());
            
            // for (Token token : tokens) {
            //     System.out.println(token);
            // }

            int resultado = RPNStacker.avaliar(tokens);
            System.out.println(resultado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        in.close();
    }
}
