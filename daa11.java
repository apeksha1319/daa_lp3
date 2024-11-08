he Fibonacci sequence is a series of numbers in which each number (Fibonacci number) is the sum of the two preceding ones, usually starting with 0 and 1. In this program, we’ll implement both the non-recursive (iterative) and recursive approaches to calculate Fibonacci numbers and analyze their time and space complexity.

1. Iterative (Non-recursive) Approach
In this approach, we use a loop to calculate the Fibonacci sequence up to the desired number. This method is more efficient in terms of time complexity compared to the recursive approach.

python
Copy code
# Iterative Fibonacci function
def fibonacci_iterative(n):
    if n <= 1:
        return n
    a, b = 0, 1
    for _ in range(2, n + 1):
        a, b = b, a + b
    return b

# Test the function
print(fibonacci_iterative(10))  # Output: 55
Complexity Analysis - Iterative
Time Complexity: 
𝑂
(
𝑛
)
O(n)
Since we’re iterating from 2 to 
𝑛
n, the time complexity is linear.
Space Complexity: 
𝑂
(
1
)
O(1)
Only a constant amount of space is used to store variables a and b.
2. Recursive Approach
In this approach, we use a function that calls itself to calculate the Fibonacci sequence. Although this method is simpler, it’s less efficient due to the large number of redundant calls.

python
Copy code
# Recursive Fibonacci function
def fibonacci_recursive(n):
    if n <= 1:
        return n
    return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2)

# Test the function
print(fibonacci_recursive(10))  # Output: 55
Complexity Analysis - Recursive
Time Complexity: 
𝑂
(
2
𝑛
)
O(2 
n
 )
The recursive approach generates a tree with exponential growth due to repeated calculations.
Space Complexity: 
𝑂
(
𝑛
)
O(n)
The space complexity is linear because each recursive call adds to the call stack, resulting in a maximum depth of 
𝑛
n.
Comparing Both Approaches
Iterative is more efficient for larger values of 
𝑛
n, with linear time and constant space complexity.
Recursive is easier to implement but becomes infeasible for large 
𝑛
n due to exponential time complexity and a deeper call stack.
In summary:

Iterative is best for performance.
Recursive is simpler but inefficient for large inputs due to exponential growth.
