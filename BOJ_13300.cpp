#include <iostream>
using namespace std;

int arr[2][7];

int main()
{	
	ios::sync_with_stdio(0);
	cin.tie(0);

	int roomNum = 0;
	int stuNum, MaxNum;
	cin >> stuNum >> MaxNum;

	int gender, grade;

	while (stuNum--)
	{
		cin >> gender >> grade;
		arr[gender][grade]++;
	}

	for (int i = 0; i < 2; i++)
	{
		for (int j = 0; j <= 6; j++)
		{
			if (arr[i][j] == 0)
				continue;

			if (arr[i][j] < MaxNum)
			{
				roomNum++;
			}
			else
			{
				if (arr[i][j] % MaxNum == 0) roomNum += arr[i][j] / MaxNum;
				else roomNum+=arr[i][j] / MaxNum + 1;
			}
		}
	}
	cout << roomNum << "\n";
	return 0;
}
