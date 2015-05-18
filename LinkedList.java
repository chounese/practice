//Implementation of a doubly linked list with elements of type T where T is a generic type
//Similar to ArrayList<T>
public class LinkedList<T>{
	private Node<T> start;
	private Node<T> end;
	private int size;

	//Getters
	public Node<T> getStart(){
		return start;
	}
	public Node<T> getEnd(){
		return end;
	}
	public int getSize(){
		return size;
	}


	//Setters
	public void setStart(Node<T> s){
		start=s;
	}
	public void setEnd(Node<T> e){
		end=e;
	}
	public void setSize(int si){
		size=si;
	}
	public void incrementSize(){
		size=size+1;
	}
	public void decrementSize(){
		size=size-1;
	}

	//Constructor no args
	public LinkedList(){
		start=null;
		end=null;
		size=0;
	}

	//Constructor one arg T is a generic class
	public LinkedList(T data){
		Node<T> newNode=new Node<T>(data);
		start=newNode;
		end=newNode;
		incrementSize();
	}


	//Add to end
	public void add(T cont){
		if (start==null){
			Node<T> newNode=new Node<T>(cont);
			start=newNode;
			end=newNode;
			incrementSize();
		}
		else{
			Node<T> newNode=new Node<T>(end,cont);
			newNode.setParent(end);
			end=newNode;
			incrementSize();
		}
	}

	//Add to index should be here
	//public void add(int index)

	//Remove from front
	public Node<T> remove(){
		Node<T> s=getStart();
		Node<T> n=getStart().getNext();
		n.setParent(null);
		start=n;
		return s;
	}

	//Remove targeted node
	public Node<T> remove(Node<T> n){
		n.getParent().setNext(n.getNext());
		n.getNext().setParent(n.getParent());
		decrementSize();
		return n;
	}

	//Remove node by index
	public Node<T> remove(int index){
		Node<T> current = getStart();
		int counter=0;
		while (current.getNext()!=null){
			if (counter==index){
				return remove(current);
			}
			else{
				counter++;
			}
		}
		//Catch last case
		if (counter==index){
			return remove(current);
		}
		else{
			System.out.println("Error index is out of bounds");
			return null;
		}
	}

	//Removes first instance of target content
	public Node<T> remove(T c){
		//Need to be careful with the comparison with generic types
		//**Something to fix
		Node<T> n=start;
		while(n.getNext()!=null){
			if (n.getContent().equals(c)){
				n.getParent().setNext(n.getNext());
				n.getNext().setParent(n.getParent());
				decrementSize();
				return n;
			}
			else{
				n=n.getNext();
			}
		}
		if (n.getContent().equals(c)){
			n.getParent().setNext(n.getNext());
			n.getNext().setParent(n.getParent());
			decrementSize();
			return n;
		}
		else{
			System.out.println("Error Node is not an element of this linked list");
			return null;
		}
	}

	//Contains
	public boolean contains(T c){
		//Same possible issue with generic typing comparisons
		Node<T> n=start;
		while (n.getNext()!=null){
			if (n.getContent().equals(c)){
				return true;
			}
			else{
				n=n.getNext();
			}
		}
		return false;
		
	}

}