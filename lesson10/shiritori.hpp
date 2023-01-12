#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Shiritori final
{
    vector<string> words;
    bool gameOver = false;

    public:
    int Play(string word);
    void Restart();
    void PrintWords();
};