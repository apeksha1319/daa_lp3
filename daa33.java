public class daa33 {
    The Fractional Knapsack problem is a variation of the classic Knapsack problem, where we can take fractions of items rather than needing to select them entirely. The goal is to maximize the total value within a given weight capacity. A greedy approach is ideal for the fractional knapsack problem because we can pick items in decreasing order of their value-to-weight ratio.

Problem Explanation
Given:

A set of items, each with a specific weight and value.
A maximum capacity of the knapsack.
Objective:

Maximize the total value in the knapsack by selecting items or portions of items based on the highest value-to-weight ratio until the knapsack reaches its maximum capacity.
Greedy Strategy
Calculate Value-to-Weight Ratio: For each item, calculate the ratio of value to weight.
Sort Items by Ratio: Sort items in descending order of this ratio.
Fill the Knapsack: Select items from the sorted list, adding them to the knapsack. If an item can fully fit within the remaining capacity, add it entirely. Otherwise, take as much of the item as possible to fill the remaining space in the knapsack.
Program Implementation
Here’s a Python implementation of the Fractional Knapsack problem using the greedy approach.

python
Copy code
# Class representing each item with weight and value
class Item:
    def __init__(self, value, weight):
        self.value = value
        self.weight = weight

# Function to calculate the maximum value for fractional knapsack
def fractional_knapsack(capacity, items):
    # Calculate value-to-weight ratio for each item and sort by descending order
    items.sort(key=lambda item: item.value / item.weight, reverse=True)
    
    total_value = 0.0  # Total value of items in the knapsack
    for item in items:
        if capacity == 0:
            break  # Knapsack is full

        # Take as much of the item as possible
        if item.weight <= capacity:
            # If the whole item can fit, take it
            capacity -= item.weight
            total_value += item.value
        else:
            # Take fraction of the item
            fraction = capacity / item.weight
            total_value += item.value * fraction
            capacity = 0  # Knapsack is now full

    return total_value

# Test the function
items = [Item(60, 10), Item(100, 20), Item(120, 30)]
capacity = 50
max_value = fractional_knapsack(capacity, items)
print("Maximum value in the knapsack:", max_value)
Example Output
For the test items:

Item 1: Value = 60, Weight = 10
Item 2: Value = 100, Weight = 20
Item 3: Value = 120, Weight = 30
Capacity = 50
The output will be:

plaintext
Copy code
Maximum value in the knapsack: 240.0
Explanation of Output
First Item: Item 1 has the highest value-to-weight ratio, so it’s taken fully, reducing capacity to 40.
Second Item: Item 2 is then taken fully, reducing capacity to 20.
Third Item: Only part of Item 3 (20/30) can fit, so a fraction is taken to fill the knapsack.
Complexity Analysis
Time Complexity:

Sorting the items based on value-to-weight ratio: 
𝑂
(
𝑛
log
⁡
𝑛
)
O(nlogn), where 
𝑛
n is the number of items.
Iterating over the sorted list to fill the knapsack: 
𝑂
(
𝑛
)
O(n).
Overall Time Complexity: 
𝑂
(
𝑛
log
⁡
𝑛
)
O(nlogn).
Space Complexity:

The only extra space used is for storing the sorted items, which takes 
𝑂
(
𝑛
)
O(n) space.
Overall Space Complexity: 
𝑂
(
𝑛
)
O(n).
Explanation Summary
The Fractional Knapsack problem benefits from a greedy approach because we maximize value by choosing items based on their value-to-weight ratio. Sorting items initially lets us select the highest ratio items first, ensuring optimal value. The program efficiently fills the knapsack by taking full items or fractions as needed, achieving an optimal solution in 
𝑂
(
𝑛
log
⁡
𝑛
)
O(nlogn) time complexity.
}
