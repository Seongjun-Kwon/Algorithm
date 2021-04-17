#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	stack <int> sta;
	string str;
	char c;
	int result = 0;
	cin >> str;

	for (auto a : str)
	{
		if (a == '(')
			sta.push(1);
		else
		{
			sta.pop();
			if (c == '(')
				result += sta.size();
			else
				result++;
		}
		c = a;
	}
	cout << result << "\n";
	return 0;
}
