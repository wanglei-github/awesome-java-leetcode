package self;

public class Rotate {

    public static void main(String[] args) {
        int a = 1362;
        System.out.println(9 / 10);

        while (a != 0) {
            int l = a % 10;
            System.out.println(l);
            a = a / 10;
        }

    }

    public static int[][] helper(int[][] rotate) {
        int[][] result = new int[rotate.length][rotate.length];
        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate.length; j++) {
                result[j][rotate.length - i - 1] = rotate[i][j];
            }
        }
        return result;
    }

    public void rotate(int[][] matrix) {
        matrix = helper(matrix);
        Object o = new Object();
        for (int i = 0; o != null; i = i * 10) {

        }
    }

    class Entry<key, value> {
        Entry<key, value> next;
        private key key;
        private value value;

        Entry(key key, value value) {
            this.key = key;
            this.value = value;
        }

    }


}
