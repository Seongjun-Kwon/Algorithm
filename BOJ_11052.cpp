#include <iostream>
#include <algorithm>
using namespace std;

int n;
int P[1005];
int D[1005];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> P[i];

	D[1] = P[1];

	for (int i = 2; i <= n; i++)
	{	
		for (int j = 0; j < i; j++)
		{
			D[i] = max(D[i], D[j] + P[i - j]);
		}
	}

	cout << D[n];
}
