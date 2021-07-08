#include <iostream>
#define mod 1000000000
using namespace std;

int n;
int k;
int D[205][205];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n >> k;

	for (int i = 1; i <= k; i++) D[0][i] = 1;

	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= k; j++)
		{
			D[i][j] = (D[i - 1][j] + D[i][j - 1]) % mod;
		}
	}

	cout << D[n][k];
}
