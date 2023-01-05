using namespace std;

class Game
{
    public:
    virtual int Score() = 0;
};

class FakeFootballGame : public Game
{
    public:
    int Score();
};