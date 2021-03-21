package HJ23_plus_practice;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 4, 2021 4:26:14 PM
*/
import java.util.*;

public class HJ41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//这里要用hasNext()或者hasNextInt()
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			//这样子没用上n
/*			String weight = scanner.nextLine();
			String count = scanner.nextLine();
			String[] weightArray = weight.split(" ");
			String[] countArray = count.split(" ");*/
			int[] weight = new int[n];
			int[] count = new int[n];
			for(int i = 0; i < n; i++) {
				weight[i] = scanner.nextInt();
			}
			for(int i = 0; i < n; i++) {
				count[i] = scanner.nextInt();
			}
			
			System.out.println(GetTotal(n,weight, count));
 		}
	}
	
	public static int GetTotal(int number, int[] weight, int[] count) {
		HashSet<Integer> set = new HashSet<Integer>();
		//先两组进行合并，再与第三组进行合并，然后再与第四组进行合并
		//或者二分，前一半合并，后一半合并，递归合并
		
		//先存第一个砝码
		//这里需要从i = 0 开始
		for(int i = 0; i <= count[0]; i++) {
			set.add(i * weight[0]);
		}
		//从第二个砝码依次合并
		for(int i = 1; i < number; i++) {
			//使用List存储前一轮合并后的set，以方便比较
			List<Integer> list = new ArrayList<Integer>(set);
			//这里不用从j=0开始了
			for(int j = 1; j <= count[i]; j++) {
				for(int k = 0; k < list.size(); k++) {
					set.add(list.get(k) + j * weight[i]);
				}
			}
		}
		return set.size();
	}

}
