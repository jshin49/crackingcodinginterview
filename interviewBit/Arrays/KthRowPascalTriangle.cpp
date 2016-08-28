// g++ -std=c++ file.cpp -o program

/*
Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1]. 
Note:Could you optimize your algorithm to use only O(k) extra space?
*/

#include <vector>
#include <iostream>
using namespace std;

class Solution {
  public:
    vector<int> getRow(int);
};

vector<int> Solution::getRow(int A) {
    // base case, no previous row
    if (A == 0) {
        vector<int> row0 = {1};
        return row0;
    }
    // base case, previous row doesn't have two values to use
    if (A == 1) {
        vector<int> row1 = {1, 1};
        return row1;
    }
    // recursive case
    else {
        vector<int> prevRow = getRow(A - 1);

        vector<int> rowA;
        rowA.push_back(1);
        for(int j = 1; j < A; j++) {
            rowA.push_back(prevRow[j] + prevRow[j - 1]);
        }
        rowA.push_back(1);
        return rowA;
   }
}

int main () {
  cout << "Enter k for Kth row of Pascal's Triangle: ";

  int k;
  cin >> k;
  
  Solution sol;
  vector<int> s = sol.getRow(k);

  cout << "[";
  for (int i = 0; i < s.size(); i++) {
    cout << s[i];
    if (i < s.size() - 1) {
        cout << ",";
    }
  }
  cout << "]\n";
  return 0;
}
