package easy._001;

public class SingleTest {


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                DoubleCheck.getInstance();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                DoubleCheck.getInstance();
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();


        Thread t3 =new Thread(){
            @Override
            public void run() {
                InnerStatic.getInnerStatic();
            }
        };
        Thread t4=new Thread(){
            @Override
            public void run() {
                InnerStatic.getInnerStatic();
            }
        };
        t3.start();
        t4.start();
        t3.join();
        t4.join();
    }




}
