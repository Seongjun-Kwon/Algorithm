#include <iostream>
#include <algorithm>
using namespace std;

int n;
int D[100005];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;
	for (int i = 1; i <= n; i++) D[i] = i;
	
	for (int i = 4; i <= n; i++)
	{
		for (int j = 1; j * j <= i; j++)
		{
			D[i] = min(D[i], D[i - j * j] + 1);
		}
	}
	
	cout << D[n];
}
