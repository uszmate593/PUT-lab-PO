#include<iostream>
#include"twoNumberStatistics.hpp"

using namespace std;

int main()
{
    twoNumberStatistics example(12 , 4);
    cout << example.avrage() << " " << example.max() << " " << example.min() << endl;
}