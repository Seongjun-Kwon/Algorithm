#include <iostream>
#include <algorithm>
using namespace std;

int n;
int a[100005];
int D[100005];
int ans = -1001;

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;
	for (int i = 1; i <= n; i++) cin >> a[i];

	for (int i = 1; i <= n; i++)
	{
		D[i] = a[i];
		D[i] = max(D [i], D[i - 1] + a[i]);
		ans = max(ans, D[i]);
	}

	cout << ans;
}
