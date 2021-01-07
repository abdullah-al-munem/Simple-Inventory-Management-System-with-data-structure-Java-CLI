
package inventory_management;

/**
 *
 * @author Munem
 */

public class C_LinkedList {
    
    public static class Node
    {
        int No;
        String Name;
        double Price;
        String Category;
        
        Node next;

        public Node(int No, String Name, double Price, String Category) {
            this.No = No;
            this.Name = Name;
            this.Price = Price;
            this.Category = Category;
        }
        
    }
    
    Node head = null;
    
    public void addAtFront(Node node)
    {
        node.next = head;
        head = node;
    }
    
    public void addAtEnd(Node node)
    {
        if(head == null)
        {
            head = node;
        }
        else
        {
            Node temp = head;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            
            temp.next = node;
        }
    }
    
    public void removeFront()
    {
        head = head.next;
    }
    
    public int lengthOfStack(){
        
        int length=0;
        Node tmp = head;
        while(tmp!=null){
            length++;
            tmp = tmp.next;
        }
        
        return length;
    }
    
    public Node search(int no)
    {
       Node temp;
       temp = head;
       while(temp != null)
       {
           if(temp.No == no)
           {
               return temp;
           }
           temp = temp.next;
       }
        return null;
    }
    public Node searchCat(String cat)
    {
       Node temp;
       temp = head;
       while(temp != null)
       {
           if(temp.Category.equals(cat))
           {
               return temp;
           }
           temp = temp.next;
       }
        return null;
    }
    
    
   public void print()
   {
       Node temp = head;
       while(temp!=null)
       {
           System.out.println("Item No: "+temp.No+", Product Name: "+temp.Name+", Price: "+temp.Price+", Category: "+temp.Category+", Stock: "+100+"\n");
           temp = temp.next;
       }
       
   }
   
   public void viewProductsbyCat(){
       
       Node temp = head;
       int c1 = 0;
       int c2 = 0;
       int c3 = 0;
       int c4 = 0;
       System.out.println("\n===================\n   Products:  \n===================\n\n1.Processor\n2.RAM\n3.HDD & SSD\n4.Graphics Cards\n");
       while(temp!=null)
       {
           if(temp.Category.equals("Processor"))
           {
               
               if(c1==0){
                   System.out.println("\n===================\n   Processors:  \n===================\n");
                   c1++;
               }
               System.out.println("Item No: "+temp.No+", Product Name: "+temp.Name+", Price: "+temp.Price+", Category: "+temp.Category+", Stock: "+100+"\n");
           }
           else if(temp.Category.equals("RAM"))
           {
               
               if(c2==0){
                   System.out.println("\n===================\n   RAMs:  \n===================\n");
                   c2++;
               }
               System.out.println("Item No: "+temp.No+", Product Name: "+temp.Name+", Price: "+temp.Price+", Category: "+temp.Category+", Stock: "+100+"\n");
           }
           
           else if(temp.Category.equals("HDD & SSD"))
           {
               
               if(c3==0){
                   System.out.println("\n===================\n   HDD & SSD:  \n===================\n");
                   c3++;
               }
               System.out.println("Item No: "+temp.No+", Product Name: "+temp.Name+", Price: "+temp.Price+", Category: "+temp.Category+", Stock: "+100+"\n");
           }
           
           else if(temp.Category.equals("Graphics Card"))
           {
               
               if(c4==0){
                   System.out.println("\n===================\n   Graphics Cards:  \n===================\n");
                   c4++;
               }
               System.out.println("Item No: "+temp.No+", Product Name: "+temp.Name+", Price: "+temp.Price+", Category: "+temp.Category+", Stock: "+100+"\n");
           }
           else{
               int c = 0;
               if(c==0){
                   System.out.println("\n===================\n   "+temp.Category+":  \n===================\n");
                   c++;
               }
               System.out.println("Item No: "+temp.No+", Product Name: "+temp.Name+", Price: "+temp.Price+", Category: "+temp.Category+", Stock: "+100+"\n");
           }
           
           temp = temp.next;
       }
       System.out.println();
       System.out.println("==================================================="); 
       
   }
   
   
}
