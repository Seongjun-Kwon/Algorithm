#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio();
	cin.tie();

	int n, x, num = 0;
	cin >> n;
	vector <int> a(n);
	int i = 0, j = n - 1;

	for (int i = 0; i < n; i++) cin >> a[i];
	cin >> x;

	sort(a.begin(), a.end());
	while (i < j)
	{
		int sum = a[i] + a[j];
		if (sum == x)
		{
			i++;
			j--;
			num++;
		}
		if (sum < x)
			i++;
		if (sum > x)
			j--;
	}

	cout << num;
	return 0;
}
