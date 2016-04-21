// TestStore.java  -- the driver code for Store

package hw2;

public class TestStore
{
  public static void main(String[] args)
  {
    final int[] ar = { 15, 6, 42, 9, 361, 25, 548, 93, 7 };

    /* s1 */
    Store s1 = new Store();

    System.out.println("-- Store s1 --");
    print(s1);
    for (int i = 0; i < ar.length; i++)
    {
      s1.insertNumber(ar[i]);
      print(s1);
    }
    System.out.println("The average is " + s1.average());
    System.out.println();
    

    /* s2*/
    Store s2 = new Store(3);
    System.out.println("-- Store s2 --");
    for (int i = ar.length-1; i >= 0; i--)
      s2.insertNumber(ar[i]);
    print(s2);
    System.out.println();

    if (s1.equals(s2))
      System.out.println("s1.equals s2 is true");
    else
      System.out.println("s1.equals s2 is false");
    System.out.println();


    /* s3 */
    Store s3 = new Store();
    //System.out.println("-- Store s3 --");
    for (int i = 0; i < ar.length; i++)
      s3.insertNumber(i);
    //print(s3);

    if (s1.equals(s3))
      System.out.println("s1.equals s3 is true");
    else
      System.out.println("s1.equals s3 is false");
    System.out.println();

    System.out.println(s1.compareTo(s2));

    /* s4 */
    Store s4 = new Store(7);
    //System.out.println("-- Store s4 --");
    for (int i = 0; i < ar.length-1; i += 2)
      s4.insertNumber(ar[i]+ar[i+1]);

    s4.insertNumber(ar[ar.length-1]);
    //print(s4);

    if (s1.equals(s4))
      System.out.println("s1.equals s4 is true");
    else
      System.out.println("s1.equals s4 is false");
    System.out.println();

    /* s5 */
    Store s5 = new Store();
    //System.out.println("-- Store s5 --");
    //print(s5);

    if (s1.equals(s5))
      System.out.println("s1.equals s5 is true");
    else
      System.out.println("s1.equals s5 is false");
    System.out.println();

  }

  public static void print(Store s)
  {
    System.out.println("capacity()=" + s.capacity() + ", size()=" + s.size() + ": " + s);
  }
}

/* Output of the program

-- Store s1 --
capacity()=1, size()=0: []
capacity()=1, size()=1: [15]
capacity()=2, size()=2: [15, 6]
capacity()=4, size()=3: [15, 6, 42]
capacity()=4, size()=4: [15, 6, 42, 9]
capacity()=8, size()=5: [15, 6, 42, 9, 361]
capacity()=8, size()=6: [15, 6, 42, 9, 361, 25]
capacity()=8, size()=7: [15, 6, 42, 9, 361, 25, 548]
capacity()=8, size()=8: [15, 6, 42, 9, 361, 25, 548, 93]
capacity()=16, size()=9: [15, 6, 42, 9, 361, 25, 548, 93, 7]
The average is 122.88888888888889

-- Store s2 --
capacity()=12, size()=9: [7, 93, 548, 25, 361, 9, 42, 6, 15]

s1.equals s2 is true

s1.equals s3 is false

s1.equals s4 is false

s1.equals s5 is false

*/
