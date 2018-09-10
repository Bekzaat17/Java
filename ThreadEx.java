package exercises;

    class SomeThread extends Thread {
    public void run(){
    for(int i=10; i<100; i+=10){
        System.out.print("Number - "+ i + "  ");
        }System.out.println("");
    }
}

public class ThreadEx{
    public static void main(String[] args){
    SomeThread test = new SomeThread();
    test.run();
    SomeThread test1 = new SomeThread();
    test1.run();
    SomeThread test2 = new SomeThread();
    test2.start();
    SomeThread test3 = new SomeThread();
    test3.start();
    }
    }
