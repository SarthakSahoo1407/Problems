import java.util.ArrayDeque;

public class JosephusProblem {
    //JosephusProblem using queue
    static int josephus(int n, int k) {
        ArrayDeque<Integer> que = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++)
            que.add(i + 1);

        while (que.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                que.add(que.peek());
                que.remove();
            }
            que.remove();// Kth person executed.
        }
        return que.peek();
    }

    // Testing code
    public static void main(String[] args) {
        System.out.println("Position : " + josephus(100, 0));
    }
}
