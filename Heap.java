package heapsort;

/**
 * A model of a heap; a weakly balanced binary tree sorted by priority.
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
    //start by setting a counter at the back of the occupied cells
    int counter = heapCount;
    //go through our parents
    //priorities should get higher as we go up the tree
    while (counter > 0) {
      //calculate the index of the parent of our node
      int parent = (counter-1)/2;
      //if the added entry has higher priority than parent, then swap them
      if (heap[counter].priority > heap[parent].priority) {
        swapEntries(heap, counter, parent);
      }
      //and then move up the tree to the parent of the current node
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
    //initialise a variable to store the top of the heap that we will return
    HeapEntry top = null;
    //do the following only if the heap has its counter past 0
    if (heapCount == 0) {
      //otherwise inform the user that the heap is empty
      System.out.println("Heap is empty, try adding some values first.");
    } else {
      //store a variable to keep track of where we are in the tree
      //start off at the root of the tree
      int current = 0;
      //part 1; pop the highest priority; the top of the heap
      top = heap[0];
      //swap the end of the array with the start of the array
      swapEntries(heap, 0, heapCount);
      //part 2; trickle the new top value down to its rightful place
      //do this so long as the right child of the current node is not
      //past the last-pointer of the array
      while ( ((current*2)+2) <= heapCount ) {
        //compute the index of the left child
        int leftChild = ((current*2)+1);
        //compute the index of the right child
        int rightChild = ((current*2)+2);
        //default the larger (higher priority) child to the left child
        int largerChild = leftChild;
        //if the right child does have higher priority, set it as
        //the larger child
        if (heap[rightChild].priority > heap[leftChild].priority) {
          largerChild = rightChild;
        }
        //if the higher priority child has higher priority than current
        //node, then swap them
        if (heap[largerChild].priority > heap[current].priority) {
          swapEntries(heap,largerChild,current);
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
