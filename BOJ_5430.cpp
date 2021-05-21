#include <iostream>
#include <string>
#include <deque>
#include <algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio();
	cin.tie();

	int T;
	cin >> T;

	while (T--)
	{
		string com;
		cin >> com;

		int n;
		cin >> n;

		string x;
		cin >> x;

		deque <int> deq;
		string st = "";

		for (int i = 0; i < x.size(); i++)
		{
			if (x[i] == '[') continue;
			else if (x[i] >= '0' && x[i] <= '9')
				st += x[i];
			else if (x[i] == ',' || x[i] == ']')
			{
				if (!st.empty())
				{
					deq.push_back(stoi(st));
					st.clear();
				}
			}
		}

		bool reverse = true;
		bool isempty = false;
		for (int i = 0; i < com.size(); i++)
		{
			if (com[i] == 'R') reverse = !reverse;
			else  // 'D'
			{
				if (!deq.empty())
				{
					if (reverse) deq.pop_front();
					else deq.pop_back();
				}
				else // empty
				{
					isempty = true;
					cout << "error" << '\n';
					break;
				}
			}
		}

		if (!isempty)
		{
			cout << '[';
			if (reverse)
			{
				while (!deq.empty())
				{
					cout << deq.front();
					deq.pop_front();
					if (!deq.empty()) cout << ',';
				}
			}
			else
			{
				while (!deq.empty())
				{
					cout << deq.back();
					deq.pop_back();
					if (!deq.empty()) cout << ',';
				}
			}
			cout << ']' << '\n';
		}
	}
	return 0;
}
