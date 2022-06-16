public interface MyList<E> {
    /**
     * Appends the specified element to the end of this list
     * @param value element to be appended to this list
     * @return true
     */
    boolean add(E value);
    /**
     * Inserts the specified element at the specified position in this list (optional operation).
     * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     * @param index index at which the specified element is to be inserted
     * @param value element to be inserted
     */
    void add(int index, E value);
    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    public E get(int index);
    /**
     * Replaces the element at the specified position in this list with the specified element (optional operation).
     * @param index index of the element to replace
     * @param value element to be stored at the specified position
     * @return the element previously at the specified position
     */
    E set(int index, E value);

    /**
     * Removes the element at the specified position in this list (optional operation). Shifts any subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     * @param n the index of the element to be removed
     * @return the element previously at the specified position
     */
    E remove(int n);
    /**
     * Removes the first occurrence of the specified element from this list, if it is present (optional operation).
     * If this list does not contain the element, it is unchanged.
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    boolean remove(Object o);
    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    int size();
    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */
    boolean isEmpty();
    /**
     * Returns true if this list contains the specified element.
     * @param o  element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    boolean contains(Object o);
    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    int indexOf(Object o);
    /**
     * Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    int lastIndexOf(Object o);
    /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     */
    void clear();
}
