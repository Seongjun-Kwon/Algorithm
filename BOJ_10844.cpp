#include <iostream>
using namespace std;

int n;
int D[105][13];
long long ans;

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;
	for (int i = 1; i <= 9; i++) D[1][i] = 1;

	for (int i = 2; i <= n; i++)
	{
		for (int j = 0; j <= 9; j++)
		{
			if (j == 0) D[i][j] = D[i - 1][j + 1];
			else if (j == 9) D[i][j] = D[i - 1][j - 1];
			else D[i][j] = (D[i - 1][j + 1] + D[i - 1][j - 1]) % 1000000000;
		}
	}
	
	for (int i = 0; i <= 9; i++)
		ans += D[n][i];

	cout << ans % 1000000000;
}
