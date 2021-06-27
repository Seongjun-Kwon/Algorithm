#include <iostream>
using namespace std;

int t;
int D[15];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> t;

	D[0] = 0;
	D[1] = 1;
	D[2] = 2;
	D[3] = 4;

	for (int i = 0; i < t; i++)
	{
		int n;
		cin >> n;
		for (int i = 4; i < 11; i++)
		{
			D[i] = D[i - 1] + D[i - 2] + D[i - 3];
		}
		cout << D[n] << '\n';
	}
}
