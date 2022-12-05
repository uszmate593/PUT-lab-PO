#include"twoNumberStatistics.hpp"

twoNumberStatistics::twoNumberStatistics(int firstValue, int secondValue)
{
    this->firstValue = firstValue;
    this->secondValue = secondValue;
}

int twoNumberStatistics::max()
{
    return firstValue > secondValue ? firstValue : secondValue;
}

int twoNumberStatistics::min()
{
    return firstValue > secondValue ? secondValue : firstValue;
}

float twoNumberStatistics::avrage()
{
    return (firstValue + secondValue) / 2.0;
}