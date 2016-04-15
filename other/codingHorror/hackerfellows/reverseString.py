"""
Reverse a string
"""

def reverse_string(string):
    chars = [char for char in string]
    for i in range(0, len(chars) / 2):
        front = chars[i]
        chars[i] = chars[len(chars) - 1 - i]
        chars[len(chars) - 1 - i] = front
    reversed = ''.join(chars)
    return reversed

def main():
    print(reverse_string('abc'))

if __name__ == '__main__':
    main()
