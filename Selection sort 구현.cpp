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

void SelectionSort(int arr[], int size)
{
	int minidx;
	
	for (int i = 0; i < size - 1; i++)
	{
		minidx = i;

		for (int j = i + 1; j < size; j++)
		{
			if (arr[j] < arr[minidx]) minidx = j;
		}
		swap(arr[i], arr[minidx]);
	}
}

int main(void)
{
	SelectionSort(arr, 5);
	for (int i = 0; i < 5; i++) cout << arr[i] << ' ';
}
