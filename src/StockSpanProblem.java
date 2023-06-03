import java.util.Stack;

public class StockSpanProblem {
    public static int[] stockSpanRange(int arr[]){
    Stack<Integer> stack = new Stack<>();

    int [] span = new int[arr.length];
    stack.push(0);
    span[0] = 1;
    for (int i = 1; i < arr.length; i++) {
        while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
            stack.pop();
        }
      if(stack.isEmpty()){
          span[i] = i+1;
        }else{
            span[i] = i - stack.peek();
      }
        stack.push(i);
    }
    return span;
    }

    public static void main(String[] args) {

        int arr[] = {100,80,60,70,60,75,85};
        int span[] = stockSpanRange(arr);
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }
}
