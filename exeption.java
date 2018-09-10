package exercises;
/*Sory for grammar mistake it is exception,
not exeption*/
public class exeption {
        public static void main(String[] args){
           
            int arr[] = {23, 2, 7};
            try{
                int x = 100/0;
                System.out.println(arr[3]);
                
            }catch(Exception e){
                System.out.println("Error: " + e);
            }finally{
            System.out.println("'finally{}' is working!");
            }
        
    }
}
