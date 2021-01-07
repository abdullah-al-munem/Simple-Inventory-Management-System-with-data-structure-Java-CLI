
package inventory_management;

/**
 *
 * @author Munem
 */

        // Limitations:
        /* 1. You can can't add categories dynamically. If you add categories dynamically then those
              categories will show multiple times when you select the First Option (View All Available Items). 
              But you can buy producs from those categories. Because those products will be visiable 
              when you select the Third Option (Order An Item(s)). 

            2. 

        */

import java.util.*;

public class Inventory_Management {


    public static void main(String[] args) {
        
        
       //       Functionalities
        
        C_LinkedList list = new C_LinkedList();
        C_LinkedList.Node node;
        C_Queue queue = new C_Queue();
        C_Queue.Node qNode;
        C_Stack stack = new C_Stack();
        C_Stack.Node sNode;
        Scanner scan = new Scanner(System.in);
        
        C_Queue tmpLast = new C_Queue();
        
        // adding some product manually 
        
        C_LinkedList.Node node2;
        node2 = new C_LinkedList.Node(1, "Intel 9th Gen Core i3", 8100, "Processor");
        list.addAtEnd(node2);
        
        C_LinkedList.Node node3;
        node3 = new C_LinkedList.Node(2, "Intel 10th Gen Core i5", 19500, "Processor");
        list.addAtEnd(node3);
        
        C_LinkedList.Node node4;
        node4 = new C_LinkedList.Node(3, "Intel 10th Gen Core i7", 32010, "Processor");
        list.addAtEnd(node4);
        
        C_LinkedList.Node node5;
        node5 = new C_LinkedList.Node(4, "8GB DDR4", 3800, "RAM");
        list.addAtEnd(node5);

	C_LinkedList.Node node6;
        node6 = new C_LinkedList.Node(5, "4GB DDR4", 2000, "RAM");
        list.addAtEnd(node6);
        
        C_LinkedList.Node node7;
        node7 = new C_LinkedList.Node(6, "256GB SSD", 3300, "HDD & SSD");
        list.addAtEnd(node7);

	C_LinkedList.Node node8;
        node8 = new C_LinkedList.Node(7, "1TB HDD", 5500, "HDD & SSD");
        list.addAtEnd(node8);
        
        C_LinkedList.Node node9;
        node9 = new C_LinkedList.Node(8, "GeForce GT 710 2GB", 4340, "Graphics Card");
        list.addAtEnd(node9);

	C_LinkedList.Node node10;
        node10 = new C_LinkedList.Node(9, "GeForce GTX 1650 4GB", 18230, "Graphics Card");
        list.addAtEnd(node10);

	C_LinkedList.Node node11;
        node11 = new C_LinkedList.Node(10, "RX 570 8GB", 17820, "Graphics Card");
        list.addAtEnd(node11);
        
        
        //         Add Items, Order Items; Generate Report; Monthly Report;
        
        while(true)
        {
            System.out.println("Choose Option: 1: View All Available Items");
            System.out.println("Choose Option: 2: Add Items To The Inventory");
            System.out.println("Choose Option: 3: Order An Item(s)");
            System.out.println("Choose Option: 4: Generate Last Sold Report");
            System.out.println("Choose Option: 5: Generate Monthly Report");
            System.out.println("Choose Option: 6: Remove Previous Month Report");
            System.out.println("Choose Option: 7: Exit");
            
            
            
            int cs = scan.nextInt();
            
            if(cs == 1){
                list.viewProductsbyCat();
            }
            
            else if(cs==2)
            {
                
                int len = list.lengthOfStack();
               
                System.out.println("Enter Item SKU (Input the Value after "+len+"): ");
                int No = scan.nextInt();
                scan.nextLine();
                System.out.println("Enter Item Name: ");
                String Name = scan.nextLine();
                System.out.println("Enter Item Price: ");
                double Price = scan.nextDouble();
                scan.nextLine();
                System.out.println("Enter Item Category: ");
                String Category = scan.nextLine();
                node = new C_LinkedList.Node(No, Name, Price, Category);

                list.addAtEnd(node);
                
                
            }
            else if(cs==3)
            {
                scan.nextLine();
                System.out.println("Enter Customer Name: ");
                String name = scan.nextLine();
                System.out.println("Enter Customer Email Address: ");
                String email = scan.nextLine();
                System.out.println("Enter Customer Phone Number: ");
                String phone = scan.nextLine();
                System.out.println("Enter Customer Address: ");
                String Address = scan.nextLine();
                

        //      Order Details
        
                C_Queue tmp = new C_Queue();
                
                int x;
                do{
                    System.out.println("Select Item:");
                    list.print();

                    System.out.println("Enter Item Code: ");
                    int item = scan.nextInt();
                        
                    System.out.println("Enter Item Quantity: ");
                    int Quantity = scan.nextInt();
                        
                    C_LinkedList.Node list2;
                    list2 = list.search(item);
                        
                    qNode = new C_Queue.Node(name, email, phone, Address, Quantity, list2);
                        
                    queue.enqueue(qNode);
                    tmp.enqueue(qNode);
                        
                    System.out.println("Order Placed Successfully!");
                        
                    
                        
                    sNode = new C_Stack.Node(qNode);
                        
                    stack.push(sNode);
                        
                    System.out.println("\nDo you want to make another purchase?");
                    System.out.println("1: Yes, 2: No");
                    x = scan.nextInt();
                        
                    if(x!=1 && x!=2)
                    {
                        System.out.println("Choose Correct Option");
                    }
                }while(x==1);  
                
                System.out.println("==========================================");
                System.out.println("\t //// Order Details ////");
                System.out.println("==========================================");
                System.out.println();
                tmp.printOrder();
                System.out.println();
                System.out.println("==========================================");
                tmpLast = tmp;
                
            }
            else if(cs==4)
            {
                System.out.println("==========================================");
                System.out.println("\t/// Last Sold Item ///");
                System.out.println("==========================================");
                System.out.println();
                tmpLast.printOrder();
                System.out.println();
                System.out.println("==========================================");
            }
            else if(cs==5)
            {
                stack.print();
            }
            else if(cs==6)
            {
                stack.popReport();
            }
            else if(cs==7)
            {
                break;
            }
            else{
                System.out.println("Please Choose Valid Options");
            }
                    
        }


    }
    
}
