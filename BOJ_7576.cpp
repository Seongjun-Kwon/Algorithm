#include <iostream>
#include <queue>
#include <utility>
#include <algorithm>
using namespace std;

int n, m;
int board[1005][1005];
int dis[1005][1005];
int dx[4] = { -1,0,1,0 };
int dy[4] = { 0,-1,0,1 };

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	queue <pair<int, int>> q;
	cin >> m >> n;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> board[i][j];
			if (board[i][j] == 1) q.push({ i,j });
			if (board[i][j] == 0) dis[i][j] = -1;
		}
	}

	while (!q.empty())
	{
		auto cur = q.front();
		q.pop();
		for (int dir = 0; dir < 4; dir++)
		{
			int nx = cur.first + dx[dir];
			int ny = cur.second + dy[dir];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
			if (dis[nx][ny] >= 0) continue;
			dis[nx][ny] = dis[cur.first][cur.second] + 1;
			q.push({ nx,ny });
		}
	}

	int ans = 0;
	
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (dis[i][j] == -1)
			{
				cout << -1;
				return 0;
			}
			ans = max(ans, dis[i][j]);
		}
	}
	
	cout << ans;
}
