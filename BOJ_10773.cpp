#include <iostream>
#include <stack>
using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	int K, N;
	int sum = 0;
	cin >> K;
	stack <int> sta;
	
	for (int i = 0; i < K; i++)
	{
		cin >> N;
		if (N != 0)
		{
			sta.push(N);
			sum += sta.top();
		}
		else
		{
			sum -= sta.top();
			sta.pop();
		}
	}
	cout << sum;
}
