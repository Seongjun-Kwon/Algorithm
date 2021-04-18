#include <iostream>
#include <deque>
using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	deque <int> deq;
	int N, M, Left, Right;
	int num, index;
	int result = 0;

	cin >> N >> M; 
	for (int i = 1; i <= N; i++)
	{
		deq.push_back(i);
	}

	for (int i = 0; i < M; i++)
	{
		cin >> num;

		if (deq.front() == num)
			deq.pop_front();
		else
		{
			for (int a = 0; a < deq.size(); a++)
			{
				if (deq[a] == num)
					index = a + 1;
			}

			Right = deq.size() - index + 1;
			Left = index - 1;

			if (Left <= Right)
			{
				while (Left--)
				{
					result++;
					deq.push_back(deq.front());
					deq.pop_front();
				}
				deq.pop_front();
			}
			else
			{
				while (Right--)
				{
					result++;
					deq.push_front(deq.back());
					deq.pop_back();
				}
				deq.pop_front();
			}
		}
	}
	cout << result << "\n";
}
