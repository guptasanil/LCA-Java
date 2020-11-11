public class lca {

	public static char getLCA(Node a, Node b) {
		if (a.getParent() == b.getParent()) {
			return a.getParentData();
		} else if(a == b.getParent()) {
			return b.getParentData();
		} else if(b == a.getParent()) {
			return a.getParentData();
		} else if (a.getlevel() < b.getlevel()) {
			return getLCA(a, b.getParent());
		} else {
			return getLCA(b, a.getParent());
		}
	}
}
