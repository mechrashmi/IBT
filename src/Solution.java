import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();

        System.out.println(encrypt(n, s, k));

    }


    public static String encrypt(int n, String s, int k){
        StringBuilder str = new StringBuilder(s);
        for(int i = 0; i < n; i++){
            char c = str.charAt(i);
            if(c >= 'a' && c <= 'z' ){
                c = (char)(c + k);
                if(c > 'z')
                    c = (char)(c - 'a');
            }
            else if (c >= 'A' && c <= 'Z'){
                c = (char)(c + k);
                if(c > 'Z')
                    c = (char)(c - 'A');
            }
            str.setCharAt(i, c);
            System.out.println(c);
        }
        return str.toString();
    }
}

