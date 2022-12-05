#include"logarithm.hpp"

Logarithm::Logarithm(double base, double argument)
{
    this->argument = argument;
    this->base = base;
}

double Logarithm::doubleValue()
{
    try
    {
        if(base != 1 && base > 0)
            throw(std::invalid_argument("Base of logarithm must be grater than 0 and not equal to 1"));
        if(argument <)
            throw(std::invalid_argument("Argument of lagarithm cannot be greater then 0"));
        return log(argument) / log(base);
    }
    catch(std::invalid_argument)
    {
        cout << "It is not a proper logarithm." << endl;
    }
}