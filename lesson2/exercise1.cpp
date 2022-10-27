#include<iostream>

using namespace std;

class Blouse
{
    string color;
    string size;
    string material;
    unsigned int cleanliness;

    public:
    Blouse(string color, string size, string material, unsigned int cleanliness)
    {
        this->color = color;
        this->size = size;
        this->material = material;
        this->cleanliness = cleanliness;
    }

    Blouse(string color, string size, string material, string cleanliness) : Blouse(color, size, material, stoi(cleanliness)){}
    
    Blouse(string color, string size, string material) : Blouse(color, size, material, 100){}

    Blouse(string color, string size) : Blouse(color, size, "synthetic", 100){}
    
    Blouse(string color) : Blouse(color, "M", "synthetic", 100){}

    Blouse(string color, unsigned int cleanliness) : Blouse(color, "M", "synthetic", cleanliness){}
    
};

int main()
{
    Blouse first("red", "XXL", "wool", "97");
    Blouse second("red", "XXL", "wool");
    Blouse third("red", "XXL");
    Blouse fourth("red");
    Blouse fifth("red", 10);
    return 0;
}