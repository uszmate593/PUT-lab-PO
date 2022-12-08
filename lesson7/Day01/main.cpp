#include"elf.hpp"
#include<string>
#include<iostream>
#include<fstream>

using namespace std;

int main()
{
    vector<Elf> elves;
    vector<int> callories;
    ifstream input;
    input.open("Day01.txt");
    string inputString;
    int maxCallories = 0;
    int carriedCallories;
    while(getline(input, inputString))
    {
        if(inputString == "\n")
        {
            elves.push_back(Elf(callories));
            while(callories.size() != 0)
                elves.pop_back();
        }
        else
            callories.push_back(stoi(inputString));
    }
    input.close();
    for(int i = 0;i < elves.size();i++)
    {
        carriedCallories = elves[i].calloriesCaried();
        if(carriedCallories > maxCallories)
            maxCallories = carriedCallories;
    }
    cout << maxCallories << endl;
    return 0;
}