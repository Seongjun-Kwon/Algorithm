#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main()
{
	ios::sync_with_stdio();
	cin.tie();

	stack <char> sta;
	bool isYes = true;
	int result = 0;
	int tmp = 1;
	string str;
	cin >> str;

	for (int i = 0; i < str.size(); i++)
	{
		if (str[i] == '(')
		{
			tmp *= 2;
			sta.push(str[i]);
		}

		else if (str[i] == '[')
		{
			tmp *= 3;
			sta.push(str[i]);
		}

		else if (str[i] == ')' && (sta.empty() || sta.top() != '('))
		{
			isYes = false;
			break;
		}
		
		else if (str[i] == ']' && (sta.empty() || sta.top() != '['))
		{
			isYes = false;
			break;
		}

		else if (str[i] == ')')
		{
			if (str[i - 1] == '(')
				result += tmp;
			sta.pop();
			tmp /= 2;
		}

		else if (str[i] == ']')
		{
			if (str[i - 1] == '[')
				result += tmp;
			sta.pop();
			tmp /= 3;
		}
	}

	if (!isYes || !sta.empty())
		cout << 0 << '\n';
	else
		cout << result << '\n';

	return 0;
}
