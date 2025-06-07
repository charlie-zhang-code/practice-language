#include <iostream>
#include <vector>
#include <climits> // 用于 INT_MAX

using namespace std;

int main() {
    int m = 0, n = 0;
    cin >> m >> n; // 输入行数和列数

    vector<vector<int> > matrix(m, vector<int>(n));

    int sum = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            cin >> matrix[i][j];
            sum += matrix[i][j]; // 计算矩阵的和
        }
    }

    int result = INT_MAX;

    int rowCount = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            rowCount += matrix[i][j]; // 计算每一行的和

            // 如果当前的j是最后一行，则计算每一行的和
            if (j == n - 1) {
                // 所有元素的总和是 sum
                // 现在我们要将矩阵划分为两个子区域
                // 假设其中一个子区域的和是 rowCount
                // 那么另一个子区域的和就是 sum−rowCount
                // 所以，我们需要找到一个分割点，使得两个子区域的和之差最小
                // 计算这两个子区域的和的差值 (sum−2*rowCount)
                // 差值就是 ∣rowCount−(sum−rowCount)∣
                result = min(result, abs(sum - 2 * rowCount));
            }
        }
    }

    int columnCount = 0;
    for (int j = 0; j < n; j++) {
        for (int i = 0; i < m; i++) {
            columnCount += matrix[i][j]; // 计算每一列的和

            // 如果当前的i是最后一列，则计算每一列的和
            if (i == m - 1) {
                result = min(result, abs(sum - 2 * columnCount));
            }
        }
    }

    cout << result << endl;

    return 0;
}
