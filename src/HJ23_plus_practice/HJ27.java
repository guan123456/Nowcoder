package HJ23_plus_practice;



import java.lang.reflect.Array;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 1, 2021 5:05:55 PM
*/
import java.util.*;

public class HJ27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			int n = scan.nextInt();
			String[] strArray = new String[n];
			for(int i = 0; i < n; i++) {
				strArray[i] = scan.next();
			}
			String string = scan.next();
			int Kth = scan.nextInt();
			Arrays.sort(strArray);
			int count = 0;
			int index = 0;
			for(int i = 0; i < n; i++) {
				//这里还可以加一个判断strArray[i].length() != string.length();
				//但更简单的就是只用一个判断就可以了
				if(strArray[i].length() != string.length() || strArray[i].equals(string)) {
					continue;
				}
				//这个strArray[i].contains函数有问题
				else if(CheckBrother(strArray[i], string)) {
					//temp = i;
					//break;
					//查找的是在字典中兄弟单词的数量，而不是字典排序中第一个！！！
					count++;
					if(count == Kth) {
						index = i;
					}
				}
			}

				System.out.println(count);
				if(count >= Kth) {
					System.out.println(strArray[index]);		
				}
		}

	}
	
	//这方法有毛病
/*	public static String SortSingleWord(String s) {
		char[] chars = new char[s.length()];
		for(int i = 0; i < s.length(); i++) {
			chars[i] = s.charAt(i);
		}
		Arrays.sort(chars);
		return chars.toString();
	}*/
	//借鉴的一个牛逼的判断相等方法
	//!!!!!!
	//!!!!!!
	//!!!!!!
	public static boolean CheckBrother(String str1, String str2) {
		int[] arr = new int[26];
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		for(int i = 0; i < ch1.length; i++) {
			arr[ch1[i] - 'a']++;
			arr[ch2[i] - 'a']--;
		}
		for(int i = 0; i < 26; i++) {
			if(arr[i] != 0) {
				return false;
			}
		}
		return true;
	}

}

//原作者代码
/*import java.util.*;
public class Main{
    public static boolean checkBorther(String str1, String str2){
        int[] arr = new int[26];
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for(int i=0; i<ch1.length; i++){
            arr[ch1[i]-'a']++;
            arr[ch2[i]-'a']--;
        }
        for(int i=0; i<26; i++){
            if(arr[i]!=0)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt(); //输入字典中单词的个数
            String[] str = new String[N];
            for(int i=0; i<N; i++){ //输入n个单词作为字典单词
                str[i]=sc.next();
            }
            // 查找兄弟单词
            String findStr = sc.next();//输入一个待查单词
            int ind = sc.nextInt(); //输入待查单词的 指定序号     
            ArrayList<String> list = new ArrayList<>();
            for(int i=0; i<N; i++){
               if((str[i].length() == findStr.length()) && (!str[i].equals(findStr))){//长度相等 且 字符串不相等
                    if(checkBorther(findStr,str[i])){
                        list.add(str[i]);
                    }
                }
            }
            //输出 
            System.out.println(list.size());     

            Collections.sort(list);
            if(list.size()>=ind){
                System.out.println(list.get(ind-1));  
            }


        }

    }
}*/
