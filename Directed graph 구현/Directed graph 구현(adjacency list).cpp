//No STL version
#include <iostream>
using namespace std;

int edge[10][2];
int deg[10]; // 각 정점의 outdegree
int* adj[10]; // 정점
int idx[10]; // adj[i]에서 새로운 정점을 추가할 때의 위치

int main(void)
{
	int v, e;
	cin >> v >> e;

	for (int i = 0; i < e; i++)
	{
		cin >> edge[i][0] >> edge[i][1];
		deg[edge[i][0]]++;
	}

	for (int i = 1; i <= v; i++)
		adj[i] = new int[deg[i]];

	for (int i = 0; i < e; i++)
	{
		int u = edge[i][0], v = edge[i][1];
		adj[u][idx[u]] = v;
		idx[u]++;
	}
}


/*STL version
#include <iostream>
#include <vector>
using namespace std;

vector<int> adj[10];

int main(void)
{
	int v, e;
	cin >> v >> e;

	for (int i = 0; i < e; i++)
	{
		int u, v;
		cin >> u >> v;

		adj[u].push_back(v);
	}
}
*/

