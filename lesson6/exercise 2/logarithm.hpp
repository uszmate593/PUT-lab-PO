#include<cmath>
#include<stdexcept>
#include<iostream>
#include"number.hpp"

class Logarithm : public Number
{
    double base, argument;

    public:
    Logarithm(double base, double argument);

    double doubleValue();
};
