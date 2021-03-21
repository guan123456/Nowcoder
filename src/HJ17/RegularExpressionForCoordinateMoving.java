package HJ17;

import java.util.*;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 25, 2021 12:38:48 PM
*/
public class RegularExpressionForCoordinateMoving {

	//
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            //利用String中的split方法将字符串划分为数组
            String[] A = str.split(";");
            int x = 0;
            int y = 0;
            //用迭代器遍历字符串数组
            for(String string : A){
                //用charAt(0)判断数组第一位对应的操作
                //用substring切掉前面的一位后判断后面位是否都是数组
            	//[]代表匹配中括号中其中任一个字符，如[abc]匹配a或b或c。
            	//[a-zA-Z]匹配大小写共52个字母中任一个；[0-9]匹配十个数字中任一个。
            	//^在中括号里面和外面含义不同，如在外时，就表示开头
            	//如^7[0-9]表示匹配开头是7的，且第二位是任一数字的字符串；
            	//如果在中括号里面，表示除了这个字符之外的任意字符(包括数字，特殊字符)，如[^abc]表示匹配除去abc之外的其他任一字符。
            	// {n}表示出现n次,{n,m}表示出现n~m次,{n,}表示出现n次或n次以上
            	//匹配3个到5个字母，大小写不限，包括3和5个, "[a-zA-Z]{3,5}"
            	//一个数字是1，第二个数字是2,3,7,8中任一个，后面9位数字中不包含4,"1[2378][0-35-9]{9}"
            	//切割，根据大写字母切割字符串,String regex = "[A-Z]",String[] arr = str.split(regex)
            	//X|Y表示X或Y,
            	//+表示出现1次或多次,
                //用正则表达式matches.("[0-9]+")
                if(string.charAt(0) == 'D' && string.substring(1).matches("[0-9]+")){
                    //Integer.parseInt(String)
                    //就是将String字符串类型数据转换为Integer整型数据
                    x += Integer.parseInt(string.substring(1));
                }
                if(string.charAt(0) == 'W' && string.substring(1).matches("[0-9]+")){
                    y += Integer.parseInt(string.substring(1));
                }
                if(string.charAt(0) == 'S' && string.substring(1).matches("[0-9]+")){
                    y -= Integer.parseInt(string.substring(1));
                }
                if(string.charAt(0) == 'A' && string.substring(1).matches("[0-9]+")){
                    x -= Integer.parseInt(string.substring(1));
                }
            }
            System.out.println(x+","+y);
        }
    }

}
