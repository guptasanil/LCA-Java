//I used the website GeeksforGeeks to help me with solving this problem
//the url is http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/


import java.util.ArrayList;
import java.util.List;

public class lca {

    static Node root;
    private static List<Integer> patha = new ArrayList<>();
    private static List<Integer> pathb = new ArrayList<>();
 
    static int getLCA(int a, int b) {
        patha.clear();
        pathb.clear();
        return getLCA(root, a, b);
    }
 
    private static int getLCA(Node root, int a, int b) {
 
        if (!getPath(root, a, patha) || !getPath(root, b, pathb)) {
        	
        	if (patha.size() > 0) {
        		System.out.println("a is in the path");
			}
        	else {
        		System.out.println("a is not in the path");
        	}
        	if(pathb.size() > 0) {
        		System.out.println("b is in the path");
        	}
        	else {
        		System.out.println("b is not in the path");
        	}
            return -1;
        }
    		int i;
        for (i = 0; i < patha.size() && i < pathb.size(); i++) {
            if (!patha.get(i).equals(pathb.get(i)))
                break;
        }
 
        return patha.get(i-1);
    }
     
    private static boolean getPath(Node root, int c, List<Integer> path)
    {
        if (root == null) {
            return false;
        }
        path.add(root.value);
 
        if (root.value == c) {
            return true;
        }
 
        if (root.left != null && getPath(root.left, c, path)) {
            return true;
        }
 
        if (root.right != null && getPath(root.right, c, path)) {
            return true;
        }
 
        path.remove(path.size()-1);
 
        return false;
    }
 
}