#include <iostream>
#include <algorithm>
using namespace std;

int n;
int a[1005];
int D[1005];
int mx;

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;
	for (int i = 1; i <= n; i++) cin >> a[i];

	for (int i = 1; i <= n; i++)
	{
		D[i] = a[i];

		for (int j = 1; j < i; j++)
		{
			if (a[i] > a[j])
				D[i] = max(D[j] + a[i], D[i]);
		}
	}

	for (int i = 1; i <= n; i++) mx = max(mx, D[i]);

	cout << mx;
}
