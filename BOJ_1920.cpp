#include <iostream>
#include <algorithm>
using namespace std;

int N;
int M;
int A[100005];

int BinarySearch(int target, int length)
{
	int st = 0;
	int en = length - 1;

	while (st <= en)
	{
		int mid = (st + en) / 2;
		if (A[mid] < target) st = mid + 1;
		else if (A[mid] > target) en = mid - 1;
		else return mid;
	}
	return -1;
}

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;
	for (int i = 0; i < N; i++) cin >> A[i];
	sort(A, A + N);
	cin >> M;
	
	while (M--)
	{
		int target;
		cin >> target;
		
		if (BinarySearch(target, N) == -1) cout << '0' << '\n';
		else cout << '1' << '\n';
	}
}
