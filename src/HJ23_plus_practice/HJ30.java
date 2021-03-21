package HJ23_plus_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 1, 2021 8:34:53 PM
*/
public class HJ30 {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.next();
            str += scan.next();
            System.out.println(processString(str));
        }
	}

	//投机取巧法
	//使用字符串，将转换关系对应如下
	//String st1 = "abcedfABCEDF0123456789";
	//String st2 = "5D37BF5D37BF084C2A6E19";
    private static String processString(String str){
        if(str==null||str.length()==0){
            return "";
        }
        int n = str.length();
        ArrayList<Character> odds = new ArrayList<>();
        ArrayList<Character> evens = new ArrayList<>();
        for(int i=0;i<n;i++){//奇数和偶数分开存到集合中
            if(i%2==0){
                evens.add(str.charAt(i));
            }else{
                odds.add(str.charAt(i));
            }
        }
        //排序
        Collections.sort(odds);
        Collections.sort(evens);
        char[] chs = new char[n];
        int evensIndex = 0,oddsIndex = 0;
        for(int i=0;i<n;i++){//之后再把排序后的奇数偶数重新放到char型数组中
            if((i&1)==0){
                chs[i] = evens.get(evensIndex++);
            }else{
                chs[i] = odds.get(oddsIndex++);
            }
        }
        StringBuffer sb = new StringBuffer();
/*        
        //以下方法投机取巧法
    	String st1 = "abcedfABCEDF0123456789";
    	String st2 = "5D37BF5D37BF084C2A6E19";
        for(int i = 0;i<chs.length;i++){
            if('0'<=chs[i]&&chs[i]<='9'||'A'<=chs[i]&&chs[i]<='F'||'a'<=chs[i]&&chs[i]<='f'){
                for(int j=0;j<st1.length();j++){
                    if(chs[i]==st1.charAt(j)){
                        chs[i]=st2.charAt(j);
                        break ;
                    }
                }
            }
        }
        for(int i = 0;i<str.length();i++){
            sb.append(chs[i]);
        }*/
        //正常方法
        //1.将每一位char[i]转化10进制
        //2.因为存储的是2进制，所以也不用转成2进制，直接通过与位运算反转即可
        //3.转回16进制
        //4.判断是否是字母
        //5.是字母则变成大写，不是字母则直接用数字
        //可以每一次判断char[i]都append，也可以统一处理再赋值
        for(int i = 0; i < n; i++) {
        	char ch = chs[i];
        	if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F')) {
        		//这里可以写成
   /*     		int decimal = TranslateToDecimal(ch);
        		String reverseBinary = reverseBinaryString(decimal);
        		char result = getReverseResult(reverseBinary);
        		sb.append(result);*/
        		sb.append(getReverseResult(reverseBinaryString(TranslateToDecimal(ch))));
        	}else {
        		sb.append(ch);
        	}
        }
        return sb.toString();
    }
    public static int TranslateToDecimal(char c) {
    	int num = 0;
    	if(c >= '0' && c <= '9') {
    		//char c = 'A'+1; 最后c为'B'
    		//int i = 'A' + 1 ; 最后i为 66
    		//char类型可以直接赋值给int
    		//当然num = c + 0;也是可以的
    		num = c;
    	}else if(c >= 'a' && c <='f') {
    		//小写字母的情况，为什么是减87
    		//举个例子十六进制a对应十进制10,ASCII里是97对应10，所以相距了87
    		num = c - 87;
    	}else {
    		//大写字母的情况，为什么是减55
    		//举个例子十六进制A对应十进制10,ASCII里是65对应10，所以相距了55
    		num = c - 55;
    	}
    	return num;
    }
    
    public static String reverseBinaryString(int num) {
    	//int k = 1 << 3;
    	int k = 1;
    	StringBuffer sBuffer = new StringBuffer();
    	int flag;
    	for(int i = 0; i < 4; i++) {
    		flag = ((num & k) == 0 ? 0 : 1);
    		sBuffer.append(flag);
    		k = k << 1;
    	}
    	return sBuffer.toString();
    }
    public static char getReverseResult(String str) {
    	//将二进制字符串转化成十进制数
    	int res = Integer.parseInt(str, 2);
    	if(res >= 0 && res <= 9) {
    		//return (char)res 显示有问题！！！！
    		//以下这种方式才行
    		//return (res+"").charAt(0);
    		return String.valueOf(res).charAt(0);
    	}else {
    		//这里统一转换成大写字母就行，为什么是55
    		//比如10对应的是A，也就是10对应65,ASCII相差了55
    		return (char)(res + 55);
    	}
    }
}
