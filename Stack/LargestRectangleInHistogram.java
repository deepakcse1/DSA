package Stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
  public static void main(String[] args) {
     int[] heights = {2,1,5,6,2,3};
    largestRectangleArea(heights);
  }

  //108 ms, faster than 28.13%
  public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        //calculate next smallest in right
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            right[i] = (st.isEmpty()) ? n : st.peek();
            st.push(i);
        }
        System.out.println(Arrays.toString(right));
        //calculate next smallest in left
        int[] left = new int[n];
        st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            left[i] = (st.isEmpty()) ? -1 : st.peek();
            st.push(i);
        }

        System.out.println(Arrays.toString(left));
        int max = 0;
        for(int i = 0; i < n; i++){
            int curMax = heights[i] * (right[i] - left[i] - 1);
            max = Math.max(max, curMax);
        }
        return max;
    }

    //need to understand this solution
    // 10ms, faster than 98.76%
    public int largestRectangleArea_better(int[] heights) {
        int n = heights.length;
        int nse[] = new int[n]; // next smaller element
        for(int i=n-1;i>=0;i--){
            nse[i] = i+1;
            while(nse[i] != n && heights[nse[i]] >= heights[i])
                nse[i] = nse[nse[i]];
        }
        int pse[] = new int[n]; // previous smaller element
        for(int i=0;i<n;i++){
            pse[i]=i-1;
            while(pse[i] != -1 && heights[pse[i]] >= heights[i])
                pse[i] = pse[pse[i]];
        }
        int ar = 0;
        for(int i=0;i<n;i++){
            int h = heights[i];
            int wid = nse[i] - pse[i] - 1;
            ar = Math.max(ar, h * wid);
        }
        return ar;
    }
}
