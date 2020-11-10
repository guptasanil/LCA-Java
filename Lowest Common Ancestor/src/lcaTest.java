import static org.junit.Assert.*;

import org.junit.Test;

public class lcaTest {
	
	/*
   				F
   				/\
  			   /  \
 		      A    C
 		     /\     \
 		    /  \     \
 		   H    E     I
 		   	   / \     \
 		   	  /   \     \
 		   	 B     T     D
  
   * 

*/

	
	@Test
	
	
	public void lcatest() {
		Node f = new Node('F', null);
        Node a = new Node('A', f);
        Node c = new Node('C', f);
        Node h = new Node('H', a);
        Node e = new Node('E', a);
        Node i = new Node('I', c);
        Node b = new Node('B', e);
        Node t = new Node('T', e);
        Node d = new Node('D', i);
        
        
        assertEquals('A', lca.getLCA(h, t));
        assertEquals('F', lca.getLCA(b, d));
        assertEquals('F', lca.getLCA(b, i));
        assertEquals('E', lca.getLCA(b, t));
        assertEquals('0', lca.getLCA(f, a));
	}

}