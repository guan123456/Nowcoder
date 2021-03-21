package HJ23_plus_practice;
import java.util.*;

/**
* @author 作者:guan
* @createDate 创建时间：Feb 27, 2021 2:00:17 PM
*/
public class HJ25 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	//记录序列I个数以及存储序列I的元素
            int numbers_I = scan.nextInt();
            int[] array_I = new int[numbers_I];
            for(int i = 0; i < numbers_I; i++){
                array_I[i] = scan.nextInt();
            }
        	//记录序列R个数以及存储序列R的元素
            int numbers_R = scan.nextInt();
            int[] array_R = new int[numbers_R];
            for(int i = 0; i < numbers_R; i++){
                array_R[i] = scan.nextInt();
            }
            //对序列R排序
            Arrays.sort(array_R);
            //存储总的输出组，方便最后统一输出
            ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
            //记录输出总数，也就是输出的第一个数
            int count = 0;
            //标记序列R中元素在序列I中出现的次数
            int[] count_R = new int[numbers_R];
            //记录序列R元素是否在序列I中出现，也是方便输出
            boolean[] judge_R = new boolean[numbers_R];
            //依次判断序列R中元素是否在I序列中出现，并动态记录相应信息
            for(int i = 0; i < numbers_R; i++) {
            	//辅助记录序列R中某元素在序列I中出现次数，方便输出
                int countR=0;
                //如果R中出现重复，只判断第一个元素，后面重复的略过
            	if(i - 1 >= 0 && array_R[i] == array_R[i-1]) {
            		continue;
            	}else {
            		//用来存储当前序列R元素在I中出现的坐标，方便输出
                    ArrayList<Integer> list_store_index_I = new ArrayList<Integer>();
                    for(int j = 0; j < numbers_I; j++) {
                    	//不能直接array_I[i].toString(),因为int是基本类型
                    	//但可以用以下方式
                    	String s =Integer.toString(array_I[j]);
                    	if(s.contains(Integer.toString(array_R[i]))){
                    		//这一步可能重复赋值了，但无伤大雅
                    		judge_R[i] = true;
                    		//记录在序列I中出现下标
                    		list_store_index_I.add(j);
                    		//因为输出是 下标+元素，故+2
                    		count += 2;
                    		//只统计序列R中某元素在序列I中出现次数，故只用++
                    		countR++;
                    	}
                    }
                    if(!list_store_index_I.isEmpty()) {
                    	list.add(list_store_index_I);
                    	//这里不是count++，也应该是count+=2，因为是原数+个数
                    	count += 2;
                    	//标记序列R中某元素在序列I中出现的次数
                    	count_R[i] = countR;
                    }
            	}
            }
            //如果无满足条件I，则输出0即可
            if(list.isEmpty()) {
            	System.out.print(0);
            }else{
            	System.out.print(count + " ");
            	int printlist_index = 0;
            	for(int i = 0; i < numbers_R; i++) {
            		if(judge_R[i] == true) {
            			System.out.print(array_R[i] + " " + count_R[i] + " ");
            			ArrayList<Integer> outlist = new ArrayList<Integer>();
            			outlist = list.get(printlist_index);
                			for(int j = 0; j < outlist.size(); j++) {
                				System.out.print(outlist.get(j) + " " + array_I[outlist.get(j)]+" ");
                			}
            			printlist_index++;
            		}
            	}
            }
            //换行，因为有可能有多组输入
            System.out.println();
        }

    }

}
