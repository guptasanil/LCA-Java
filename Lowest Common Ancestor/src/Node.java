
public class Node {
	
	private char data;
	private Node parent;
	private int level;
	
	Node(char data, Node parent){
		this.data = data;
		this.parent = parent;
		if(this.parent == null) {
			this.level = 0;
		}
		else {
			this.level = this.parent.getlevel() + 1; 
		}
		
	}

	public int getlevel() {
		return this.level;
	}
	
	public char getParentData() {
		return parent.data;
	}
	
	public Node getParent() {
        return this.parent;
    }

	
	
}