import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import static java.util.Collections.reverse;

/**
 * Created by rashmimech on 1/21/17.
 */
public class PostOrderTraversal {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);

        t.left.left = null;
        t.right.right = null;

        PostOrderTraversal test = new PostOrderTraversal();
        System.out.println(test.postorderTraversal(t));
    }


    public ArrayList<Integer> postorderTraversal(TreeNode a) {
        Stack s = new Stack();
        ArrayList<Integer> result = new ArrayList<Integer>();
        s.push(a);
        while(!s.empty()){
            System.out.println("Hi");
            TreeNode n = (TreeNode) s.pop();
            result.add(n.val);
            if(n.left != null)
                s.push(n.left);
            if(n.right != null)
                s.push(n.right);


        }

        reverse(result);
        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


