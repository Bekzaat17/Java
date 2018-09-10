package exercises;

class Some implements Runnable{

    @Override
    public void run() {
        for(int i=10; i<70; i+=10){
        System.out.println("Number - "+ i + "  ");
        }
    }

}

public class ThreadEX2{
    public static void main(String[] args){
    Thread new_one = new Thread(new Some());
    Thread new_two = new Thread(new Some());
    
    new_one.start();
    new_two.start();
    
    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i=10; i<70; i+=10){
        System.out.println("Number - "+ i + "  ");
        }
        }
    });
    t1.start();
    
    }
    
    
}
