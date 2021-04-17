#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	while (1)
	{
		string a;
		getline(cin, a);
		
		if (a == ".") break;

		stack <char> s;
		bool isYes = true;

		for (auto c : a)
		{
			if (c == '(' || c == '[')
			{
				s.push(c);
			}
			
			else if (c == ')')
			{
				if (s.empty() || s.top() != '(')
				{
					isYes = false;
					break;
				}
				s.pop();
			}

			else if (c == ']')
			{
				if (s.empty() || s.top() != '[')
				{
					isYes = false;
					break;
				}
				s.pop();
			}
		}
		if (!s.empty()) isYes = false;
		if (isYes) cout << "yes\n";
		else cout << "no\n";
	}
}
