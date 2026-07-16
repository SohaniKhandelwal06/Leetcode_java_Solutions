// Leetcode - 901 - Online Stock Span

/*
Approach (Monotonic Decreasing Stack):
1. Maintain a stack of pairs:
   - Price
   - Span of that price
2. For every new price:
   - Initialize span = 1.
   - While the stack is not empty and the top price is
     less than or equal to the current price:
       - Add its span to the current span.
       - Pop it from the stack.
3. Push the current {price, span} pair.
4. Return the computed span.

Why store span?
- Instead of checking each previous day one by one,
  we directly skip multiple days using the stored span,
  making the solution O(N).

Time Complexity:
next(): Amortized O(1)

Space Complexity:
O(N)
*/

class StockSpanner {
    Stack<int[]>st;

    public StockSpanner() {
        st=new Stack<>();
        
    }
    
    public int next(int price) {
        int idx=1;
        while(!st.isEmpty() && st.peek()[0]<=price){

            idx=idx+st.pop()[1];
        }
        st.push(new int[]{price,idx});
        return idx;
    }
        
}
