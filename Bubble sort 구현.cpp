#include <iostream>
using namespace std;

int arr[5] = { 8,5,1,3,6 };

void swap(int* a, int* b)
{
	int tmp;
	tmp = *a;
	*a = *b;
	*b = tmp;
}

void BubbleSort(int arr[], int size)
{
	for (int i = size - 1; i > 0; i--)
	{
		for (int j = 0; j < i; j++)
		{
			if (arr[j] > arr[j + 1]) swap(arr[j], arr[j + 1]);
		}
	}
}

int main(void)
{
	BubbleSort(arr, 5);
	for (int i = 0; i < 5; i++) cout << arr[i] << ' ';
}
