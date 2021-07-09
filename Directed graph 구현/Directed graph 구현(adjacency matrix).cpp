#include <iostream>
using namespace std;

int matrix[10][10] = {};
int a, b;

int main(void)
{
	cin >> a >> b;

	for (int i = 0; i < b; i++)
	{
		int c, d;
		cin >> c >> d;
		matrix[c][d] = 1;
	}
}
