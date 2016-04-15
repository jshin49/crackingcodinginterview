"""
Return the intersection (no duplicates) of common characters between two strings
Ex: ('dog', 'too') => 'o'
"""

def get_intersection(string_one, string_two):
    # use dictionary as a set, but faster performance since O(1) lookup
    unique_chars_one = dict()
    for char in string_one:
        # if char not already in set of unique chars, add as index (value doesn't really matter)
        if char not in unique_chars_one:
            unique_chars_one[char] = True

    # create set of common chars
    common_chars = set()
    for char in string_two:
        # if char exists as key in dictionary of unique chars from string_one
        if char in unique_chars_one:
            common_chars.add(char)
    return common_chars

def main():
    print(get_intersection('ddoggss', 'taoooss'))

if __name__ == '__main__':
    main()
