#include <iostream>
using namespace std;

int n;
long long ans;
int D[1005][15];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;

	for (int i = 0; i <= 9; i++) D[1][i] = 1;

	for (int i = 2; i <= n; i++)
	{
		for (int j = 0; j <= 9; j++)
		{
			for (int k = 0; k <= j; k++)
				D[i][j] += (D[i - 1][k]) % 10007;
		}
	}

	for (int i = 0; i <= 9; i++) ans += (D[n][i]) % 10007;

	cout << ans % 10007;
}
