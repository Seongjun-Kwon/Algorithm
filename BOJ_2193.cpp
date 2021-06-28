#include <iostream>
using namespace std;

int n;
long long ans;
long long D[95][5];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;

	D[1][1] = 1;
	D[2][0] = 1;

	for (int i = 3; i <= n; i++)
	{
		for (int j = 0; j <= 1; j++)
		{
			if (j == 1) D[i][j] = D[i - 1][j - 1];
			else D[i][j] = D[i - 1][j] + D[i - 1][j + 1];
		}
	}

	ans = D[n][0] + D[n][1];

	cout << ans;
}
