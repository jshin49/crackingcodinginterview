"""
Problem: Implement stack using either linked list or dynamic array.

Stack: Last-In-First-Out (LIFO) data structure.
Reference: http://introcs.cs.princeton.edu/java/43stack/

Dynamic Array:
- access to random elements via index
- resizing array can be time consuming since copying elements from old array to new

Linked List:
- memory allocated for each element in list can be expensive
- allocation of each object typically slower than resizing array
"""



# Implementation of Stack using Singly Linked List
class Node:

    def __init__(self, data):
        self.next = None
        self.data = data

class Stack:

    def __init__(self):
        self.head = None

    def __del__(self):
        # clean up items on stack
        while self.head is not None:
            self.pop()

    def is_empty(self):
        return self.head is None

    def push(self, data):
        new_head = Node(data)
        # if nothing on stack add new item
        if self.is_empty():
            self.head = new_head
        else:
            # if at least one item, add new head, set next to old head
            old_head = self.head
            self.head = new_head
            self.head.next = old_head

    def pop(self):
        # if nothing on stack raise exception
        if self.is_empty():
            raise ValueError
        else:
            # if one item, set head to none and return old head data
            if self.head.next is None:
                old_head = self.head
                self.head = None
                return old_head.data
            # if more than one item, set head to next and return old head data
            else:
                old_head = self.head
                new_head = old_head.next
                self.head = new_head
                return old_head.data

    def __str__(self):
        elem = self.head
        elements = list()
        while elem is not None:
            elements.append(elem.data)
            elem = elem.next
        return ''.join(elements)

def main():
    s = Stack()
    print(s.is_empty())
    print(str(s))
    s.push('a')
    s.push('b')
    s.push('c')
    print(str(s))
    print(s.pop())
    print(s.pop())
    print(s.pop())
    print(str(s))

if __name__ == '__main__':
    main()
