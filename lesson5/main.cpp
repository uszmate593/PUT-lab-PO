#include <iostream>
#include <map>
#include <sstream>
#include <iomanip>
#include <string>

class FakeCantor {
 private:
  std::map<std::string, float> rates{{"USD", 1.0366f},
                                     {"GBP", 0.87063f},
                                     {"CHF", 0.9881f},
                                     {"JPY", 145.12f}};
 public:
  FakeCantor() = default;
  float EuroToRate(const std::string &currency) {
    return rates[currency];
  };
};

class Currency {
 public:
  virtual Currency *AddedCurrency(float value, std::string currency) = 0;
  virtual Currency *SubtractedCurrency(float value, std::string currency) = 0;
  virtual std::string Abbreviation() = 0;
  virtual std::string Symbol() = 0;
  virtual std::string Balance() = 0;
  virtual float DollarExchangeRate() = 0;
};

class Euro : public Currency {
  float inPossession;
  FakeCantor FC;
  
  public:
  Euro(float moneyAmmount)
  {
    inPossession = moneyAmmount;
  }
  
  Euro *AddedCurrency(float value, std::string currency)
  {
    Euro *tmp = new Euro(inPossession + value / FC(currency));
    return tmp;
  }

  Euro *SubtractedCurrency(float value, std::string currency)
  {
    float subtraction = inPossession - value / FC(currency);
    Euro *tmp
    if(subtraction < 0)
      *tmp = new Euro(0);
    else
      *tmp = new Euro(subtraction);
    return tmp;
  }

  std::string Abbreviation()
  {
    return "EUR";
  }

  std::string Symbol()
  {
    return "\u20AC";
  }

  std::string Balance()
  {
    return "\u20AC" + std::to_string(inPossession);
  }

  float DollarExchangeRate()
  {
    return "\u20AC1 | $" + FC("USD");
  }
};

int main() {
  Euro state1(1250.9), *state2, *state3, *state4;
  std::cout << state1.Balance() << " " << state1.Symbol() << " " << state1.Abbreviation() << " " << state1.DollarExchangeRate() << std::endl;
  state2 = state1.SubtractedCurrency(2000.8, "GBP");
  std::cout << state1.Balance() << std::endl;
  return 0;
}
