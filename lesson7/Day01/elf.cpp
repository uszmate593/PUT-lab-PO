#include"elf.hpp"

using namespace std;

Elf::Elf(vector<int> callories)
{
    this->callories = callories;
}

int Elf::calloriesCaried()
{
    int sum = 0;
    for(int i = 0;i < callories.size();i++)
        sum += callories[i];
    return sum;
}