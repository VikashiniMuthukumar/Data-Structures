import java.util.Scanner;
class Nodee
{
	    int item;
	    Nodee next;

	    Nodee(int d) {
	      item = d;
	      next = null;
	    }
}
class LinkedList {
	Nodee head;
	int size ;

	
    public boolean isEmpty()
    {
        return head == null;
    }
     
    public int getSize()
    {
        return size;
    }    
 
    public void insertAtStart(int data)
    {
    	Nodee new_node = new Nodee(data); 
        size++ ;    
        
         
        	new_node.next = head;
            head = new_node;
         
    }
    
    public void insertAtEnd(int data)
    {
    	 Nodee new_node = new Nodee(data);    
        size++ ;    
        if(head == null) 
        {
        	  head =new_node;
              return;
        }
        new_node.next = null;

        Nodee temp = head;
        while (temp.next != null)
        	temp = temp.next;

        temp.next = new_node;
        return;
    }
    
    public void insertAtPos(int val , int pos)
    {
    	 
        Nodee new_node = new Nodee(val);                
       Nodee temp= head;
         if (pos  == 1) {
    		  
    		  new_node.next = head;
     	      	head =new_node;
     	      	System.out.println("\nNode inserted");
     	      	size++;
     	      	return;
    	  }
    	  else {
    		  for(int i = 1; i < pos-1; i++) 
    		  {
    			  if(temp != null) {
    			        temp = temp.next;
    			      }
      	    } 
    		  if(temp!=null) {
       new_node.next=temp.next; 
      temp.next=new_node;
      size++;
    		  }
    		  else {
    			  System.out.print("\nThe previous node is null.");
    		  }
    	  }
    } 
    void begin_delete()
    {
    	Nodee temp ;
        if(head == null)
        {
        	System.out.println("\nList is empty\n");
        }
        else
        {
    	temp = head;
    	head =temp.next;
    	size--;
    	System.out.println("\nNode deleted from the begining ...\n");
        }
    }
    void last_delete()
    {
    	Nodee temp,temp1 =null;
        if(head == null)
        {
        	System.out.println("\nlist is empty");
        }
        else if(head.next == null)
        {
    	head = null;
    	size--;
    	System.out.println("\nOnly node of the list deleted ...\n");
        }

        else
        {
        	temp= head;
    	while(temp.next != null)
    	{
    		temp1 = temp;
    		temp = temp.next;
    	}
    	temp1.next = null;
    	 size--;
    	System.out.println("\nDeleted Node from the last ...\n");
        }
    }
    void random_delete(int pos)
    {
    	if(head==null)
    	{
    		System.out.println("list is empty.......");
    		return;
    	}
    	Nodee temp=head;
    	if(pos==1)
    	{
    		head=temp.next;
    		size--;
    		return;
    	}
    	
      
      
        for(int i=2 ;temp!=null && i<=pos-1;i++)
         
        	  temp=temp.next;
        	  if(temp==null || temp.next==null)
        		 return;
             
        	  
        	Nodee temp1= temp.next.next; 
        	temp.next=temp1;
        	      size--; 
        System.out.println("\nDeleted node"+(pos));

    }
    void reverse()
    {
    	Nodee next=null;
    	Nodee pre=null;
    	Nodee currentNode=head;
    	while(currentNode!=null)
    	{
    		next=currentNode.next;
    		currentNode.next=pre;
    		pre=currentNode;
    		currentNode=next;
    	}
    	head=pre;
    }
    public void display()
    { 
     
    	   Nodee temp;
    	   temp = head;
    	    if(temp == null)
    	    {
    	    	System.out.println("Nothing to print");
    	    }  
    	    else  
    	    {  
    	    	System.out.println("\nprinting values . . . . .\n");   
    	        while (temp!=null)  
    	        {  
    	        	System.out.print(" -> "+temp.item);  
    	        	temp = temp.next;  
    	        }  
    	    }  
    }
    
    void deleteElement(int key)
    {
         
        Nodee temp = head, prev = null;
  
        if (temp != null && temp.item == key) {
            head = temp.next;  
            return;
        }
      
        while (temp != null && temp.item != key) {
            prev = temp;
            temp = temp.next;
        }
  
        if (temp == null)
            return;
 
         
        prev.next = temp.next;
    }
}
public class SinglyLinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(); 
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
            System.out.println("10. reverse");
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                list.insertAtStart( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to insert");
                list.insertAtEnd( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to insert");
                int num = scan.nextInt() ;
                System.out.println("Enter position");
                int pos = scan.nextInt() ;
                System.out.println("size"+list.getSize());
                if (pos < 1|| pos > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.insertAtPos(num, pos);
                break;  
            case 4 : 
                 
                list.begin_delete();                   
                break;   
            case 5 : 
                list.last_delete();                   
                break;   
            case 6 : 
                System.out.println("Enter position");
                int p = scan.nextInt() ;
                if (p < 1 || p > list.getSize() )
                    System.out.println("Invalid position\n");
                 else
                      list.random_delete(p);
                break;
            case 7 : 
                System.out.println("Empty status = "+ list.isEmpty());
                break;                   
            case 8 : 
                System.out.println("Size = "+ list.getSize() +" \n");
                break; 
            case 9 : 
            	 System.out.println("Enter element to delete");
                 int num1 = scan.nextInt() ;
                list.deleteElement(num1);                   
                break; 
            case 10:
            	 list.reverse();
             default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /*  Display List  */ 
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }

	 

}