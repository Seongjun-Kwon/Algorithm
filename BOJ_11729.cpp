#include <iostream>
using namespace std;

void move(int a, int b, int c)
{
	if (c == 1)
	{
		cout << a << ' ' << b << '\n';
		return;
	}
	move(a, 6 - a - b, c - 1);
	cout << a << ' ' << b << '\n';
	move(6 - a - b, b, c - 1);
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	int k;
	cin >> k;
	cout << (1 << k) - 1 << '\n';
	move(1, 3, k);
}
