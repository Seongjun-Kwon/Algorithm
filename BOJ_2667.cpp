#include <iostream>
#include <stack>
#include <algorithm>
#include <utility>
#include <vector>
using namespace std;

string board[27];
bool vis[27][27];
int dx[4] = { -1,0,1,0 };
int dy[4] = { 0,-1,0,1 };

int main()
{
	ios::sync_with_stdio();
	cin.tie();
	int n;
	cin >> n;

	for (int i = 0; i < n; i++)
		cin >> board[i];

	int num = 0;
	stack <pair<int, int>> st;
	vector <int> v;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (board[i][j] != '1' || vis[i][j]==1) continue;
			num++;
			int area = 0;
			vis[i][j] = 1;
			st.push({ i,j });

			while (!st.empty())
			{
				area++;
				pair <int, int> cur = st.top();
				st.pop();
				for (int dir = 0; dir < 4; dir++)
				{
					int nx = cur.first + dx[dir];
					int ny = cur.second + dy[dir];

					if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
					if (board[nx][ny] != '1' || vis[nx][ny] == 1) continue;
					vis[nx][ny] = 1;
					st.push({ nx,ny });
				}
			}
			v.push_back(area);
		}
	}
	sort(v.begin(), v.end());

	cout << num <<'\n';
	for (int i = 0; i < v.size(); i++) cout << v[i] << '\n';
}
