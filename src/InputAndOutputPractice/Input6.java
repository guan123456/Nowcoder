package InputAndOutputPractice;

import java.util.*;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 26, 2021 6:16:32 PM
*/
public class Input6 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            int n = scan.nextInt();
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += scan.nextInt();
             }
            System.out.println(sum);
       }
  }

}
