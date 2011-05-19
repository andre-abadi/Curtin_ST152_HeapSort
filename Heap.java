package heapsort;

/**
 *
 * @author sajuuk
 */
public class Heap {

  //stores the heap in array form
  private HeapEntry[] heap;
  //keeps a count of the current, last array index used
  private int heapCount;


  /**
   * Default constructor, populates all fields.
   * @param maxSize int The size of the array in which to store the heap
   */
  public Heap(int maxSize) {
    heapCount = 0;
    heap = new HeapEntry[maxSize];
  }

  /**
   * Adds an entry to the heap, sorting the heap for priority afterwards.
   * @param pty The priority of the entry to be added
   * @param vlue The Object to be added in the entry, to the heap
   */
  public void add(int pty, Object vlue) {
    try {
      //part 1; add to next free slot in array
      heap[heapCount] = new HeapEntry(pty, vlue);
      heapCount += 1;
    } catch (Exception e) {
      System.out.println("Out of space in heap: " + e.getMessage());
    }
    //part 2; trickle up to correct position
    //i.e. go back along the parents of the new entry until we find
    //a parent with a higher priority
    int counter = heapCount-1;
    //go through our parents
    //priorities should get higher as we go up the tree
    while (counter > 0) {
//      System.out.println("Counter is currently: " + counter);
      //calculate the array position of the parent entry of the
      //node we are looking at
      int parent = (counter-1)/2;
//      System.out.println("Parent is now: " + parent);
      //if the new object has a higher priority than the parent
      //entry then swap them
      if (heap[counter].priority > heap[parent].priority) {
        swapEntries(heap, counter, parent);
      }
      counter = (counter-1)/2;
    }
  }

  /**
   * Swaps two cells in an array of HeapEntrys
   * @param heap HeapEntry[] An array of HeapEntrys
   * @param indexA int The index of the first entry to be swapped
   * @param indexB int The index of the second entry to be swapped
   */
  private void swapEntries(HeapEntry[] heap, int indexA, int indexB) {
    HeapEntry tempEntry = new HeapEntry(heap[indexB]);
    heap[indexB] = new HeapEntry(heap[indexA]);
    heap[indexA] = new HeapEntry(tempEntry);
  }

  /**
   * Pops the top of the heap off and returns it.
   * @return Object The object at the top of the heap (highest priority)
   */
  public HeapEntry remove() {
    int counter = 0;
    HeapEntry top = null;
    if (heapCount == 0) {
      System.out.println("Heap is empty, try adding some values first.");
    } else {
//      System.out.println("Heap is not empty, attempting trickle down.");
//      System.out.println("Last index is currently " + heapCount);
      //part 1; pop the first value of the heap, the highest priority
      top = heap[0];
//      System.out.println("Assigned top of heap to top variable");
      //swap the end of the array with the start of the array
//      System.out.println("swapping entries at end with top of heap");
      swapEntries(heap, 0, heapCount-1);
//      System.out.println("Top of heap now has priority " + heap[0].priority);
//      System.out.println("End of heap now has priority " + heap[heapCount-1].priority);
      int leftChild = 0;
//      System.out.println("Left child is now " + leftChild);
      int rightChild = 0;
//      System.out.println("Right child is now " + rightChild);
      int largerChild = 0;
      if (rightChild < heapCount) {
//        System.out.println("Right child is smaller than heap length");
//        System.out.println("Right child is at index " + rightChild);
//        System.out.println("Heap has length " + heapCount);
        while (counter < heapCount && leftChild < heapCount && rightChild < heapCount) {
          largerChild = leftChild;
          if (heap[leftChild].priority < heap[rightChild].priority) {
            largerChild = rightChild;
          }
          swapEntries(heap, counter, largerChild);
          System.out.println("Counter is " + counter);
          leftChild = (counter*2)+1;
          System.out.println("LeftChild is " + leftChild);
          rightChild = (counter*2)+2;
          System.out.println("Right chld is " + rightChild);
//        System.out.println("Counter incremented, is now " + counter);
          counter += 1;
        }
      }
    }
    return top;
  }

  /**
   * Sorts an array of HeapEntries in-place.
   * @param array The array that is to be sorted by priority.
   */
  public void heapSort(HeapEntry[] array) {
    Heap tempHeap = new Heap(array.length);
    int counter = 0;
    if (array.length == 0) {
      System.out.println("Please give an input array.");
    } else {
      while (counter < array.length) {
        int currentPriority = array[counter].priority;
        Object currentObject = array[counter].value;
        tempHeap.add(currentPriority, currentObject);
        System.out.println("Added " + currentObject);
        counter += 1;
      }
      counter = 0;
      while (counter < array.length) {
        array[counter] = tempHeap.remove();
        System.out.println("Removed " + array[counter].value);
        counter += 1;
      }
    }
  }

}
