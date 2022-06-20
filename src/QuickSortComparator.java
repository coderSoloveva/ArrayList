import java.util.Comparator;
/**
 * A class for quick sorting Array List classes that implement the MyList interface.
 * Array elements must implement the Comparator interface
 * @param <E> array element type
 */
public class QuickSortComparator<E extends Comparator<E>> extends QuickSort<E>{
    public QuickSortComparator(MyList<E> inputArray) {
        super(inputArray);
    }
    protected int partition(int start, int end){
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