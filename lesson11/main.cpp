#include<iostream>
#include"characters.hpp"

using namespace std;

int main()
{
    Characters test("Qwertyuiop"), test2("azertyuiop");
    Substring subs(test, 2, 5);
    Concatenation conc(test,test2);
    cout << subs.PrintedSeq() << " " << conc.PrintedSeq() << endl;
    return 0;
}