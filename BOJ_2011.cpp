#include <iostream>
#include <algorithm>
using namespace std;

string code;
int D[5005];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> code;

	D[0] = 1;
	D[1] = 1;

	if (code[0] == '0')
	{
		cout << 0;
		return 0;
	}

	for (int i = 2; i <= code.size(); i++)
	{
		if (code[i - 1] == '0' && code[i - 2] == '0')
		{
			cout << 0;
			return 0;
		}
		
		if (code[i - 2] >= '3' && code[i - 1] == '0')
		{
			cout << 0;
			return 0;
		}

		int num1 = code[i - 1] - '0';
		int num10 = (code[i - 2] - '0') * 10 + code[i - 1] - '0';

		if (num1 != 0) D[i] += (D[i - 1]) % 1000000;
		if (num10 >= 10 && num10 <= 26) D[i] += (D[i - 2]) % 1000000;
	}
	
	cout << D[code.size()] % 1000000;
}
