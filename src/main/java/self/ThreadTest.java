package self;

public class ThreadTest {


    public synchronized static void lockStaticMethod() {
        //do something
    }

    public synchronized void lockInstanceMethod() {
        //do something
    }
    public static void main(String[] args) {

        final ThreadTest instanceA = new ThreadTest();
        final ThreadTest instanceB = new ThreadTest();

        Thread A = new Thread() {
            @Override
            public void run() {
                ThreadTest.lockStaticMethod();
            }
        };
        Thread B = new Thread() {
            @Override
            public void run() {
                ThreadTest.lockStaticMethod();
            }
        };
        A.start();
        B.start();



    }


}





