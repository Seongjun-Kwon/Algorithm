#include <iostream>
#include <algorithm>
using namespace std;

int num;
int score[305];
int stair[305][3];

int main()
{
	ios::sync_with_stdio();
	cin.tie();

	cin >> num;
	for (int i = 1; i <= num; i++) cin >> score[i];

	if (num == 1)
	{
		cout << score[1];
		return 0;
	}

	stair[1][1] = score[1];
	stair[1][2] = 0;
	stair[2][1] = score[2];
	stair[2][2] = score[1] + score[2];

	for (int i = 3; i <= num; i++)
	{
		stair[i][1] = max(stair[i - 2][1], stair[i - 2][2]) + score[i];
		stair[i][2] = stair[i - 1][1] + score[i];
	}

	cout << max(stair[num][1], stair[num][2]);

	return 0;
}
