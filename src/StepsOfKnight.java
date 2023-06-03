public class StepsOfKnight {
    public static void StepsOfKnightUtil(int size, int currCol, int currRow, int[][] traversed, int dist){
        if (currCol < 0 || currCol >= size || currRow < 0 || currRow >= size)
            return;
        if (traversed[currCol][currRow] <= dist)
            return;
        traversed[currCol][currRow] = dist;
        StepsOfKnightUtil(size, currCol + 2, currRow + 1, traversed, dist + 1);
        StepsOfKnightUtil(size, currCol + 2, currRow - 1, traversed, dist + 1);
        StepsOfKnightUtil(size, currCol - 2, currRow + 1, traversed, dist + 1);
        StepsOfKnightUtil(size, currCol - 2, currRow - 1, traversed, dist + 1);
        StepsOfKnightUtil(size, currCol + 1, currRow + 2, traversed, dist + 1);
        StepsOfKnightUtil(size, currCol + 1, currRow - 2, traversed, dist + 1);
        StepsOfKnightUtil(size, currCol - 1, currRow + 2, traversed, dist + 1);
        StepsOfKnightUtil(size, currCol - 1, currRow - 2, traversed, dist + 1);



    }
    public static int StepsOfKnight(int size, int srcX, int srcY, int dstX, int dstY) {
        int[][] traversed = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                traversed[i][j] = Integer.MAX_VALUE; }

        }
        StepsOfKnightUtil(size, srcX - 1, srcY - 1, traversed, 0);
        int retval = traversed[dstX - 1][dstY - 1];
        return retval;

    }


    public static void main(String[] args) {

        System.out.println(StepsOfKnight(20, 10, 10, 20, 20));
    }

}
