//Eric Burger
//Homework 1 - CSC 301
//Part B - Inventory.java
package homework;
import java.util.Random;
import java.util.Comparator;
import java.util.ArrayList;

public class Inventory implements Comparable<Inventory>
{
  // instance variables
  private String itemName;
  private double unitPrice;
  private int quantity;

  // constructors
  public Inventory()
  {
    itemName = "N.A."; unitPrice = 0.0; quantity = 0;
  }

  public Inventory(String n, double p, int q)
  {
    itemName = n; unitPrice = p; quantity = q;
  }

  public String getItemName() { return itemName; }
  public double getUnitPrice() { return unitPrice; }
  public int getQuantity() { return quantity; }

  public String toString()
  {
    //
    // WRITE YOUR CODE
    //
	String theString = "[" + this.getItemName() + ", " + this.getUnitPrice() + ", " + this.getQuantity() + "]";
	return theString;
  }

  public int compareTo(Inventory iv2)
  {
    int difference = this.itemName.compareTo(iv2.itemName);
    if (difference < 0 || difference > 0)
    {
    	if (difference < 0)
    	{
    		return 1;
    	}
    	else if (difference > 0)
    	{
    		return -1;
    	}
    }
    else if (difference == 0)
    {
    	if (this.unitPrice < iv2.unitPrice)
    	{
    		return 1;
    	}
    	else if (this.unitPrice > iv2.unitPrice)
    	{
    		return -1;
    	}
    	else if (this.unitPrice == iv2.unitPrice)
    	{
    		if (this.quantity < iv2.quantity)
        	{
        		return -1;
        	}
        	else if (this.quantity > iv2.quantity)
        	{
        		return 1;
        	}
    	}
    }
    return 0;
  }

  public int hashCode()
  {
	  int hashCodeName = this.itemName.hashCode();
	  int hashCodePrice = new Double(this.unitPrice).hashCode();
	  return hashCodeName + hashCodePrice;
  }
  
  public static void hashCodeTest(Inventory one, Inventory two)
  {
	  System.out.println(one.hashCode());
	  System.out.println(two.hashCode());
  }
  
  //***************
  //  main()
  //***************
  public static void main(String[] args)
  {
    Inventory x1 = genInventory();
    Inventory x2 = genInventory();
    Inventory x3 = genInventory();
    
    hashCodeTest(x1, x2);
    printThree(x1, x2, x3);


    Inventory first = null, second = null, third = null; // in the order of compareTo()

    //
    //
    // WRITE YOUR CODE HERE
    //
    //
    float result = x1.compareTo(x2);
    float result2 = x1.compareTo(x3);
    float result3 = x2.compareTo(x1);
    float result4 = x2.compareTo(x3);
    float result5 = x3.compareTo(x1);
    float result6 = x3.compareTo(x2);
    
    if (result == 1 && result2 == 1)
    {
    	first = x1;
    	if(result4 == 1)
    	{
    		second = x2;
    		third = x3;
    	}
    	else
    	{
    		second = x3;
    		third = x2;
    	}
    }
    else if (result3 == 1 && result4 == 1)
    {
    	first = x2;
    	if (result2 == 1)
    	{
    		second = x1;
    		third = x3;
    	}
    	else
    	{
    		second = x3;
    		third = x1;
    	}
    }
    else if (result5 == 1 && result6 == 1)
    {
    	first = x3;
    	if (result == 1)
    	{
    		second = x1;
    		third = x2;
    	}
    	else
    	{
    		second = x2;
    		third = x1;
    	}
    }
    System.out.println("\nAfter sorting:");
    printThree(first, second, third);
    

  }

  // global variables

  private static Inventory[] ar = { new Inventory("T-shirt", 20.00, 5),
                             new Inventory("Candy", 5.00, 8),
                             new Inventory("Book", 15.00, 3), 
  							 new Inventory("Candy", 2.00, 10),
  							 new Inventory("Candy", 2.00, 4),
  							 new Inventory("Book", 15.00, 3),
  							 new Inventory("Book", 10.00, 7)
  };
  private static int maxsize = ar.length;
  private static Random rgen = new Random();
  private static ArrayList<Integer> previndices = new ArrayList<Integer>();

  private static Inventory genInventory()
  {
    return ar[nextUniqueIndex()];
  }

  private static int nextUniqueIndex()
  {
    int next = rgen.nextInt(maxsize);
    while (previndices.contains(next))
      next = rgen.nextInt(maxsize);


    if (previndices.size() < maxsize)
      previndices.add(next);
    else {
      previndices.remove(new Integer(next));
      previndices.add(next);
    }
    return next;
  }

  public static void printThree(Inventory one, Inventory two, Inventory three)
  {
    System.out.println(" 1: " + one);
    System.out.println(" 2: " + two);
    System.out.println(" 3: " + three);
  }
  
}

/* Sample output

 1: [Book, 15.0, 3]
 2: [Candy, 5.0, 8]
 3: [Book, 10.0, 7]

After sorting:
 1: [Book, 10.0, 7]
 2: [Book, 15.0, 3]
 3: [Candy, 5.0, 8]

*/
