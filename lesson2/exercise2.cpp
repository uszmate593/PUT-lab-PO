#include<iostream>

using namespace std;

class Building
{
    string state;

    public:

    void destroy()
    {
        state = "destroyed";
    }
}

class Twister
{
    double speed;
    double height;

    public:
    Twister(double speed, double height)
    {
        this.speed = speed;
        this.height = height;
    }

    void speedUp(double howMuch)
    {
        speed += howMuch;
    }

    void speedDown(double howMuch)
    {
        speed -= howMuch;
    }

    void grow(double growth)
    {
        height += growth;
    }

    void shrink(double ammount)
    {
        height -= ammount;
    }

    void destroyBuilding(Building toDestroy)
    {
        toDestroy.destroy();
    }
}

int main()
{

    return 0;
}