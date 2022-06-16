import java.util.Comparator;
/**
 * A class for quick sorting Array List classes that implement the MyList interface.
 * Array elements must implement the Comparator interface
 * @param <E> array element type
 */
public class QuickSortComparator<E extends Comparator<E>> {
    private MyList<E> inputArray;
    public QuickSortComparator(MyList<E> inputArray){
        this.inputArray = inputArray;
    }
    /**
     * A class for quick sorting Array List classes that implement the MyList interface.
     * @param start the position of the first element to be sorted
     * @param end the position of the last element to be sorted
     */
    public void startQuickStart(int start,int end){
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
    int partition(int start, int end){
        int init = start;
        int length = end;

        int pivotIndex = (start + length) / 2;
        E pivot = inputArray.get(pivotIndex);

        while (true) {
            while (pivot.compare(inputArray.get(length), pivot) > 0 && length > start){
                length--;
            }
            while (pivot.compare(inputArray.get(init), pivot) < 0 && init < end){
                init++;
            }
            if (init < length) {
                E temp;
                temp = inputArray.get(init);
                inputArray.set(init, inputArray.get(length));
                inputArray.set(length, temp);
                length--;
                init++;
            } else {
                return length;
            }
        }
    }
}