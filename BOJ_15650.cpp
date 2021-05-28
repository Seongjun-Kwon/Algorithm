#include <iostream>
using namespace std;

int n, m;
int arr[10];
bool used[10];

void func(int index, int k)
{
	if (k == m)
	{
		for (int i = 0; i < m; i++)
			cout << arr[i] << ' ';
		cout << '\n';
		return;
	}

	for (int i=index; i<=n; i++)
	{
		if (!used[i])
		{
			arr[k] = i;
			used[i] = 1;
			func(i + 1, k + 1);
			used[i] = 0;
		}
	}
}

int main()
{
	ios::sync_with_stdio();
	cin.tie();

	cin >> n >> m;
	func(1, 0);

	return 0;
}
