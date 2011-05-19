/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package heapsort;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sajuuk
 */
public class HeapTest {

    public HeapTest() {
    }

  /**
   * Test of add method, of class Heap.
   */
  @Test
  public void testAdd() {
    System.out.println("add 1");
    int priority = 45;
    Object value = "apple";
    Heap instance = new Heap(100);
    instance.add(priority, value);

    System.out.println("add 2");
    priority = 27;
    Object value2 = "banana";
    instance.add(priority, value2);
  }

  /**
   * Test of remove method, of class Heap.
   */
  @Test
  public void testRemove() {
    System.out.println("remove");
    Object expResult = "queen";
    Heap instance = new Heap(100);

    int priority = 45;
    Object value = "fondue";
    instance.add(priority, value);
    System.out.println("added fondue");

    priority = 27;
    Object value2 = "cheese";
    instance.add(priority, value2);
    System.out.println("added cheese");

    priority = 86;
    Object value3 = "queen";
    instance.add(priority, value3);
    System.out.println("added queen");
    
    Object result = instance.remove().value;
    assertEquals(expResult, result);
  }

    /**
   * Test of heapSort method, of class Heap.
   */
  @Test
  public void testHeapSort() {
    System.out.println("heapSort");

    HeapEntry[] array = new HeapEntry[4];
    array[0] = new HeapEntry(1,"string");
    array[2] = new HeapEntry(22,"shoe");
    array[1] = new HeapEntry(333,"lace");
    array[3] = new HeapEntry(440,"someone");

    Heap instance = new Heap(100);
    instance.heapSort(array);

    System.out.println("someone");
    Object expResult = "someone";
    Object result = array[0].value;
    assertEquals(expResult, result);

    System.out.println("lace");
    expResult = "lace";
    result = array[1].value;
    assertEquals(expResult, result);

    System.out.println("shoe");
    expResult = "shoe";
    result = array[2].value;
    assertEquals(expResult, result);

    System.out.println("string");
    expResult = "string";
    result = array[3].value;
    assertEquals(expResult, result);
  }

}