package self;

public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {

    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private AnyType[] array;


    public void insert(AnyType x) {

        if (currentSize == array.length - 1)
            enlargeArray(array.length * 2 - 1);

        int hole = ++currentSize;
        for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2)
            array[hole] = array[hole / 2];
        array[hole] = x;

    }

    private void enlargeArray(int i) {

    }

    public static void main(String[] args) {
        System.out.println( 4 & 10);
        System.out.println( 5 % 10);
    }

}
