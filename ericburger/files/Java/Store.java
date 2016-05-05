//**
//** Name: Eric Burger
//** HW2 - Store.java

package hw2;

public class Store implements Comparable<Store>
{
  // fields
  private int[] elementData;
  private int[] oldElementData;
  private int elementCount; //number of elements stored in elementData
  private static int DEFAULT_CAPACITY = 1;
  private float elementSum;

  // methods
  public Store()
  {
    elementData = new int[DEFAULT_CAPACITY];
    elementCount = 0;
  }

  public Store(int initCapacity)
  {
	  elementData = new int[initCapacity];
	  elementCount = 0;
  }

  public int capacity() { return elementData.length; }
  public int size() { return elementCount; }

  public void insertNumber(int elt)
  {

	if (elementCount == elementData.length)
	{
		oldElementData = elementData;
		elementData = new int[elementData.length * 2];
		
		//copy array data to new array
		for (int j = 0; j < oldElementData.length; j++)
		{
			elementData[j] = oldElementData[j];
		}
		elementData[elementData.length/2] = elt;
	}
	else
	{
		elementData[elementCount] = elt;
	}
	
	elementCount++;
  }

  public double average()
  {

	elementSum = 0;
	if (elementData.length == 0)
	{
	  return 0.0;
	}
	else
	{
	  for (int x = 0; x < elementData.length; x++)
		{
			elementSum = elementSum + elementData[x];
		}
	  return (elementSum / elementCount);
	}
  }

  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    else if (obj == null || getClass() != obj.getClass())
      return false;
    else
    {
      Store s2 = (Store) obj;  // type-cast obj to Store; then we can call Store methods in s2
      
      if (this.average() != s2.average() || this.size() != s2.size())
      {
    	    return false;
      }
    return true;
    }
  }

  public String toString()
  {
    String ret = "[";

    if (size() > 0) {
      ret += elementData[0]; // first element to kick off
      for (int i = 1; i < size(); i++)
        ret = ret + ", " + elementData[i];
    }

    return ret + "]";
  }
  
  public int compareTo(Store obj)
  {
	  if (this.size() == obj.size() && this.average() == obj.average())
	  {
		  return 0;
	  }
	  else if (this.size() < obj.size() || (this.size() == obj.size() && this.average() < obj.average()))
	  {
		  return -1;
	  }
	  
	  else if (this.elementCount == 0 && obj.elementCount == 0)
	  {
		  return 0;
	  }
	  else
		  return 1;
  }
}
