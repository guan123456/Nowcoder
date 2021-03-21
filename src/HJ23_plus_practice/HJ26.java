package HJ23_plus_practice;

import java.util.*;

/**
* @author 作者:guan
* @createDate 创建时间：Feb 27, 2021 4:25:56 PM
*/
public class HJ26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String string = scan.nextLine();
			char[] chars = string.toCharArray();
			//char[] chars_new = new char[chars.length];
			//我原先的思路，新建一个数组，动态加入元素然后再输出
			//首先从字母a遍历到字母z，从头依次加进去，只要将元素中都统一为小写即可比较
			//可以先记录总共有多少个非字母字符
			//加进去之后，然后从尾到头依次挪动元素并把非字母数字添加到合适的位置
			//当然可以先把非字母的元素填进去，然后只要判断当前位置有没有修改过
			//这又可能需要一个boolean辅助数组了
			
			//另一种思路就是，用一个数组保存字母元素，然后利用一个稳定的排序将字母元素排好序
			//然后再添加非字母元素
			
			//下面是使用了比较器
			List<Character> list = new LinkedList<Character>();
			for(char s : chars) {
				//isLetter() 方法用于判断指定字符是否为字母。
				if(Character.isLetter(s)) {
					list.add(s);
				}
			}
			Collections.sort(list,new Comparator<Character>() {
				@Override
				public int compare(Character o1, Character o2) {
					//这种性质不能用Arrays.sort(),因为不是整体按照ASCII排序的
					return Character.toLowerCase(o1) - Character.toLowerCase(o2);
				}
			});
			StringBuffer sBuffer = new StringBuffer();
			int totalLen = 0;
			for(char temp : chars) {
				if(Character.isLetter(temp) && totalLen < list.size()) {
					sBuffer.append(list.get(totalLen));
					totalLen++;
				}else {
					sBuffer.append(temp);
				}
			}
			System.out.println(sBuffer.toString());
		}

	}

}
