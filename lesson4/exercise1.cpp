#include<iostream>

using namespace std;

class Room
{
    public:
    virtual string checkWhatIsHappening() = 0;
    virtual float checkSize() = 0;
    virtual int checkHowManyPeopleCanGetInside() = 0;
};

class Classrom : public Room
{
    private:
    float width, lenght;
    int capacity;
    string currentLesson;
    public:
    Classrom(float width, float lenght, int capacity, string currentLesson)
    {
        this->width = width;
        this->lenght = lenght;
        this->capacity = capacity;
        this->currentLesson = currentLesson;
    }
    
    string checkWhatIsHappening()
    {
        return currentLesson;
    }

    float checkSize()
    {
        return width * lenght;
    }

    int checkHowManyPeopleCanGetInside()
    {
        return capacity;
    }

    Classrom beginNextLesson(string lessonName)
    {
        return Classrom(width, lenght, capacity, lessonName);
    }
};

int main()
{
    Classrom first(11.2, 10.0, 25, "English");
    Classrom second = first.beginNextLesson("Math");
    cout << first.checkSize() << endl << first.checkWhatIsHappening() << endl << second.checkSize() << endl << second.checkWhatIsHappening() << endl;
    return 0;
}