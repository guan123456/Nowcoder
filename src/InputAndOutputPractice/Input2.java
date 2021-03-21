package InputAndOutputPractice;

import java.util.*;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 26, 2021 6:16:32 PM
*/
public class Input2 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//方法一
		//如果int n = scanner.nextInt();会出错
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < n; i++){
            String str = scanner.nextLine();
            String[] strArray = str.split(" ");
            System.out.println(Integer.parseInt(strArray[0]) + Integer.parseInt(strArray[1]));
        }
/*        //方法二
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int sum = a + b;
            System.out.println(sum);
        }*/
	}

}
