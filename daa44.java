public class daa44 {
    The 0-1 Knapsack problem is a well-known optimization problem in which each item can either be taken in its entirety (1) or left out (0). Given a set of items, each with a weight and a value, and a maximum capacity, the goal is to maximize the total value of the items that can fit within the capacity.

We can solve this problem using Dynamic Programming (DP) or Branch and Bound. Here's an explanation, the code for the DP approach, and the time and space complexity for both methods.

Problem Explanation
Given:

A set of items, each with a specific weight and value.
A maximum weight (capacity) of the knapsack.
Objective:

Maximize the total value of the selected items without exceeding the knapsack's weight capacity.
Dynamic Programming Approach
In the DP approach, we use a 2D table to store solutions to subproblems, where:

𝑑
𝑝
[
𝑖
]
[
𝑤
]
dp[i][w] represents the maximum value achievable with the first 
𝑖
i items and a knapsack capacity of 
𝑤
w.
Dynamic Programming Steps:
Initialize the Table: Create a 2D table dp of size (n+1) x (capacity+1), where n is the number of items.
Build the Table:
For each item, decide whether to include it in the knapsack or not:
If included: Add the value of the item plus the optimal solution for the remaining capacity.
If not included: Use the optimal solution for the previous items and the same capacity.
Trace the Solution: The value at dp[n][capacity] will be the maximum achievable value.
Here's the code for the DP solution:

python
Copy code
# Function to solve 0-1 Knapsack problem using Dynamic Programming
def knapsack_dp(capacity, weights, values):
    n = len(values)
    dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

    # Build dp table in bottom-up manner
    for i in range(1, n + 1):
        for w in range(capacity + 1):
            if weights[i - 1] <= w:
                dp[i][w] = max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]])
            else:
                dp[i][w] = dp[i - 1][w]

    return dp[n][capacity]

# Test the function
values = [60, 100, 120]
weights = [10, 20, 30]
capacity = 50
max_value = knapsack_dp(capacity, weights, values)
print("Maximum value in the knapsack:", max_value)
Example Output
For the test input:

Values = [60, 100, 120]
Weights = [10, 20, 30]
Capacity = 50
The output will be:

plaintext
Copy code
Maximum value in the knapsack: 220
Explanation of the DP Table
For each item and weight capacity, we either:

Exclude the item, resulting in the previous maximum at dp[i-1][w].
Include the item, taking the current item’s value plus the remaining capacity w - weights[i-1] using dp[i-1][w - weights[i-1]].
At the end, dp[n][capacity] gives the maximum achievable value.

Complexity Analysis - Dynamic Programming
Time Complexity: 
𝑂
(
𝑛
⋅
𝑊
)
O(n⋅W), where 
𝑛
n is the number of items and 
𝑊
W is the knapsack capacity. This is because we fill the 
(
𝑛
+
1
)
×
(
𝑊
+
1
)
(n+1)×(W+1) table.
Space Complexity: 
𝑂
(
𝑛
⋅
𝑊
)
O(n⋅W) for storing the table.
Branch and Bound Strategy
The Branch and Bound approach is useful when we want to solve the 0-1 Knapsack problem optimally without using the DP table. In this strategy:

We build a state-space tree and explore branches by including or excluding each item.
At each node, we calculate a bound on the best possible solution from that node:
If the bound is worse than the best solution so far, prune that branch.
Otherwise, explore it further.
This approach finds the optimal solution but does not guarantee polynomial time complexity.
Complexity Analysis - Branch and Bound
Time Complexity: The worst-case time complexity is exponential, 
𝑂
(
2
𝑛
)
O(2 
n
 ), but practical performance can be much better due to pruning.
Space Complexity: The space complexity is 
𝑂
(
𝑛
)
O(n) for storing the recursion stack.
Summary of Comparison
Approach	Time Complexity	Space Complexity	Comments
Dynamic Programming	
𝑂
(
𝑛
⋅
𝑊
)
O(n⋅W)	
𝑂
(
𝑛
⋅
𝑊
)
O(n⋅W)	Efficient for small to medium capacity, always optimal, but may require large memory for big inputs.
Branch and Bound	
𝑂
(
2
𝑛
)
O(2 
n
 )	
𝑂
(
𝑛
)
O(n)	Optimal but can be infeasible for large 
𝑛
n, benefits from pruning in practice.
The Dynamic Programming approach is preferred when capacity 
𝑊
W is manageable because it provides a guaranteed optimal solution efficiently. The Branch and Bound approach is better for larger capacities when we expect to prune branches to reduce computations significantly.







}
