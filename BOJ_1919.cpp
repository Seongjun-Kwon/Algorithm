#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	int arr1[26] = {};
	int arr2[26] = {};
	int result = 0;
	string word1, word2;
	cin >> word1 >> word2;

	for (int i = 0; i < word1.length(); i++)
	{
		arr1[word1[i] - 'a']++;
	}

	for (int i = 0; i < word2.length(); i++)
	{
		arr2[word2[i] - 'a']++;
	}

	for (int i = 0; i < 26; i++)
	{
		result += max(arr1[i], arr2[i]) - min(arr1[i], arr2[i]);
	}

	cout << result;
	return 0;
}
