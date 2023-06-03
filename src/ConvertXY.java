import java.util.ArrayDeque;

public class ConvertXY {
    public static int convertXY(int src, int dst) {
        ArrayDeque<Integer> que = new ArrayDeque<Integer>();
        int arr[] = new int[100];
        int steps = 0;
        int index = 0;
        int value;
        que.add(src);
        while (que.size() != 0) {
            value = que.remove();
            arr[index++] = value;
            if (value == dst) {
                for (int i = 0; i < index; i++)
                    System.out.print(arr[i]+" ");
                System.out.println();
                System.out.print("Steps counter :: " + steps);
                return steps;
            }
        steps++;
        if (value < dst) que.add(value * 2); else
            que.add(value - 1); }
        return -1;
    }
    public static void main(String[] args) {
        convertXY(2, 7);
    }
}
