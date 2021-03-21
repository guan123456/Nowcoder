package InputAndOutputPractice;

import java.util.*;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 26, 2021 6:16:32 PM
*/
public class Input8 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String pass = scan.nextLine();
        while(scan.hasNextLine()){
            String str = scan.nextLine();
            String[] strArray = str.split(" ");
            Arrays.sort(strArray);
            for(int i = 0; i < strArray.length; i++){
                System.out.print(strArray[i] + " ");
            }
        }
    }
}
