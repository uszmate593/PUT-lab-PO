#include<iostream>
#include<cassert>
#include"game.hpp"

using namespace std;

int main()
{
    FakeFootballGame test;

    assert(test.Score() == 3);
    return 0;
}