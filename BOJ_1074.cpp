#include <iostream>
using namespace std;

int func(int N, int r, int c)
{
	if (N == 0) return 0;
	int half = 1 << (N - 1);
	if (r < half && c < half) return func(N-1, r, c);
	if (r < half && c >= half) return half * half + func(N-1, r, c-half);
	if (r >= half && c < half) return 2 * half * half + func(N-1, r-half, c);
	return 3 * half * half + func(N-1, r-half, c-half);
}

int main()
{
	ios::sync_with_stdio();
	cin.tie();

	int N, r, c;
	cin >> N >> r >> c;
	cout << func(N, r, c);

	return 0;
}
