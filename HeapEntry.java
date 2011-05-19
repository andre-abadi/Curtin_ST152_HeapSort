package heapsort;

  /**
   * Private class describing and entry in the heap.
   */
  public class HeapEntry {
    //public fields of entry instance
    public int priority;
    public Object value;
    /**
     * Default constructor, populates all fields.
     * @param prty int The priority of the object
     * @param vle Object The object to add.
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