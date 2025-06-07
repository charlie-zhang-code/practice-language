#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n; // 输入数组长度
    cin >> n; // 输入原始数组的长度

    vector<int> vec(n); // 原始数组
    vector<int> p(n); // 区间和数组

    int sum = 0;

    // 遍历输入数组，并处理区间和
    for (int i = 0; i < n; i++) {
        cin >> vec[i];
        sum += vec[i];
        p[i] = sum;
    }

    // 获取最大区间和
    int a, b;
    while (cin >> a >> b) {
        int result = 0;

        // 如果a等于0，说明是从第一个元素开始，直到b结束
        if (a == 0) {
            result = p[b];
        } else {
            result = p[b] - p[a - 1];
        }

        cout << result << endl;
    }

    return 0;
}
