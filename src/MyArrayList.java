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

    @Override
    public boolean add(E value) {
        if (++size > elementData.length) {
            elementData = increase(elementData);
        }
        elementData[size - 1] = value;
        return true;
    }

    @Override
    public boolean add(int index, E value) {
        if (++size > elementData.length) {
            elementData = increase(elementData);
        }
        for (int i = size-1; i > index; i--) {
            elementData[i] = elementData[i-1];
        }
        elementData[index] = value;
        return true;
    }
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E)elementData[index];
    }
    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E oldValue = (E)elementData[index];
        elementData[index] = element;
        return oldValue;
    }
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
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    @Override
    public boolean contains(Object o) {
        return this.indexOf(o) >= 0;
    }
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
    @Override
    public boolean remove(Object value) {
        int i = 0;
        if (value == null) {
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
                if (value.equals(elementData[i])) {
                    break;
                }
                i++;
            }
        }
        remove(i);
        return true;
    }
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
