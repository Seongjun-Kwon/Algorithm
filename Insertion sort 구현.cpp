#include <iostream>
using namespace std;

int arr[5] = { 8,5,1,3,6 };

void InsertionSort(int arr[], int size)
{
	int key, j;

	for (int i = 1; i < size; i++)
	{
		key = arr[i];
		j = i - 1;

		while ((j >= 0) && (arr[j] > key))
		{
			arr[j + 1] = arr[j];
			j--;
		}
		arr[j + 1] = key;
	}
}

int main(void)
{
	InsertionSort(arr, 5);
	for (int i = 0; i < 5; i++) cout << arr[i] << ' ';
}
