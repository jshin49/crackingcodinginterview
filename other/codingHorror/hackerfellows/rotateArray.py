"""
Rotate an array n times to the right, where last element loops around to front (circular).
Ex: [1, 2, 3] rotated 2 times => [2, 3, 1]
Ex: [1, 2, 3] rotated 7 times => [3, 1, 2]

Modulus Operand allows for "wrapping around"

ex: if len(array) = 3
for indices of an array...
-----------
0 mod 3 = 0
1 mod 3 = 1
2 mod 3 = 2
3 mod 3 = 0
4 mod 3 = 1
...
"""

def rotate_array(array, n):
    rotated = [item for item in array]
    for index in range(0, len(array)):
        # modulus operand allows for "wrapping around"
        rotated[(index + n) % len(array)] = array[index]
    return rotated

def main():
    print(rotate_array([1, 2, 3], 2))
    print(rotate_array([1, 2, 3], 7))

if __name__ == '__main__':
    main()
