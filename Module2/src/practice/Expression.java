package practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class Expression {
    private final Deque<Character> stack = new ArrayDeque<>();

    public boolean isValidExpression(String expression) {
        for(char c : expression.toCharArray()){
            if(c == '('){
                stack.push('(');
            }
            else if(c == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Expression expression = new Expression();
        String  expression1 = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";
        System.out.println(expression.isValidExpression(expression1));
    }
}
