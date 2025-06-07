import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // sc.next() 只会读取输入的第一个单词
        String s = sc.next();

        // 获取输入字符串的长度
        int strLen = s.length();

        // 遍历字符串中的每一个字符，统计数字字符的数量
        for (int i = 0; i < s.length(); i++) {

            // 检查当前字符是否是数字（ASCII范围 '0' 到 '9'）
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                // 如果是数字，增加len的值，因为每个数字将被替换为"number"（6个字符）
                strLen += 5; // 原字符占1个位置，替换后增加5个位置
            }
        }

        // 创建一个新的字符数组，用于存储替换后的结果
        // 数组的长度为原字符串长度加上所有数字被替换后增加的长度
        char[] stringCharArray = new char[strLen];
        // 将原字符串s中的每个字符依次复制到新数组的前部
        for (int i = 0; i < s.length(); i++) {
            stringCharArray[i] = s.charAt(i);
        }

        // 使用双指针方法，从后往前遍历并替换数字字符
        // i指向原字符串的当前字符，j指向新数组中下一个可写入的位置
        int strOldIndex = s.length() - 1;
        int strNewIndex = strLen - 1;
        while (strOldIndex >= 0) {
            if ('0' <= stringCharArray[strOldIndex] && stringCharArray[strOldIndex] <= '9') {
                stringCharArray[strNewIndex--] = 'r';
                stringCharArray[strNewIndex--] = 'e';
                stringCharArray[strNewIndex--] = 'b';
                stringCharArray[strNewIndex--] = 'm';
                stringCharArray[strNewIndex--] = 'u';
                stringCharArray[strNewIndex--] = 'n';
            } else {
                stringCharArray[strNewIndex--] = stringCharArray[strOldIndex];
            }

            strOldIndex--;
        }

        System.out.println(new String(stringCharArray));
    }
}
