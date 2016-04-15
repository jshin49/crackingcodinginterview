"""
Determine whether a string is a palindrome or not.
Ex: 'racecar' => True
Ex: 'race' => False
"""

def is_palindrome(word):
    for index in range(0, len(word) / 2):
        if word[index] != word[len(word) - 1 - index]:
            return False
    return True

def is_palindrome_recursive(word):
    if len(word) <= 1:
        return True
    else:
        if word[0] != word[len(word) - 1]:
            return False
        else:
            return is_palindrome_recursive(word[1:-1])

def main():
    #print(is_palindrome('racecar'))
    #print(is_palindrome('race'))
    #print(is_palindrome('ra'))

    print(is_palindrome_recursive('racecar'))
    print(is_palindrome_recursive('race'))
    print(is_palindrome_recursive('ra'))

if __name__ == '__main__':
    main()
