
import java.util.Arrays;

public class GreedyAlgorithmExample {
    public static void main(String[] args) {
        int[] digits = {8, 4, 5, 3, 9, 6, 1};
        Arrays.sort(digits);
        for (int i = 0; i < digits.length ; i++) {
            System.out.print(digits[i] + " ");
        }
        System.out.println("");
        for (int i = digits.length-1; i >= 0 ; i--) {
            System.out.print(digits[i] + " ");

        }

    }
}



