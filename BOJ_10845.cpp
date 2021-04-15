#include <iostream>
#include <string>
using namespace std;

class Queue
{
private:
	int arr[10000];
	int head = 0, tail = 0;

public:
	void push(int x)
	{
		arr[tail++] = x;
	}

	int pop()
	{
		if (head == tail) return -1;
		return arr[head++];
	}

	int size()
	{
		return (tail - head);
	}

	int empty()
	{
		if (head == tail) return 1;
		else return 0;
	}

	int front()
	{
		if (head == tail) return -1;
		return arr[head];
	}

	int back()
	{
		if (head == tail) return -1;
		return arr[tail - 1];
	}
};

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	Queue q;
	string str;
	int n, num;

	cin >> n;

	while (n--)
	{
		cin >> str;
		if (str == "push")
		{
			cin >> num;
			q.push(num);
		}
		else if (str == "pop")
			cout << q.pop() << "\n";
		else if (str == "size")
			cout << q.size() << "\n";
		else if (str == "empty")
			cout << q.empty() << "\n";
		else if (str == "front")
			cout << q.front()<<"\n";
		else if (str == "back")
			cout << q.back() << "\n";
	}
	return 0;
}
