#include <iostream>
#include <algorithm>
using namespace std;

int n;
int D[1005];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;
	D[1] = 1;
	D[2] = 2;

	for (int i = 3; i <= n; i++)
	{
		D[i] = (D[i - 1] + D[i - 2]) % 10007;
	}

	cout << D[n];
}
