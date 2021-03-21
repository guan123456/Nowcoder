package HJ06;

import java.util.*;

/**
* @author 作者:guan
* @createDate 创建时间：Feb 24, 2021 2:06:56 PM
*/
public class AllPrimerFactors {

	
	//方式一
/*
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        long number = 0;
        while(scan.hasNextLong()){
            number = scan.nextLong();
            isPrimerFactors(number);
        }
    }
    public static void isPrimerFactors(long num){
        long number = num;
        //for里面只嵌套第一个if,然后break之后不是执行下一个for,而是中断for循环
        //也就是直接跳回到while循环判断
        while(number != 1){
            for(int i = 2; i <= number; i++){
                if(number % i == 0){
                    number /= i;
                    System.out.print(i + " ");
                    break;
                }
            }
        }
    }*/
    
    //方式二
/*    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        long data = scan.nextLong();
        for(int i = 2; i < data + 1; i++){
            while(data % i == 0){
                System.out.print(i + " ");
                data = data / i;
            }
        }
    }*/
    
    //方式三
/*    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        long data = scan.nextLong();
        caculate(data);
    }
    public static void caculate(long num){
        for(long i = 2; i <= num; i++){
            if(num % i == 0){
                System.out.print(i + " ");
                caculate(num/i);
                return;
            }
        }
    }*/
    //以上三种方式都超时了
    //改进的方法
    //判断数 data 是不是质数时，没必要从 2 一直尝试到 data
	//大循环也大可不必写一个到 data的循环，写到 Math.sqrt(data)即可
	//如果此时数字还没有除数，则可判定其本身是一个质数，没有再除下去的必要了，直接打印其本身即可
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long data = scanner.nextLong();
		long k = (long)Math.sqrt(data);
		for(long i = 2; i <= k; i++) {
			while(data % i == 0) {
				System.out.print(i + " ");
				data = data / i;
			}
		}
		System.out.print(data == 1 ? "" : data + " ");
	}
}
