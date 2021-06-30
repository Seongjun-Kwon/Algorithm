#include <iostream>
#include <algorithm>
using namespace std;

int t;
int n;
int D[100005][5];
int score[100005][5];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> t;
	for (int i = 0; i < t; i++)
	{
		cin >> n;
		for (int j = 0; j < 2; j++)
		{
			for (int k = 1; k <= n; k++)
			{
				cin >> score[k][j];
			}
		}

		D[1][0] = score[1][0];
		D[1][1] = score[1][1];

		for (int m = 2; m <= n; m++)
		{
			D[m][0] = max(D[m - 1][1], D[m - 2][1]) + score[m][0];
			D[m][1] = max(D[m - 1][0], D[m - 2][0]) + score[m][1];
		}

		cout << max(D[n][0], D[n][1]) << '\n';
	}
}
