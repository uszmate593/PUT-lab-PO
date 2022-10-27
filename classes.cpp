#include<iostream>

class Processor
{
	public:
	std::string serries;
	std::string producer;
};

class GraphicsCard
{
	public:
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

	public:
	void addGraphicsCard(GraphicsCard add)
	{
		if(gpuNumber > 9)
		{
			std::cout << "Not enough space" << std::endl;
			return;
		}
		gpus[gpuNumber] = add;
		gpuNumber++;
	}

	void addProcessor(Processor add)
	{
		if(processorsNumber > 9)
		{
			std::cout << "Not enough space" << std::endl;
			return;
		}
		processors[processorsNumber] = add;
		processorsNumber++;
	}
};


int main()
{
	Processor proc;
	proc.serries = "QW-1560";
	proc.producer = "QW Electronics";
	GraphicsCard gpu;
	gpu.producer = "AB Systems";
	gpu.serries = "TR4532-U";

	Computer local;
	local.addGraphicsCard(gpu);
	local.addProcessor(proc);
	return 0;
}
