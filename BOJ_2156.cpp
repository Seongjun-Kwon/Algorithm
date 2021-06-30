#include <iostream>
#include <algorithm>
using namespace std;

int n;
int D[10005];
int arr[10005];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;
	for (int i = 1; i <= n; i++) cin >> arr[i];

	D[1] = arr[1];
	D[2] = arr[1] + arr[2];
	for (int i = 3; i <= n; i++)
	{
		D[i] = max(D[i - 1], D[i - 3] + arr[i - 1] + arr[i]);
		D[i] = max(D[i], D[i - 2] + arr[i]);
	}
	cout << D[n];
}
