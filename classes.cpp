#include<iostream>

class Processor
{
	std::string serries;
	std::string producer;
};

class GraphicsCard
{
	std::string serries;
	std::string producer;
};

class Computer
{
	unsigned int id;
	unsigned int processorsNumber = 0;
	unsigned int gpuNumber = 0;
	Processor processors[10];
	GraphicsCard gpus[10];

	void addGraphicsCard(GrapgicsCard add)
	{
		if(gpuNumber > 9)
		{
			std::cout << "Not enough space" << std::endl;
			return;
		}
		
	}
};


int main()
{
	
	return 0;
}
