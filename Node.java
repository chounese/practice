public class Node<T>{
	private Node<T> parent;
	private Node<T> next;
	//T is a generic class
	private T content;
	//Change content based on use

	//Getters
	public Node<T> getParent(){
		return parent;
	}
	public Node<T> getNext(){
		return next;
	}
	public T getContent(){
		return content;
	}

	//Setters
	public void setParent(Node<T> p){
		parent=p;
	}
	public void setNext(Node<T> n){
		next=n;
	}
	public void setContent(T s){
		content=s;
	}

	//First Node Constructor
	public Node(T c){
		parent=null;
		next=null;
		content=c;
	}

	//Other Node Constructor
	public Node(Node<T> p, T c){
		parent=p;
		content=c;
	}
}