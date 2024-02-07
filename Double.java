package LinkList;

import java.util.NoSuchElementException;
import java.util.Scanner;

class DNode {
    int element;
    DNode next;
    DNode prev; 
    public DNode(int element) {
        this.element = element;
        this.next =null;
        this.prev = null;
    }
}

public class Double  {
	   DNode head;
	       DNode tail;
	      int size;
	 
	   
	    
	 
	    public int getSize() {
	    	return size; 
	    }     
	 
	    public boolean isEmpty() {
	    	return size == 0; 
	    }
	 
	    public void addFirst(int element) {
	    	DNode newNode = new DNode(element);
	        newNode.next = head;
	        if (head != null)
	            head.prev = newNode;
	        head = newNode;
	        if (tail == null)
	            tail = newNode;
	        size++;
	        System.out.println("Adding element: " + element);
	    	
//	    	DNode newNode = new DNode(element);
//	        newNode.next = head;
//	        newNode.prev = null;
//	        if(head != null ) {
//	        	head.prev = newNode;
//	        }
//	        head = newNode;
//	        
//	        size++;
//	        System.out.println("Adding element: "+element);
	    }
	 
	    public void addLast(int element) {     
	    	 DNode newNode = new DNode(element);
	         if (tail == null) {
	             head = newNode;
	             tail = newNode;
	             size++;
	             System.out.println("Adding element: " + element);
	             return;
	         }
	         tail.next = newNode;
	         newNode.prev = tail;
	         tail = newNode;
	         size++;
	         System.out.println("Adding element: " + element);
//	    	DNode newNode = new DNode(element);
//	        if (head == null) {
//	            head = newNode;
//	            newNode.prev = null;
//	            return;
//	        }
//
//	        DNode last = head;
//
//	        // traverse to the current last node
//	        while (last.next != null)
//	            last = last.next;
//
//	         
//	        last.next = newNode;
//	        newNode.prev = last;
//	        size++;
//	        System.out.println("Adding element: "+element);
	    }
	 
	    public void iterateForward(){         
	        System.out.println("Iterating forward.");
	        DNode tmp = head;
	        while(tmp != null){
	            System.out.println(tmp.element);
	            tmp = tmp.next;
	        }
	    }
	 
	 
	    public void iterateBackward(){         
	        System.out.println("Iterating backword.");
	        DNode tmp = tail;
	        while(tmp != null){
	            System.out.println(tmp.element);
	            tmp = tmp.prev;
	        }
	    }
	 
	    public int removeFirst() {
	        if (size == 0) throw new NoSuchElementException();
	        DNode tmp = head;
	        head = head.next;
	        head.prev = null;
	        size--;
	        System.out.println("Deleted element: "+tmp.element);
	        return tmp.element;
	    }
	    public void deleteByElement(int key) {
	    	DNode current = head;

	        // Traverse the list to find the node with the specified element value
	        while (current != null && current.element != key) {
	            current = current.next;
	        }

	        // If the node is not found
	        if (current == null) {
	            System.out.println("Node with value " + key + " not found.");
	            return;
	        }

	        // Update the pointers of neighboring nodes
	        if (current.prev != null) {
	            current.prev.next = current.next;
	        } else {
	            // If the node to be deleted is the head node
	            head = current.next;
	        }

	        if (current.next != null) {
	            current.next.prev = current.prev;
	        }

	        // Dispose of the memory occupied by the deleted node
	        current = null;
	    }
	    public void removeLast() {
	    	 if (head == null) {
	             System.out.println("List is empty. Cannot remove the last element.");
	             return;
	         }

	         // If there is only one node in the list
	         if (head.next == null) {
	             head = null;
	             return;
	         }

	         DNode current = head;

	         // Traverse to the last node
	         while (current.next != null) {
	             current = current.next;
	         }

	         // Update the pointers of the second-to-last node
	         if (current.prev != null) {
	             current.prev.next = null;
	         } else {
	             // If there are only two nodes in the list
	             head = null;
	         }

	         // Dispose of the memory occupied by the removed node
	         current = null;
	    }
	    public void insertatpos( int item,int position) {
	    	DNode newNode=new DNode(item);
			 if (position == 1 || head == null) {
		            newNode.next = head;
		            if (head != null) {
		                head.prev = newNode;
		            }
		            head = newNode;
		            size++;
		            return;
		        }

			 DNode current = head;
		        int currentPosition = 1;

		        // Traverse to the specified position
		        while (currentPosition < position-1 && current.next != null) {
		            current = current.next;
		            currentPosition++;
		        }

		        // Insert the new node at the specified position
		        newNode.next = current.next;
		        if (current.next != null) {
		            current.next.prev = newNode;
		        }
		        newNode.prev = current;
		        current.next = newNode;
		        size++;
		 }
	    public void insertAfterPosition( int data,int position ) {
	    	//1. allocate node to new element
	    	DNode newNode = new DNode(data); 
	    	  

	    	  //2. check if the position is > 0
	    	  if(position < 1) {
	    	    System.out.print("\nposition should be >= 1.");
	    	  } else if (position == 1) {
	    	    
	    	    //3. if the position is 1, make new node as head
	    	    newNode.next = head;
	    	    head.prev = newNode;
	    	    head = newNode;
	    	  } else {
	    	    
	    	    //4. Else, make a temp node and traverse to the 
	    	    //   node previous to the position
	    	    
	    		  DNode  temp = head;
	    	    for(int i = 1; i < position-1; i++) {
	    	      if(temp != null) {
	    	    	  temp = temp.next;
	    	      }
	    	    }
	    	 
	    	    //5. If the previous node is not null, adjust 
	    	    //   the links
	    	    if(temp != null) {
	    	    	temp.next = temp.next;
	    	    	temp.prev = temp;
	    	    	temp.next = temp;  
	    	      if(temp.next != null)
	    	    	  temp.next.prev = temp;
	    	    } else {
	    	      
	    	      //6. When the previous node is null
	    	      System.out.print("\nThe previous node is null.");
	    	    }       
	    	  }
	    }
	 // function for deleting Nth node
	    public void deletenth (int position)
	    {
	    	// If the list is empty
	        if (head == null) {
	            System.out.println("List is empty. Cannot delete the nth node.");
	            return;
	        }

	        // If the position is 1, delete the head node
	        if (position == 1) {
	            head = head.next;
	            if (head != null) {
	                head.prev = null;
	            }
	            return;
	        }

	        DNode current = head;
	        int currentPosition = 1;

	        // Traverse to the nth node
	        while (currentPosition < position && current != null) {
	            current = current.next;
	            currentPosition++;
	        }

	        // If the nth node is not found
	        if (current == null) {
	            System.out.println("Node at position " + position + " not found.");
	            return;
	        }

	        // Update the pointers of the neighboring nodes
	        if (current.prev != null) {
	            current.prev.next = current.next;
	        }

	        if (current.next != null) {
	            current.next.prev = current.prev;
	        }

	        // Dispose of the memory occupied by the deleted node
	        current = null;
	      
	      
	      
	    }

	       
	public static void main(String[] args) {
		 Double  dll = new Double ();
		 Scanner scan= new Scanner(System.in);
		System.out.println("Singly Linked List Test\n");          
        char ch;
       
        do
        {
            System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at begining");
            System.out.println("5. delete at end");
            System.out.println("6. delete at position");
            System.out.println("7. check empty");
            System.out.println("8. get size");
            System.out.println("9. delete by Element");
            
            System.out.println("10. Display Backward");
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                dll.addFirst( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to insert");
                dll.addLast( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to insert");
                int num = scan.nextInt() ;
                System.out.println("Enter position");
                int pos = scan.nextInt() ;
                System.out.println("size"+dll.getSize());
                if (pos < 1|| pos > dll.getSize() )
                    System.out.println("Invalid position\n");
                else
                    dll.insertatpos(num,pos);
                break;  
            case 4 : 
                 
            	dll.removeFirst();                   
                break;   
            case 5 : 
            	dll.removeLast();                   
                break;   
            case 6 : 
                System.out.println("Enter position");
                int p = scan.nextInt() ;
                if (p < 1 || p > dll.getSize() )
                    System.out.println("Invalid position\n");
                 else
                      dll.deletenth(p);
                break;
            case 7 : 
                System.out.println("Empty status = "+ dll.isEmpty());
                break;                   
            case 8 : 
                System.out.println("Size = "+ dll.getSize() +" \n");
                break; 
            case 9 : 
            	 System.out.println("Enter element to delete");
                 int num1 = scan.nextInt() ;
                 dll.deleteByElement(num1);                   
                break; 
            case 10:
            	dll.iterateBackward();
            
             default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /*  Display List  */ 
            dll.iterateForward();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
    
}