
public class BinarySearchTree {
	Node top;
	
	public void BST(){
		top = null;
	}
	public boolean removeNode(Node node, int key){
		if( node == null ){
			return false;
		}
		if(node.getKey() == key ){
			if( (node.getLeft() != null ) && (node.getRight() != null )){
				node.setKey(findNodeKeyToBound(node.getRight()));
			}else if( node.getLeft() != null ){
				top.setLeft(node.getLeft());
				node = null;
			}else if( node.getRight() != null){
				top.setRight(node.getRight());
				node = null;
			}
			return true;
		}
		
//		Be ready for the next node
		top = node;
		if( node.getKey() <= key ){
			return removeNode(node.getRight(), key);
		}else{
			return removeNode(node.getLeft(), key);
		}
	}
	private int findNodeKeyToBound(Node node){
		if (node.getLeft() == null) {
			int key = node.getKey();
			node = null;
			return key;
		}
		return findNodeKeyToBound(node.getLeft());
	}
	public void addNode(int key){
		Node curNode = new Node(key);
		
		if( top == null ){
			top = curNode;
		}else{
			Node topIns = top;
			Node insNode = top;
			
			while( insNode != null){
				topIns = insNode;
				if(key < insNode.getKey() ){
					// move left
					insNode = insNode.getLeft();
				}else if(key >= insNode.getKey()){
					// mode right
					insNode = insNode.getRight();
				}
			}
			
			// we just found where to insert!
			if( key < topIns.getKey() ){
				topIns.setLeft(curNode);
			}else if(key >= topIns.getKey() ){
				topIns.setRight(curNode);
			}
			
		}
	}
	public Node find(Node curNode,int key){
		if( key == curNode.getKey()){
			return curNode;
		}else{
			if( curNode.getLeft() == null && curNode.getRight() == null ){
				return null;
			}
			
			if(key < curNode.getKey()){
				curNode = curNode.getLeft();
			}else if(key > curNode.getKey()){
				curNode = curNode.getRight();
			}
			return find(curNode,key);
		}
	}
	public Node getRootNode(){
		return top;
	}
}
