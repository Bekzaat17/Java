package exercises;

import java.util.ArrayList;
import java.util.LinkedList;

public class Exercises {

    public static void main(String[] args) {
        ArrayList<Integer> arr_dyn = new ArrayList<>(4);
        arr_dyn.add(5);
        arr_dyn.add(3);
        arr_dyn.add(7);
        arr_dyn.add(4);
        arr_dyn.add(9);
        arr_dyn.add(6);
        
        System.out.println(arr_dyn.size());
        for(Integer x : arr_dyn){
            System.out.print(x + "  ");
        }
        System.out.println("");
        arr_dyn.clear();
        System.out.println(arr_dyn.size());
        
        
        LinkedList<String> link = new LinkedList<>();
        link.add("Tom");
        link.add("John");
        link.add("Katye");
        
        link.add(2, "Mike");
      
        
        
        for(String x : link){
            System.out.println(x);
        }
        link.remove(1);
        System.out.println(link.size());
            
    }
    
}
