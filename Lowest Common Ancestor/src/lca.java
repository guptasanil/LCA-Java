
public class lca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
	}

	public static char getLCA(Node a, Node b) {
		 if ((a.getParent() != null) && (b.getParent() != null)) {
	            if (a.getParent() == b.getParent()) {
	                return a.getParentData();
	            } else if (a.getlevel() < b.getlevel()){
	                return getLCA(a, b.getParent());
	            } else {
	                return getLCA(b, a.getParent());
	            }
	        }
	        return '0';
	    }
}
