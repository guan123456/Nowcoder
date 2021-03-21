package InputAndOutputPractice;

import java.util.*;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 26, 2021 6:16:32 PM
*/
public class Input10 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String str = scan.nextLine();
            String[] strArray = str.split(",");

               Arrays.sort(strArray); 

            for(int i = 0; i < strArray.length - 1; i++){
                System.out.print(strArray[i] + ",");
            }
            System.out.println(strArray[strArray.length - 1]);
        }
    }

}
