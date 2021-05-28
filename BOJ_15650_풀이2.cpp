#include <iostream>
#include <algorithm>
using namespace std;

int n, m;
int arr[10];

int main()
{
	ios::sync_with_stdio();
	cin.tie();

	cin >> n >> m;
	fill(arr, arr + n, 1);
	for (int i = 0; i < m; i++) arr[i] = 0;

	do
	{
		for (int i = 0; i < n; i++)
		{
			if(!arr[i])
				cout << i+1 << ' ';
		}
		cout << '\n';
	} 
	while (next_permutation(arr, arr + n));

	return 0;
}
