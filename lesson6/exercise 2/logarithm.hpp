#include<cmath>
#include"number.hpp"

class Logarithm : public Number
{
    double base, argument;

    public:
    Logarithm(double base, double argument);

    double doubleValue();
};
