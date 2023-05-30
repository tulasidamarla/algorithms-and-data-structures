### knapsack problem

- Given the weights and profits of N items, in the form of {profit, weight} put these items in a knapsack(or bag) of capacity W(constraint) to get the maximum total profit(optimization) in the knapsack. 
  In Fractional Knapsack, we can break items for maximizing the total profit of the knapsack.
- Solution  
  - This approach calculates the ratio profit/weight for each item and sort the item on the basis of this ratio. 
  - Take the item with the highest ratio and add them until we can’t add the next item as a whole.
  - At the end add the next item as much as we can. 
  - This will always be the optimal solution to this problem.

### Code

  ```java
    // Function to get maximum profit
    private static double getMaxProfit(ItemValue[] arr, int capacity)
    {
        Arrays.sort(arr, (a, b) -> (int)((double)b.profit/(double)b.weight - (double)a.profit/(double)a.weight));

        double totalProfit = 0d;

        for (ItemValue i : arr) {

            int curWt = (int)i.weight;
            int curProfit = (int)i.profit;

            if (capacity - curWt >= 0) {

                // this weight can be picked while
                capacity = capacity - curWt;
                totalProfit += curProfit;
            }
            else {

                // Item cant be picked whole
                double fraction
                        = ((double)capacity / (double)curWt);
                totalProfit += (curProfit * fraction);
                capacity
                        = (int)(capacity - (curWt * fraction));
                break;
            }
        }

        return totalProfit;
    }

    // Item value class
    static class ItemValue {

        int profit, weight;

        // Item value function
        public ItemValue(int val, int wt)
        {
            this.weight = wt;
            this.profit = val;
        }
    }

  ```

    
