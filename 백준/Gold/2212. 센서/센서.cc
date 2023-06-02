#include <iostream>
#include<vector>
#include<algorithm>
using namespace std;

int arr[10000];
int mul[10000];

int res;

int main() {

	int n, k;

	cin >> n >>k;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	
	sort(arr, arr+n);

	for (int i = 1; i < n; i++) {
		mul[i - 1] = abs(arr[i] - arr[i - 1]);
	}

	sort(mul, mul + (n - 1));

	for (int i = 0; i < n-k; i++) {
		res += mul[i];
	}

	cout << res;

	return 0;
}