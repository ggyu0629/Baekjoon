#include <iostream>
using namespace std;

int dp[500][500];
int res;

int main() {

	int n;

	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < i+1; j++) {
			cin >> dp[i][j];
		}
	}

	for (int j = 1; j < n; j++) {
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				dp[j][i] += dp[j - 1][i];
			}
			else {
				dp[j][i] = max(dp[j - 1][i] + dp[j][i], dp[j - 1][i - 1] + dp[j][i]);
			}
		}
	}

	for (int i = 0; i < n; i++) {
		res = max(res, dp[n-1][i]);
	}

	cout << res;
	return 0;
}