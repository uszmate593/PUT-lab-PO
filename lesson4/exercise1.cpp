#include<iostream>

using namespace std;

class Room
{
    public:
    virtual string WhatIsHappening() = 0;
    virtual float Size() = 0;
    virtual int HowManyPeopleCanGetInside() = 0;
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
    
    string WhatIsHappening()
    {
        return currentLesson;
    }

    float Size()
    {
        return width * lenght;
    }

    int HowManyPeopleCanGetInside()
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
    cout << first.Size() << endl << first.WhatIsHappening() << endl << second.Size() << endl << second.WhatIsHappening() << endl;
    return 0;
}