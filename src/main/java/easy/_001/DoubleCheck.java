package easy._001;

public class DoubleCheck {
    private static Integer a = 1;
    private static  DoubleCheck instance;
    private Integer b = 2;

    public static DoubleCheck getInstance() {
        if (instance == null) {
            synchronized (DoubleCheck.class) {
                if (instance == null)
                    instance = new DoubleCheck();
            }
        }
        return instance;
    }
}
