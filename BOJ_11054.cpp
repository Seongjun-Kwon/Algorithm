#include <iostream>
#include <algorithm>
using namespace std;

int n;
int a[1005];
int Dinc[1005];
int Ddec[1005];
int Dsum[2005];
int ans;

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;
	for (int i = 1; i <= n; i++) cin >> a[i];

	for (int i = 1; i <= n; i++)
	{
		Dinc[i] = 1;
		for (int j = 1; j < i; j++)
		{
			if (a[i] > a[j] && Dinc[j] >= Dinc[i])
				Dinc[i] = Dinc[j] + 1;
		}
	}

	for (int i = n; i >= 1; i--)
	{
		Ddec[i] = 1;
		for (int j = n; j > i; j--)
		{
			if (a[i] > a[j] && Ddec[j] >= Ddec[i])
				Ddec[i] = Ddec[j] + 1;
		}
		Dsum[i] = Dinc[i] + Ddec[i];
		ans = max(ans, Dsum[i]);
	}

	cout << ans - 1;
}
