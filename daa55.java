public class daa55 {
    // Design n-Queens matrix having first Queen placed. Use backtracking to place
    // remaining Queens to generate the final n-queen‘s matrix.
}The N-
Queens problem
is a
classic backtracking
problem where
we place
𝑛
n
queens on
an 𝑛×
𝑛
n×
n chessboard
such that
no two
queens threaten
each other.
In other words,
no two
queens should
be placed
in the
same row, column, or
diagonal.

Problem Explanation Given:

An 𝑛×
𝑛
n×n chessboard.
The initial
position of
the first queen.Objective:

Place the
remaining 
𝑛−1 n−1
queens on
the board
so that
no two
queens attack
each other.
Backtracking Strategy
Backtracking is
a method
to explore
all potential
configurations and“backtrack”
when a
configuration fails, allowing
exploration of
other potential
placements.

        Steps to
Solve the N-
Queens Problem
Initialize the Board:
Start with
an 𝑛×
𝑛
n×n matrix
filled with 0(representing empty cells).
Place the
First Queen:
Set the
first queen
at the
given starting
position.
Recursive Backtracking:
For each
row from 1
to 
𝑛−1 n−1,
attempt to
place a
queen in
one of
the columns.
If a
placement satisfies

the constraints (no other queen in the same row, column, or diagonal), mark that cell with a 1.
Recursively attempt to place the next queen.
If placing a queen in the current row fails, backtrack to the previous row and try a different position.
Constraint Checks: For each queen placement, check that no queens are in the same column, main diagonal, or secondary diagonal.
If we successfully place all 
𝑛
n queens, we have found a solution. Otherwise, we backtrack until a solution is found or all possibilities are exhausted.

Code Implementation
Here’s the Python code for solving the N-Queens problem using backtracking. We assume the first queen’s initial position is provided.

python
Copy code
# Function to print the board

def print_board(board):
    for row in board:
        print(" ".join(str(cell) for cell in row))
    print()

# Function to check if a queen can be safely placed at board[row][col]

def is_safe(board, row, col, n):
    # Check column for any queen
    for i in range(row):
        if board[i][col] == 1:
            return False

    # Check upper left diagonal
    i, j = row, col
    while i >= 0 and j >= 0:
        if board[i][j] == 1:
            return False
        i -= 1
        j -= 1

    # Check upper right diagonal
    i, j = row, col
    while i >= 0 and j < n:
        if board[i][j] == 1:
            return False
        i -= 1
        j += 1

    return True

# Recursive function to solve the N-Queens problem

def solve_n_queens(board, row, n):
    if row == n:
        print("Solution:")
        print_board(board)
        return True

    # Try placing a queen in each column in the current row
    for col in range(n):
        if is_safe(board, row, col, n):
            board[row][col] = 1
            if solve_n_queens(board, row + 1, n):
                return True
            # Backtrack
            board[row][col] = 0

    return False

# Function to initiate N-Queens problem with a given first queen position

def n_queens(n, first_row, first_col):
    # Initialize board
    board = [[0 for _ in range(n)] for _ in range(n)]
    # Place the first queen
    board[first_row][first_col] = 1
    # Start solving from the next row
    if

not solve_n_queens(board, first_row + 1, n):
        print("No solution exists")
    else:
        print("Final Board:")
        print_board(board)

# Test the function
n = 4
first_row, first_col = 0, 1  # First Queen position
n_queens(n, first_row, first_col)
Example Output
For 
𝑛
=
4
n=4 and the first queen placed at position (0, 1), the program will output:

plaintext
Copy code
Solution:
0 1 0 0
0 0 0 1
1 0 0 0
0 0 1 0

Final Board:
0 1 0 0
0 0 0 1
1 0 0 0
0 0 1 0
Explanation of the Code
Initial Placement: The n_queens function places the first queen at

the specified (first_row, first_col).
Backtracking:
The solve_n_queens function is called recursively, attempting to place a queen in each row while checking safety constraints using the is_safe function.
If a placement fails, the function backtracks by removing the queen and attempting another column in the same row.
Complexity Analysis
Time Complexity: 
𝑂
(
𝑛
!
)
O(n!)

In the worst case, the algorithm tries every combination of queen placements, resulting in a factorial complexity, 
𝑂
(
𝑛
!
)
O(n!), as there are 
𝑛
n choices for each queen in each row.
Space Complexity: 
𝑂
(
𝑛
2
)
O(n 
2
 )

The space complexity includes:
The board representation, which takes 
𝑂
(
𝑛
2
)
O(n 
2
 ) space.
The recursive call stack, which has a depth of 
𝑛
n, resulting in 
𝑂
(
𝑛
)
O(n) space in addition to the board.
Summary
The N-Queens problem is efficiently solved with backtracking, exploring potential placements and pruning branches that violate the constraints. The backtracking approach tries different configurations, backtracking whenever it encounters an invalid state. This method ensures all possibilities are explored without unnecessary checks, balancing between exploration and pruning to find a valid solution.
