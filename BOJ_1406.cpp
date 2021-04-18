#include <iostream>
#include <cstring>
#include <list>
using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	string word;
	int n;
	cin >> word;
	cin >> n;

	list<char> editor;
	for (auto i : word) editor.push_back(i);
	auto cursor = editor.end();

	while (n--)
	{
		char com;
		cin >> com;

		if (com=='L')
		{
			if (cursor != editor.begin()) { cursor--; }
		}

		else if (com == 'D')
		{
			if (cursor != editor.end()) { cursor++; }
		}

		else if (com == 'B')
		{
			if (cursor != editor.begin())
			{
				cursor--;
				cursor=editor.erase(cursor);
			}
		}
		else //'P'
		{
			char x;
			cin >> x;
			editor.insert(cursor, x);
		}
	}

	for (auto i:editor)
	{
		cout << i;
	}

	return 0;
}
