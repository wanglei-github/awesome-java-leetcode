package self;

import java.util.Arrays;

public class BucketSort {

    public static void sort(int[] a, int maxVal) {
        int [] bucket=new int[maxVal+1];

        for (int i=0; i<bucket.length; i++) {
            bucket[i]=0;
        }

        for (int i=0; i<a.length; i++) {
            bucket[a[i]]++;
        }

        int outPos=0;
        for (int i=0; i<bucket.length; i++) {
            for (int j=0; j<bucket[i]; j++) {
                a[outPos++]=i;
            }
        }
    }


    public static void main(String[] args) {
        int maxVal=19;
        int [] data= {5,3,0,2,4,1,0,5,2,3,1,4};

        System.out.println("Before: " + Arrays.toString(data));
        sort(data,maxVal);
        System.out.println("After:  " + Arrays.toString(data));


        System.out.println("Bucket sort in Java"); int[] input = { 80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50 };

        final int[] code = hash(input);


        for (int i : input) {
            System.out.println(hash(i, code)+">>>>>>"+i);
        }

    }

    /**
     *
     * @param input
     * @return an array containing hash of input
     */
    private static int[] hash(int[] input) {
        int m = input[0];
        for (int i = 1; i < input.length; i++) {
            if (m < input[i]) {
                m = input[i];
            }
        }
        return new int[] { m, (int) Math.sqrt(input.length) };
    }

    /**
     *
     * @param i
     * @param code
     * @return
     */
    private static int hash(int i, int[] code) {
        return (int) ((double) i / code[0] * (code[1] - 1));
    }
}
