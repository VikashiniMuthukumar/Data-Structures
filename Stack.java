import java.util.Scanner;

public class Stack{
	int top;
	int arr[];
	int capacity;

	Stack(int size){
		arr= new int[size];
		capacity=size;
		top=-1;
	}

	public void push(int x){
		if(isFull()){
			System.out.println("Stack overflow");
		}
		else{
			System.out.println("Inserting the value:"+x);
			top=top+1;
			arr[top]=x;
		}
	}

	public boolean isFull(){
		return top==capacity-1;
	}

	public int pop(){
		if(isEmpty()){
			System.out.println("Stack underflow");
			return 1;
		}
		else{
			return arr[top--];
		}
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	
	public int getSize(){
		return top+1;
	}

	public void printStack(){
		for(int i=top;i>=0;i--)
			System.out.print(arr[i]+" ");
	}
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size:");
		int n=sc.nextInt();
		Stack s=new Stack(n);
		s.push(10);
		s.push(20);
		s.push(30);
		s.printStack();   
		System.out.println("Size:"+s.getSize());
		s.pop();
		s.printStack();
		System.out.println("Size:"+s.getSize());
	}
}