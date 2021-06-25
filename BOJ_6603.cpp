#include <iostream>
#include <vector>
using namespace std;

int k;
vector <int> s;
vector <int> l;

void func(int idx)
{
	if (s.size() == 6)
	{
		for (int i = 0; i < 6; i++)
			cout << s[i] << ' ';

		cout << '\n';
		return;
	}

	for (int i = idx; i < k; i++)
	{
		s.push_back(l[i]);
		func(i + 1);
		s.pop_back();
	}
}

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	while (cin >> k && k != 0)
	{
		l = vector <int>(k);
		for (int i = 0; i < k; i++) cin >> l[i];
		func(0);
		cout << '\n';
	}
}
