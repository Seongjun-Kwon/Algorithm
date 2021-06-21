#include <iostream>
using namespace std;

int N;
int K;
int A[10];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int ans = 0;
	cin >> N >> K;
	for (int i = 0; i < N; i++) cin >> A[i];
	for (int i = N - 1; i >= 0; i--)
	{
		ans += K / A[i];
		K %= A[i];
	}

	cout << ans;

	return 0;
}
