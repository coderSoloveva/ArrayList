/**
 * Resizable-array implementation of the MyList interface.
 * Implements all optional list operations, and permits all elements, including null.
 * @param <E> array element type
 */
public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    Object[] elementData;
    private int size;
    public MyArrayList(int capacity) {
        if (capacity >= 0) {
            this.elementData = new Object[capacity];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }
    /**
     * Appends the specified element to the end of this list.
     * @param value element to be appended to this list
     * @return true
     */
    @Override
    public boolean add(E value) {
        if (++size > elementData.length) {
            elementData = increase(elementData);
        }
        elementData[size - 1] = value;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     * @param index index at which the specified element is to be inserted
     * @param value element to be inserted
     * @return
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
     */
    @Override
    public void add(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (++size > elementData.length) {
            elementData = increase(elementData);
        }
        for (int i = size-1; i > index; i--) {
            elementData[i] = elementData[i-1];
        }
        elementData[index] = value;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E)elementData[index];
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param index index of the element to replace
     * @param value element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public E set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E oldValue = (E)elementData[index];
        elementData[index] = value;
        return oldValue;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E remEl = (E)elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i+1];
        }
        size--;
        return remEl;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If the list does not contain the element, it is unchanged.
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        int i = 0;
        if (o == null) {
            while(true) {
                if (i >= size) {
                    return false;
                }
                if (elementData[i] == null) {
                    break;
                }
                i++;
            }
        } else {
            while(true) {
                if (i >= size) {
                    return false;
                }
                if (o.equals(elementData[i])) {
                    break;
                }
                i++;
            }
        }
        remove(i);
        return true;
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns true if this list contains the specified element.
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        return this.indexOf(o) >= 0;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object o){
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) return i;
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == null) return i;
            }
        }
        else {
            for (int i = size - 1; i >= 0; i--)  {
                if (o.equals(elementData[i])) return i;
            }
        }
        return -1;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after this call returns.
     */
    @Override
    public void clear() {
       for (int i = 0; i < size; i++) {
           elementData[i] = null;
       }
       size = 0;
    }
    private Object[] increase (Object[] elementData) {
        Object[] newElementData = new Object[elementData.length * 3 / 2 +1];
        copy(elementData, newElementData);
        return newElementData;
    }
    private void copy(Object[] oldElementData, Object[] newElementData){
        for(int i = 0; i < oldElementData.length; i++) {
            newElementData[i] = oldElementData[i];
        }
    }

    /**
     * Returns a string representation of this collection.
     * @return a string representation of this collection
     */
    @Override
    public String toString() {
        String str = "[";
        boolean isFirst = true;
        for (int i = 0; i < size; i++) {
            if (isFirst) {
                isFirst = false;
            }
            else {
                str+=", ";
            }
            str+=elementData[i] == null? "null" : elementData[i].toString();
        }
        return str+="]";
    }
}
