public interface MyList<E> {
    boolean add(E value);
    boolean add(int index, E value);
    public E get(int index);
    E set(int index, E element);
    E remove(int n);
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    boolean remove(Object value);
    void clear();
}
