import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by rashmimech on 2/27/17.

 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Examples:

 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

 */


public class EvaluateExpression {
    public static void main(String[] args) {
        //String[] strings = new String[]{"2", "1", "+", "3", "*"};
        String[] strings = new String[]{"5", "1", "2", "+", "4", "*", "+", "3", "-"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(strings));

        System.out.println(new EvaluateExpression().evalRPN(arrayList));
    }

    public int evalRPN(ArrayList<String> a) {
        Stack<Integer> stack = new Stack<>();

        for(String val : a){
            int res = 0;
            int val1;
            int val2;
            if(val.equals("*")){
                val1 = stack.pop();
                val2 = stack.pop();
                res = val2 * val1;
                stack.push(res);
            }
            else if(val.equals("/")){
                val1 = stack.pop();
                val2 = stack.pop();
                res = val2 / val1;
                stack.push(res);
            }
            else if(val.equals("+")){
                val1 = stack.pop();
                val2 = stack.pop();
                res = val2 + val1;
                stack.push(res);
            }
            else if(val.equals("-")){
                val1 = stack.pop();
                val2 = stack.pop();
                res = val2 - val1;
                stack.push(res);
            }
            else{
                stack.push(Integer.parseInt(val));
            }
        }

        return stack.pop();
    }
}
