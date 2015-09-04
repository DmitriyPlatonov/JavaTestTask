/**
 * Created by Dmitriy Platonov on 04.09.2015.
 */
public class YoungTiler {

    public static int rectangleCount(int L, int rectangles)
    {
        boolean endFlag = true;
        if (L < 2) return 0;
        else {
            if (L % 2 == 0)  // если четное: итераци€ + 1
                for (int i = 1; endFlag; i++) {
                    if (L % i == 0)
                        if (i <= L / i)
                            rectangles++;
                        else
                            endFlag = false;
                }
            else // если нечетное: итераци€ + 2
                for (int i = 1; endFlag; i = i + 2) {
                    if (L % i == 0)
                        if (i <= L / i)
                            rectangles++;
                        else
                            endFlag = false;
                }
            return rectangles;
        }
    }

    public static void main(String[] args) {
        int M = 2;
        int N = 3;
        int K = 1;

        int rectangles_first = 0; // пр€моугольники из L плиток
        int rectangles_second = 0; // пр€моугольники из L-K плиток
        boolean solutionFlg = false;

        for (int L = 2; !solutionFlg && L<=10000; L++) {
            rectangles_first = rectangleCount(L, rectangles_first);
            rectangles_second = rectangleCount(L-K, rectangles_second);
            if (rectangles_first==N && rectangles_second==M) {
                solutionFlg = true;
                System.out.println(L);
            }
            else {
                rectangles_first = 0;
                rectangles_second = 0;
            }
        }
        if (!solutionFlg) System.out.println(0);
    }
}

