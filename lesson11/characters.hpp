#include"sequance.hpp"

using namespace std;

class Characters : public Sequence
{
    string text;
    public:
    Characters()
    {

    }
    Characters(string text)
    {
        this->text = text;
    }
    string PrintedSeq()
    {
        return text;
    }
};

/*class LoweredCase : public Sequence
{
    Characters text;
    public:
    LoweredCase(Characters text)
    {
        this->text = text;
    }
    string PrintedSeq()
    {
        string processed = "";
        for(int i = 0;i < text.PrintedSeq().size();i++)
        {
            if()
        }
        return processed;
    }
};*/

class Substring : public Sequence
{
    Characters text;
    int begining, length;
    public:
    Substring(Characters text, int begining, int length)
    {
        this->text = text;
        this->begining = begining;
        this->length = length;
    }
    string PrintedSeq()
    {
        return text.PrintedSeq().substr(begining, length);
    }
};

class Concatenation : public Sequence
{
    Characters text1 , text2;
    public:
    Concatenation(Characters text1, Characters text2)
    {
        this->text1 = text1;
        this->text2 = text2;
    }
    string PrintedSeq()
    {
        return text1.PrintedSeq() + text2.PrintedSeq();
    }
};