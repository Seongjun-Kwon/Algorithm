#include <iostream>
#include <list>
#include <cstring>
using namespace std;

int main()
{
	ios::sync_with_stdio();
	cin.tie();

	int num;
	cin >> num;

	while (num--)
	{
		string word;
		cin >> word;
		list <char> key;
		auto cursor = key.begin();
		
		for (int i = 0; i < word.length(); i++)
		{
			if (word[i] == '-')
			{
				if (cursor != key.begin())
				{
					cursor--;
					cursor = key.erase(cursor);
				}
			}

			else if (word[i] == '<')
			{
				if (cursor != key.begin()) cursor--;
			}

			else if (word[i] == '>')
			{
				if (cursor != key.end()) cursor++;
			}

			else
			{
				cursor = key.insert(cursor, word[i]);
				cursor++;
			}
		}

		for (cursor = key.begin(); cursor != key.end(); cursor++) cout << *cursor;
		cout << '\n';
	}
}
