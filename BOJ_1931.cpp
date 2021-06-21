#include <iostream>
#include <utility>
#include <algorithm>
using namespace std;

int N;
int ans = 0;
int t = 0;
pair <int, int> p[100005];

bool compare(const pair<int, int>& p1, const pair<int, int>& p2)
{
	if (p1.second < p2.second) return true;
	else if (p1.second == p2.second) return p1.first <= p2.first;
	else return false;
}

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;
	for (int i = 0; i < N; i++) cin >> p[i].first >> p[i].second;
	sort(p, p + N, compare);

	for (int i = 0; i < N; i++)
	{
		if (t > p[i].first) continue;
		ans++;
		t = p[i].second;
	}

	cout << ans;

	return 0;
}
