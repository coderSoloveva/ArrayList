import java.util.Comparator;

public class QuickSortComparable<E extends Comparable<E>> {
    private MyList<E> inputArray;

    public QuickSortComparable(MyList<E> inputArray){
        this.inputArray = inputArray;
    }

    public void startQuickStart(int start,int end){
        int q;
        if(start < end){
            q = partition(start, end);
            startQuickStart(start, q);
            startQuickStart(q+1, end);
        }
    }
    public MyList<E> getSortedArray(){
        return inputArray;
    }

    int partition(int start, int end){
        int init = start;
        int length = end;

        int pivotIndex = (start + length) / 2;
        E pivot = inputArray.get(pivotIndex);

        while (true) {
            while (inputArray.get(length).compareTo(pivot) > 0 && length > start){
                length--;
            }
            while (inputArray.get(init).compareTo(pivot) < 0 && init < end){
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