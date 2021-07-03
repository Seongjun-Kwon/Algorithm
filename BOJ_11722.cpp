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
		D[i] = 1;

		for (int j = 1; j < i; j++)
		{
			if (a[i] < a[j] && D[j] >= D[i])
				D[i] = D[j] + 1;
		}
		mx = max(mx, D[i]);
	}

	cout << mx;
}
