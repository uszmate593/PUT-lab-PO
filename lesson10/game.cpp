#include"game.hpp"

using namespace std;

void Game::Play()
{
    bool playing = true;
    while(playing)
    {
        while(true)
        {
            cout << "Insert word: ";
            cin >> input;
            if(shiritori.Play(input) == -1)
                break; 
        }
        cout << "Play agin? (y/any key): ";
        cin >> option;
        switch(option)
        {
            case 'y':
                shiritori.Restart();
                break;
            default:
                playing = false;
        }
    }
}