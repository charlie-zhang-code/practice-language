#include <iostream>  // 包含标准输入输出库，用于使用cin和cout进行输入输出操作。
#include <algorithm> // 包含算法库，用于使用reverse函数进行字符串反转操作。

using namespace std; // 使用标准命名空间，避免每次调用标准库函数时都要加std::前缀。

int main() { // 主函数，程序的入口点。
    int n; // 定义一个整数变量n，用于存储用户输入的整数。
    string s; // 定义一个字符串变量s，用于存储用户输入的字符串。

    cin >> n; // 从标准输入读取一个整数，并将其存储在变量n中。
    cin >> s; // 从标准输入读取一个字符串，并将其存储在变量s中。

    int length = s.size();

    reverse(s.begin(), s.begin() + length - n);
    reverse(s.begin() + length - n, s.end());
    reverse(s.begin(), s.end());

    cout<< s << endl; // 将处理后的字符串s输出到标准输出，并换行。

    return 0;
}