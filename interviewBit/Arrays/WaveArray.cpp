// g++ -std=c++ file.cpp -o program

/*
Given an array of integers, sort the array into a wave like array and return it, 
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

Example

Given [1, 2, 3, 4]

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]
 NOTE : If there are multiple answers possible, return the one thats lexicographically smallest. 
So, in example case, you will return [2, 1, 4, 3] 
*/

#include <vector>
#include <iostream>
using namespace std;

class Solution {
  public:
    vector<int> wave(vector<int> &);
    void output(vector<int> &);
};

vector<int> Solution::wave(vector<int> &A) {
    // sort integers to be in ascending order first,
    // because this helps ensure the lexicographically smallest order
    // it does this by sorting into ascending order, so we can be sure that the 
    // smallest number is on the left, and largest on the right
    // in the case that a large number is on the left, it might stay there
    // and produce an incorrect result
    struct {
        bool operator()(int a, int b)
        {
            return a < b;
        }
    } sortOperator;
    sort(A.begin(), A.end(), sortOperator);

    // loop until second to last element since doing swaps 
    for (int i = 0; i < A.size() - 1; i++) {
        int left = A[i];
        int right = A[i + 1];
        // if index number is even
        if (i % 2 == 0) {
            // if left is smaller, swap
            if (left < right) {
                int temp = A[i];
                A[i] = A[i + 1];
                A[i + 1] = temp;
            }
        }
        else {
            // if left is greater, swap
            if (left > right) {
                int temp = A[i];
                A[i] = A[i + 1];
                A[i + 1] = temp;
            }
        }
    }
    return A;
}

void Solution::output(vector<int> &A) {
  cout << "[";
  for (int i = 0; i < A.size(); i++) {
    cout << A[i];
    if (i < A.size() - 1) {
        cout << ",";
    }
  }
  cout << "]\n";
}

int main () {
  Solution sol;
  vector<int> test1 = {5, 1, 2, 3, 4};
  vector<int> res1 = sol.wave(test1);
  sol.output(res1);

  vector<int> test2 = {4, 1, 3, 2};
  vector<int> res2= sol.wave(test2);
  sol.output(res2);

  return 0;
}
