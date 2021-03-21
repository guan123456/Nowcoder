package InputAndOutputPractice;

import java.util.*;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 26, 2021 6:16:32 PM
*/
public class Input4 {

        public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            int n = scanner.nextInt();
            if(n == 0) {
                break;
            }else {
                int sum = 0;
                for(int i = 0; i < n; i++) {
                    sum += scanner.nextInt();
                }
                System.out.println(sum);
            }
 
        }
    }

}
