import java.util.ArrayList;
import java.util.Collections;
/**
 * Created by Dmitriy Platonov on 04.09.2015.
 */
public class NumbersMultiply {
    public static void main(String[] args) {
        int N = 100;
        String Q = "";
        boolean solutionFlag = true;

        if ((int)Math.ceil(Math.log10(N)) == 1) {
            Q = "1" + N;
        } else {
            ArrayList<Integer> digits = new ArrayList<Integer>();
            while (N != 1 && solutionFlag) {
                int i = 9;
                while (i >= 2) {
                    if (N % i == 0) {
                        digits.add(i);
                        N = N / i;
                        break;
                    }
                    else
                        if (i == 2) solutionFlag = false;
                    i--;
                }
            }
            if (N == 1) {
                Collections.reverse(digits);
                for (int digit: digits)
                    Q += digit;
                System.out.println(Q);
            }
            else System.out.println(-1);
        }
    }
}