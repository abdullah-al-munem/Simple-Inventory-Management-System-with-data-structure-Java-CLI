
package inventory_management;

/**
 *
 * @author Munem
 */

public class C_Stack {
    
    int count = 0;
    
    
    static class Node {
        
        C_Queue.Node list2;
        Node next;

        public Node(C_Queue.Node list2) {
            this.list2 = list2;
        }

    }

    private Node top = null;

    public void push(Node node) {
        node.next = top;
        top = node;
        count++;
    }
    
    public int lengthOfStack(){
        
        int length=0;
        Node tmp = top;
        while(tmp!=null){
            length++;
            tmp = tmp.next;
        }
        
        return length;
    }

    public Node pop() {
        Node temp;
        temp = top;
        top = top.next;
        return temp;
    }
    
    public void print() {
      
      Node temp = top;
      
       
      System.out.println("===================================================");
      System.out.println("\t/// Monthly Report ///\n");
      System.out.println("Total Item Sold: "+count);
      
      double sum = 0;
      //C_Queue tmp = new C_Queue();
      while(temp != null) {

            //temp = pop();
            //double totalCost = tmp.totalCost(temp.list2);
            
            double totalCost = (temp.list2.price*temp.list2.Quantity);
            sum += totalCost;
            System.out.println("Customer Name: "+temp.list2.name+"\nItem No: "+temp.list2.Item+", Item Name: "+temp.list2.p_name+", Price: "+temp.list2.price+", Category: "+temp.list2.Category+", Quantity: "+temp.list2.Quantity);
            System.out.println("Total Cost: "+totalCost+" Tk.");
            
            temp = temp.next;
      }
      
      System.out.println();
      System.out.println("\t /// Total Monthly Income ///\n");
      System.out.println("Monthly Income: "+sum+" Tk.");
      System.out.println("===================================================");
      
    }
    
    public void popReport(){
        Node temp;
        int length = lengthOfStack();
        for(int i=0; i<length; i++){
            temp = pop();
        }
        count = 0;
        System.out.println("\n All the data of Previous Month Report has been Deleted. \n");
    }
    
    
    
}
