import java.util.Stack;

/**
 Write a program to validate if the input string has redundant braces?
 Return 0/1
 0 -> NO 1 -> YES

 Input will be always a valid expression

 and operators allowed are only + , * , - , /

 Example:

 ((a + b)) has redundant braces so answer will be 1
 (a + (a + b)) doesn't have have any redundant braces so answer will be 0
 */


public class RedundabtBraces {

    public static void main(String[] args) {
        System.out.println(new RedundabtBraces().braces("(a + b)"));
    }
    public int braces(String a) {
        Stack<Character> bracesStack = new Stack<>();
        //Stack<String> operationsStack = new Stack<>();

        for(int i = 0; i < a.length(); i++){
            char c = a.charAt(i);
            if(c == '('){
                bracesStack.push(c);
            }
            else if(c == '*' || c == '+' || c == '-' || c == '/'){
                if(!bracesStack.isEmpty()){
                    bracesStack.pop();
                }
            }
        }

        if(!bracesStack.isEmpty())
            return 1;

        return 0;
    }
}
