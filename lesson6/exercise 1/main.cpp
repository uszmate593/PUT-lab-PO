#include<iostream>
#include"twoNumberStatistics.hpp"

using namespace std;

int main()
{
    twoNumberStatistics example(12 , 5);
    cout << example.avrage() << " " << example.max() << " " << example.min() << endl;
}