#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main()
{
	ios::sync_with_stdio();
	cin.tie();

	stack <int> sta;
	vector <int> sol;
	vector <char> com;
	int n, num;
	int index = 0;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> num;
		sol.push_back(num);
	}

	for (int i = 1; i <= n; i++)
	{
		sta.push(i);
		com.push_back('+');

		while (!sta.empty())
		{
			if (sol[index] == sta.top())
			{
				sta.pop();
				com.push_back('-');
				index++;
			}
			else
				break;
		}
	}

	if (sta.empty())
	{
		for (int i = 0; i < com.size(); i++)
			cout << com[i] << '\n';
	}

	else
		cout << "NO" << '\n';

	return 0;
}
