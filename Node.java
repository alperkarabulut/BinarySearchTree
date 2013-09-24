public class  Node {
	public int key;
	private Node left;
	private Node right;
	
	public Node( int key ) {
		this.key = key;
		this.left = null;
		this.right = null;
	}
	
	public void setLeft(Node left) {
		this.left = left;

	}
	public void setRight(Node right) {
		this.right = right; 
	}
	public void setKey( int k){
		key = k;
	}
	public Node getLeft() {
		return left;

	}
	public Node getRight() {
		return right; 
	}
	public int getKey(){
		return key;
	}
}
