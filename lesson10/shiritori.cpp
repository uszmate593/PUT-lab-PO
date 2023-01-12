#include"shiritori.hpp"

using namespace std;

int Shiritori::Play(string word)
{
    transform(word.begin(), word.end(),word.begin(), ::tolower);
    if(gameOver)
        return -1;
    if(!words.empty())
    {
        string checkWord = words[words.size() - 1];
        if(word[0] != checkWord[checkWord.size() - 1])
        {
            gameOver = true;
            cout << "Game over" << endl;
            return -1;
        }

        for(int i = 0;i < words.size();i++)
        {
            if(word == words[i])
            {
                gameOver = true;
                cout << "Game over" << endl;
                return -1;
            }
        }
    }
    

    words.push_back(word);
    PrintWords();
    return 0;
}

void Shiritori::PrintWords()
{
    cout << "[ ";
    for(int i = 0;i < words.size();i++)
        cout << words[i] << " ";
    cout << "]" << endl;
}

void Shiritori::Restart()
{
    words.clear();
    gameOver = false;
    cout << "Game restarted"<< endl;
}