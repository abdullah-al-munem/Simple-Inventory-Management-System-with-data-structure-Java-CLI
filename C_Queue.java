
package inventory_management;


/**
 *
 * @author Munem
 */

public class C_Queue {
    
    static class Node {
        
//      Customer Details
        
        String name;
        String email;
        String phone;
        String Address;
        double Totalprice = 0;
        
        
//      Order Details
        
        int Quantity;
        int Item;
        String p_name;
        String Category;
        double price;
        Node next;

        public Node(String name, String email, String phone, String Address, int quantity, C_LinkedList.Node node) {
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.Address = Address;
            this.Quantity = quantity;
            this.Item = node.No;
            this.p_name = node.Name;
            this.Category = node.Category;
            this.price = node.Price;
            Totalprice = Totalprice+(price*Quantity);
        }

        
    }
    
    private Node first = null;
    private Node last = null;

    public void enqueue(Node node) {
        if(last == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
    }
    
    public void dequeue() {
        first = first.next;
        if(first == null)
            last = null;
    }

    public void print() {
        Node node = first;
        while(node != null) {
            System.out.print(" ");
            node = node.next;
        }
    }
    double totalCost(Node temp){
        double sum = 0;
        while(temp!=null)
        {
           sum = sum + temp.Totalprice;
           temp = temp.next;
        }
        return sum;
    }
    
    public void printOrder(){
       Node temp = first;
       int orderCount = 0;
       double sum = 0;
       while(temp!=null)
       {
           if(orderCount == 0){
               System.out.println("User Details: \nName: "+temp.name+".\nPhone: "+temp.phone+".\nEmail: "+temp.email);
               System.out.println("Delivery Address: "+temp.Address);
               orderCount++;
           }
           System.out.println("Prdouct Orderd: "+temp.p_name+". Price: "+temp.price+" TK. Type: "+temp.Category+", Quantity: "+temp.Quantity); 
           sum = sum + temp.Totalprice;
           temp = temp.next;
       }
       System.out.println("Total Cost: "+sum+" Tk.");
   }
    
    
}
