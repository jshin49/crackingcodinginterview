// g++ -std=c++ file.cpp -o program

#include <vector>
#include <iostream>
using namespace std;

class Solution {
  public:
    vector<vector<int> > generate(int);
};

vector<vector<int> > Solution::generate(int A) {
    vector<vector<int> > pascal;
    // base case, no previous row
    if (A == 1) {
        vector<int> row0 = {1};
        pascal.push_back(row0);
        return pascal;
    }
    // base case, previous row doesn't have two values to use
    if (A == 2) {
        pascal = generate(A - 1);
        vector<int> row1 = {1, 1};
        pascal.push_back(row1);
        return pascal;
    }
    // recursive case
    else {
        pascal = generate(A - 1);
        vector<int> rowA;
        rowA.push_back(1);
        for(int j = 1; j < A - 1; j++) {
            rowA.push_back(pascal[A - 1 - 1][j] + pascal[A - 1 - 1][j - 1]);
        }
        rowA.push_back(1);
        pascal.push_back(rowA);
        return pascal;
    }
}

int main () {
  Solution sol;
  vector<vector<int> > s = sol.generate(3);

  cout << "[\n";
  for (int i = 0; i < s.size(); i++) {
    cout << "[";
    for (int j = 0; j < s[i].size(); j++) {
        cout << s[i][j];
        if (j < s[i].size() - 1) {
            cout << ",";
        }
    }
    cout << "],\n";
  }
  cout << "]\n";
  return 0;
}
