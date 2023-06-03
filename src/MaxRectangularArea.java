import java.util.Stack;

public class MaxRectangularArea {
    public static int getMaxArea(int arr[]){
        int size = arr.length;
        Stack <Integer> stack = new  Stack<>();
        int maxArea = 0;
        int top;
        int areaWithTop;
        int i = 0;
        while (i < size){
            while (i < size && (stack.isEmpty() || arr[stack.peek()] <= arr[i])){
                stack.push(i++);
            }
            while(!stack.isEmpty() && (i == size || arr[stack.peek()] > arr[i])){
                top = stack.pop();
                areaWithTop = arr[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                if(maxArea < areaWithTop){
                    maxArea = areaWithTop;
                }
            }
        }
        return maxArea;

    }
    public static void main(String[] args) {
        int arr[] = {2,1,2,3,1};
        System.out.println(getMaxArea(arr));
    }
}
