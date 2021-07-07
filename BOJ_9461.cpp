#include <iostream>
using namespace std;

int t;
int n;
long long P[105];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> t;
	for (int i = 1; i <= 3; i++) P[i] = 1;
	P[4] = 2;
	P[5] = 2;

	for (int i = 1; i <= t; i++)
	{
		cin >> n;

		for (int j = 6; j <= n; j++)
		{
			P[j] = P[j - 1] + P[j - 5];
		}

		cout << P[n] << '\n';
	}
}
