import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by rashmimech on 2/25/17.
 Given an absolute path for a file (Unix-style), simplify it.

 Examples:

 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"

 Note that absolute path always begin with ‘/’ ( root directory )
 Path will not have whitespace characters
 */
public class SimplifyPath {
    public static void main(String[] args) {
        //String input = new String("/annn/./bmmmm/../cmmmm/ ");
        String input = new String("/../");
        System.out.println(new SimplifyPath().simplifyPath(input));
    }
    public String simplifyPath(String a) {
        if(a == null || a.equals("")) return a;
        String[] arrayOfPath = a.split("/");

        Stack<String> directories = new Stack<>();
        for(String dir : arrayOfPath){

            if(dir.equals("..") && !directories.isEmpty()){
                directories.pop();
                continue;
            }
            else if(dir.equals(".") || dir.equals("") || dir.equals(" ")){
                continue;
            }
            else if(dir.equals("..")){
                continue;
            }
            directories.push(dir);
        }

        StringBuffer res = new StringBuffer();
        ArrayList<String> simplifoedRoot = new ArrayList<>();
        while(!directories.isEmpty()){
            simplifoedRoot.add(directories.pop());
            simplifoedRoot.add("/");
        }

        for(int i = simplifoedRoot.size() - 1; i >= 0; i--){
            res.append(simplifoedRoot.get(i));
        }

        if(res.length() == 0){
            res.append("/");
        }
        return res.toString();
    }
}

