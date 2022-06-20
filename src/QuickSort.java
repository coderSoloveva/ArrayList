public abstract class QuickSort<E> {
    protected MyList<E> inputArray;
    public QuickSort(MyList<E> inputArray){
        this.inputArray = inputArray;
    }

    /**
     * A class for quick sorting Array List classes that implement the MyList interface.
     * @param start the position of the first element to be sorted
     * @param end the position of the last element to be sorted
     */
    public void startQuickStart(int start, int end){
        int q;
        if(start < end){
            q = partition(start, end);
            startQuickStart(start, q);
            startQuickStart(q+1, end);
        }
    }
    /**
     * Returns an array.
     * If the startQuickStart method was called before, then the sorted array will be returned
     * @return array
     */
    public MyList<E> getSortedArray(){
        return inputArray;
    }
    protected abstract int partition(int start, int end);
}

