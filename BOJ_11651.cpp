#include <iostream>
#include <algorithm>
#include <utility>
using namespace std;

int n;
pair<int, int> arr[100005];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	
	cin >> n;

	for (int i = 0; i < n; i++)
		cin >> arr[i].second >> arr[i].first;

	sort(arr, arr + n);

	for (int i = 0; i < n; i++)
		cout << arr[i].second << ' ' << arr[i].first << '\n';
}
