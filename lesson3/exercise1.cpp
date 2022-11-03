#include<iostream>

using namespace std;

class Plant
{
    private:
    string commonName;
    string scientificName;
    bool edible;
    bool fullyGrown;

    public:
    Plant(string commonName, string scientificName, bool edible, bool fullyGrown)
    {
        this->commonName = commonName;
        this->scientificName = scientificName;
        this->edible = edible;
        this->fullyGrown = fullyGrown;
    }

    Plant(string commonName, string scientificName, bool edible) : Plant(commonName, scientificName, edible, false) {}

    Plant(string commonName, string scientificName) : Plant(commonName, scientificName, false, false) {}

    void examinPlant()
    {
        string isItEdible;
        string isItFullyGrown;
        if(edible)
            isItEdible = "edible";
        else
            isItEdible = "not edible";
        
        if(fullyGrown)
            isItFullyGrown = "fully grown.";
        else
            isItFullyGrown = "not fully grown.";

        cout << "This is " << scientificName << " also known as " << commonName << " and it is " << isItEdible << ". It is " << isItFullyGrown << endl;
    }

    bool isEdible()
    {
        return edible;
    }

    bool isFullyGrown()
    {
        return fullyGrown;
    }
};

int main()
{
    Plant unknownPlant1("tomato plant", "Solanum lycopersicum", true, true);
    unknownPlant1.examinPlant();
    cout << unknownPlant1.isEdible() << endl;

    Plant unknownPlant2("cucumber", "Cucumis sativus", true);
    unknownPlant2.examinPlant();
    cout << unknownPlant1.isFullyGrown() << endl;

    Plant unknownPlant3("oak", "Quercus");
    unknownPlant3.examinPlant();
    return 0;
}