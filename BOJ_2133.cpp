#include <iostream>
using namespace std;

int n;
int D[35];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;
	D[0] = 1;
	D[2] = 3;
	
	if (n % 2 == 0)
	{
		for (int i = 4; i <= n; i = i + 2)
		{
			D[i] = D[i - 2] * 3;

			for (int j = 4; j <= i; j = j + 2)
			{
				D[i] += D[i - j] * 2;
			}
		}
	}

	cout << D[n];
}
