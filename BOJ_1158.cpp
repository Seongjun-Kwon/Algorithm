#include <iostream>
#include <list>
#include <vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, K;
	vector <int> num;
	cin >> N >> K;
	list <int> lis;
	for (int i = 1; i < N + 1; i++)
	{
		lis.push_back(i);
	}
	list<int>::iterator kill = lis.begin();

	while (N > 0)
	{
		for (int i = 0; i < K - 1; i++)
		{
			if (kill == lis.end()) kill = lis.begin();
			kill++;
			if (kill == lis.end()) kill = lis.begin();
		}
		num.push_back(*kill);
		kill = lis.erase(kill);
		N--;
	}
	cout << '<';
	for (int i = 0; i < num.size()-1; i++)
		cout << num[i] << ", ";
	cout << num[num.size() - 1] << '>';
}
