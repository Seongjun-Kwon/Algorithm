#include <iostream>
#include <algorithm>
using namespace std;

int n;
int mx;
int a[1005];
int D[1005];

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
			if (a[j] < a[i] && D[j] >= D[i])
				D[i] = D[j] + 1;
		}

	}
	
	for (int i = 1; i <= n; i++)
		mx = max(mx, D[i]);

	cout << mx;
}
