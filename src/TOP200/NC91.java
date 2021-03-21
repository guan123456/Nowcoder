package TOP200;

import java.util.*;


/**
* @author 作者:guan
* @createDate 创建时间：Mar 10, 2021 3:13:29 PM
*/
public class NC91 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	//如果求最长上升子序列长度，早就做出来了，但是还要求字典序最小，就有些难度
	//所以以下方式是计算最长上升子序列长度，要求字典序最小还需换种思路
	//以下方式其实还是有缺陷的
	//比如10,1,6,3,4,5,7,8,9这里以下算法只计算得到最长为6，但其实最长为7
	public int LIS(int[] arr) {
		int maxLen=1;
		for(int i = 0; i < arr.length; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			int temp = arr[i];
			list.add(arr[i]);
			for(int j = i + 1; j < arr.length; j++) {
				if(temp <= arr[j]) {
					temp = arr[j];
					list.add(arr[j]);
				}
			}
			if(list.size() > maxLen) {
				maxLen = list.size();
			}
		}
		return maxLen;
	}

	//真正考试不会用这么麻烦又低效的解法，不要在浪费时间在这里上
	//下一题了!!!!
/*	public int[] LIS(int[] arr) {
		int maxLen=1;
		int dicTotal;
		int minDicTotal = Integer.MAX_VALUE;
		int index = 0;
		int minIndexOfList=0;
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		//如果有多个答案，就返回其中字典序最小的，这一步怎么做呢?
		//字典序最小，则根据题目意思就是元素和值最小
		for(int i = 0; i < arr.length; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			int temp = arr[i];
			list.add(arr[i]);
			dicTotal=arr[i];
			int count = 0;
			for(int j = i + 1; j < arr.length; j++) {
				if(temp <= arr[j]) {
					temp = arr[j];
					list.add(arr[j]);
					dicTotal+=arr[j];
					count++;
				}
			}
			if(list.size()==maxLen) {
				if(dicTotal < minDicTotal) {
					minDicTotal = dicTotal;
					minIndexOfList=index;
				}
			}
			if(list.size() > maxLen) {
				maxLen = list.size();
			}
			lists.add(list);
			index++;
		}
		ArrayList<Integer> resultList = lists.get(minIndexOfList);
		int[] array = new int[resultList.size()];
		for(int i = 0; i < resultList.size(); i++) {
			array[i] = resultList.get(i);
		}
		return array;
	}
	
	public int getLengh(int min,int max,int start,int[]arr) {
		int length = 0;
		int i =start;
		int temp = arr[i];
		while(i < arr.length - 1) {
			if(arr[i] > max) {
				break;
			}else if(temp < arr[i+1]) {
				length++;
				temp = arr[i+1];
			}
			i++;
		}
		return length;
	}*/

	//别人的解法
    public int[] LIS_1(int[] arr) {
        //特别注意，这道题中使用O(n*2)的算法必超时
        //使用数组来保存index索引位置的元素对应的最长递增子序列的长度，用len表示
        int[] lenAtIndex = new int[arr.length];
        /*
         *使用HashMap保存len对应的最小元素值
         *例如len为3的元素可能有arr[5]，arr[6]，其中arr[5]<arr[6]
         *则在HashMap中只保存arr[5]的值
         */
        HashMap<Integer,Integer> lenAndValue = new HashMap<>();
        int maxLen=0;
        for(int i=0;i<arr.length;i++){
            //表示i位置元素的最长递增子序列中，i元素的前一个元素对应的len
            int preEleLen = 0;
//             //使用嵌套循环的时间复杂度为O(n*2)，必超时
//             for(int j=i-1;j>=0;j--){
//                 //从i开始向前找到小于i中值最小、len最大的元素
//                 if(arr[j]<arr[i] && preEleMaxLen < lenAtIndex[j]){
//                     preEleMaxLen = lenAtIndex[j];
//                     if(j<preEleMaxLen){break;}
//                 }
//             }
            for(int j=maxLen;j>0;j--){
                //找到map里小于i位置元素的值中最大的len，并赋值给preEleLen，
                int e = lenAndValue.get(j);
                if(e<arr[i]){
                    preEleLen = j;
                    //找到就退出，以节省时间
                    break;
                }
            }
            //更新i元素的len
            lenAtIndex[i] = preEleLen + 1;
            //如果i元素的len未在map中，则添加对应的key-value
            if(!lenAndValue.containsKey(lenAtIndex[i])){
                lenAndValue.put(lenAtIndex[i],arr[i]);
            }
            //保证map中len的值是最小的
            if(arr[i]<lenAndValue.get(lenAtIndex[i])){
                lenAndValue.put(lenAtIndex[i],arr[i]);
            }
            //用来找到最大的len，也可在循环外遍历map的key获得
            if(maxLen<lenAtIndex[i]){
                maxLen = lenAtIndex[i];
            }
        }
        /*
         *在lenAtIndex数组中从右向左，依次找到maxLen、maxLen-1、maxLen-2、...
         *第一次出现的位置，并把该索引位置的元素赋值给result数组
         */
        int[] result = new int[maxLen];
        for(int i=lenAtIndex.length-1;i>=0;i--){
            if(lenAtIndex[i] == maxLen){
                result[maxLen-1] = arr[i];
                maxLen = maxLen -1;
            }
        }
        //返回result数组
        return result;
    }
	
}
