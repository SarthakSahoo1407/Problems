public class RottenFruit {
    public static void rottenFruitUtil(int[][] arr, int maxCol, int maxRow, int currCol, int currRow, int[][] traversed,
                                       int day) {
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int x, y;
        for (int i = 0; i < 4; i++) {
            x = currCol + dir[i][0];
            y = currRow + dir[i][1];
            if (x >= 0 && x < maxCol && y >= 0 && y < maxRow && traversed[x][y] > day + 1 && arr[x][y] == 1) {
                traversed[x][y] = day + 1;
                rottenFruitUtil(arr, maxCol, maxRow, x, y, traversed, day + 1);
            }
        }
    }

    public static int rottenFruit(int[][] arr, int maxCol, int maxRow) {
        int[][] traversed = new int[maxCol][maxRow];
        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                traversed[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                if (arr[i][j] == 2) {
                    traversed[i][j] = 0;
                    rottenFruitUtil(arr, maxCol, maxRow, i, j, traversed, 0);
                }
            }
        }

        int maxDay = 0;
        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                if (arr[i][j] == 1) {
                    if (traversed[i][j] == Integer.MAX_VALUE)
                        return -1;
                    if (maxDay < traversed[i][j])
                        maxDay = traversed[i][j];
                }
            }
        }
        return maxDay;
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 0, 1, 1, 0 }, { 2, 1, 0, 1, 0 }, { 0, 0, 0, 2, 1 }, { 0, 2, 0, 0, 1 },
                { 1, 1, 0, 0, 1 } };
        System.out.println(rottenFruit(arr, 5, 5));
    }
}
