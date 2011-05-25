package heapsort;

/**
 * A model of a heap; a weakly balanced binary tree sorted by priority.
 * @author sajuuk
 */
public class Heap {

  //stores the heap in array form
  private HeapEntry[] heap;
  //keeps a count of the current, last array index used
  private int latestIndex;


  /**
   * Default constructor, populates all fields.
   * @param maxSize int The size of the array in which to store the heap
   */
  public Heap(int maxSize) {
    latestIndex = 0;
    heap = new HeapEntry[maxSize];
  }

  /**
   * Adds an entry to the heap, sorting the heap for priority afterwards.
   * @param entry HeapEntry the entry to be added
   */
  public void add(HeapEntry entry) {
    //only add to the array if there is room to add
    if (latestIndex < heap.length) {
      //start by incrementing the latestIndex counter
      latestIndex += 1;
      //then copy in the new object to this new, last place
      heap[latestIndex] = new HeapEntry(entry);
      //then trickle the new value until it reaches the right spot
      //trickleUp();
    } else {
      System.out.println("Could not insert, heap is full.");
    }
  }

  /**
   * Checks that the latest entry of an array is in the correct position.
   */
  public void trickleUp() {
    //start by setting a counter at the back of the occupied cells
    int current = latestIndex;
    System.out.println("Current node initialised to " + current);
    //go up as long as our current position doesn't go beyond index 0
    while (current > 0) {
      System.out.println("Current node changed to " + current);
      //calculate the index of the parent of our node
      int parent = (current-1)/2;
      System.out.println("Parent node changed to " + parent);
      //if the added entry has higher priority than parent, then swap them
      System.out.println("Current priority " + heap[current].priority);
      System.out.println("Parent priority " + heap[parent].priority);
      if (heap[current].priority > heap[parent].priority) {
        swapEntries(heap, current, parent);
      }
      //and then move up the tree to the parent of the current node
      current = parent;
    }
  }

  /**
   * Swaps two cells in an array of HeapEntrys
   * @param heap HeapEntry[] An array of HeapEntrys
   * @param indexA int The index of the first entry to be swapped
   * @param indexB int The index of the second entry to be swapped
   */
  public void swapEntries(HeapEntry[] heap, int indexA, int indexB) {
    HeapEntry tempEntry = new HeapEntry(heap[indexB]);
    heap[indexB] = new HeapEntry(heap[indexA]);
    heap[indexA] = new HeapEntry(tempEntry);
  }

  /**
   * Pops the top of the heap off and returns it.
   * @return Object The object at the top of the heap (highest priority)
   */
  public HeapEntry remove() {
    if (latestIndex<0) {
      //first pop off the top of the heap and assign to a return variable
      HeapEntry top = new HeapEntry(heap[0]);
      //then move the last entry to the first, so the tree is almost full
      swapEntries(heap,0,latestIndex);
      //then decrement the latestIndex counter so that we ignore the
      //now 'empty' last entry
      latestIndex -= 1;
      //lastly, trickle the new top of the heap down to its rightful place
      //trickleDown();
      return top;
    } else {
      System.out.println("Could not remove, heap is empty.");
      return null;
    }
  }

  /**
   * Takes the first array element and trickles it to its rightful place.
   */
  public void trickleDown() {
    int current = 0;
    int leftChild = 1;
    int rightChild = 2;
    int largerChild = leftChild;
    //keep going as long as there is a left child
    //i.e. keep going as long as there is another level of children below
    while (leftChild <= latestIndex) {
        //compute the index of the left child
        leftChild = ((current*2)+1);
        //compute the index of the right child
        rightChild = ((current*2)+2);
        //default the larger child to the left child
        largerChild = leftChild;
        //if there is no right child, we don't need to select the larger child
        if (rightChild > latestIndex) {
          //and can just compare the left
          if (heap[largerChild].priority > heap[current].priority) {
            //and swap the entries if the left (larger) child
            //has higher priority
            swapEntries(heap,largerChild,current);
          }
        } else {
          //otherwise, if there exists a right child
          //calculate which of the children has higher priority
          if (heap[rightChild].priority > heap[leftChild].priority) {
            //if the right child has higher priority, set it as
            //the larger child
            largerChild = rightChild;
            //if it isn't we needn't do anything since larger child
            //defaults to the left child
          }
          //then compare the larger child with the current node
          if (heap[largerChild].priority > heap[current].priority) {
            //and swap them if that child has a higher priority
            swapEntries(heap,largerChild,current);
          }
        }
        //then we should increment current to the larger child
        //and head back to the top of our while loop to see if we've
        //hit the end yet
        current = largerChild;
    }
  }
}