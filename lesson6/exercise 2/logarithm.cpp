#include"logarithm.hpp"
#include<stdexcept>

Logarithm::Logarithm(double base, double argument)
{
    this->argument = argument;
    this->base = base;
}

double Logarithm::doubleValue()
{
    try
    {
        if(base < 1)
            throw(std::invalid_argument("Base of logarithm cannot be lower then 1"));
        if(argument <=0)
            throw(std::invalid_argument("Argument of lagarithm cannot be lowr or equal to 0"));
        return log(argument) / log(base);
    }
    catch(std::invalid_argument)
    {
        
    }
}