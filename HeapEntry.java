package heapsort;

  /**
   * Class describing and entry in the heap, having an object and a priority.
   */
  public class HeapEntry {
    //public fields of entry instance
    public int priority;
    public Object value;
    /**
     * Default constructor, populates all fields.
     * @param pty int The priority of the object
     * @param vlue Object The object to add.
     */
    public HeapEntry(int pty, Object vlue) {
      priority = pty;
      value = vlue;
    }
    /**
     * Duplicate constructor.
     * @param oldEntry HeapEntry another instance of a HeapEntry object
     */
    public HeapEntry(HeapEntry oldEntry) {
      priority = oldEntry.priority;
      value = oldEntry.value;
    }
  }