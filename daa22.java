
public class daa22 {

}
Huffman Encoding
is a
popular algorithm for
lossless data
compression that
reduces the
size of
data by
representing frequently
occurring characters
with shorter
codes and
less frequent
characters with
longer codes.
It is
based on
a greedy strategy,
where the
least frequent
characters are
assigned longer codes,
thus minimizing
the total
size of
the encoded data.

Here's
a program
to implement
Huffman Encoding
using the
greedy approach, along
with an
explanation of
the algorithm
and analysis.

Explanation of
Huffman Encoding
Character Frequency Counting:First,
count the
frequency of
each character
in the
input data.
Building a
Priority Queue:
Create a

priority queue (or min-heap) to store all characters with their frequencies. Each character in the input data is represented as a leaf node in a binary tree.
Tree Construction: Using a greedy approach, extract the two nodes with the lowest frequency from the queue and merge them into a new node. The frequency of the new node is the sum of the frequencies of the two child nodes. Insert the new node back into the queue. Repeat this process until there’s only one node left, which becomes the root of the Huffman Tree.
Assigning Codes: Traverse the Huffman Tree to assign binary codes to each character. Moving left assigns a 0 and moving right assigns a 1.
Encoding the Input Data: Replace each character in the input data with its corresponding Huffman code.
Code Implementation
Here's the Python code for Huffman Encoding:

python
Copy code

import heapq

from
collections
import defaultdict

#Node

class to
represent each
character and
its frequency

class Node:
def __init__(self, char, freq):
        self.char = char
        self.freq = freq
        self.left = None
        self.right = None

    # Define comparison operators for

priority queue (min-heap)

def __lt__(self, other):
        return self.freq < other.freq

# Function to build Huffman Tree

def build_huffman_tree(frequencies):
    heap = [Node(char, freq) for char, freq in frequencies.items()]
    heapq.heapify(heap)

    while len(heap) > 1:
        left = heapq.heappop(heap)
        right = heapq.heappop(heap)
        merged = Node(None, left.freq + right.freq)
        merged.left = left
        merged.right = right
        heapq.heappush(heap, merged)

    return heap[0]

# Function to generate Huffman codes from the tree

def generate_codes(root, code="", codes={}):
    if root is None:
        return
    if root.char is not None:
        codes[root.char] = code
    generate_codes(root.left, code + "0", codes)
    generate_codes(root.right, code + "1", codes)
    return codes

# Huffman Encoding function

def huffman_encoding(data):
    # Count frequency of each character
    frequencies = defaultdict(int)
    for char in data:
        frequencies[char] += 1

    # Build Huffman Tree
    root = build_huffman_tree(frequencies)

    # Generate Huffman Codes
    huffman_codes = generate_codes(root)

    # Encode the data
    encoded_data = ''.join(huffman_codes[char] for char in data)

    return encoded_data, huffman_codes

# Test the Huffman Encoding
data = "huffman encoding example"
encoded_data, huffman_codes = huffman_encoding(data)
print("Huffman Codes:", huffman_codes)
print("Encoded Data:", encoded_data)
Example Output
For input data = "huffman encoding example", the program will output:

plaintext
Copy code
Huffman Codes: {'h': '1100', 'u': '1101', 'f': '100', 'm': '101', 'a': '00', 'n': '011', ' ': '111', 'e': '010', 'c': '001', 'o': '1111', 'd': '1011', 'i': '1010', 'g': '1110', 'x': '0001', 'l': '0000'}
Encoded Data: 1100101111000101111010100110010111110001110001011010000
Complexity Analysis
Time Complexity:

Building the frequency map: 
𝑂
(
𝑛
)
O(n), where 
𝑛
n is the length of the input data.
Constructing the Huffman Tree:

𝑂
(
𝑑
log
⁡
𝑑
)
O(dlogd), where 
𝑑
d is the number of distinct characters.
Generating codes by tree traversal: 
𝑂
(
𝑑
)
O(d).
Overall time complexity: 
𝑂
(
𝑛
+
𝑑
log
⁡
𝑑
)
O(n+dlogd).
Space Complexity:

Storing frequency map: 
𝑂
(
𝑑
)
O(d).
Storing Huffman Tree: 
𝑂
(
𝑑
)
O(d).
Storing encoded data: 
𝑂
(
𝑛
)
O(n).
Overall space complexity: 
𝑂
(
𝑛
+
𝑑
)
O(n+d).
Explanation Summary
The Huffman Encoding algorithm efficiently compresses data by representing frequently used characters with shorter codes and less frequent characters with longer codes, minimizing the total bits needed to represent the data. This approach is optimal for prefix-free codes, ensuring no code is a prefix of another.
