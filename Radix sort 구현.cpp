#include <iostream>
#include <vector>
using namespace std;

int N = 15;
int arr[1000001];
int d = 3;
int p10[3] = { 1,10,100 };
vector <int> list[10];

int digitNum(int x, int a)
{
	return (x / p10[a]) & 10;
}

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	for (int i = 0; i < d; i++)
	{
		for (int j = 0; j < 10; j++) list[j].clear();
		for (int j = 0; j < N; j++)
			list[digitNum(arr[j], i)].push_back(arr[j]);
		int idx = 0;
		for (int j = 0; j < 10; j++)
		{
			for (auto x : list[j]) arr[idx++] = x;
		}
	}
	for (int i = 0; i < N; i++) cout << arr[i] << ' ';
}
