package HJ23_plus_practice;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 3, 2021 3:51:10 PM
*/
import java.util.*;
public class HJ39 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //存储三者的整数值
        long[] ip1AfterHex = new long[4];
        long[] ip2AfterHex = new long[4];
        long[] subnetAfterHex = new long[4];
        
        while(sc.hasNext()){
        	//获取三者的数据
            String subnetMask = sc.nextLine();
            String ip1 = sc.nextLine();
            String ip2 = sc.nextLine();
            //划分为字符串数组
/*            if (subnetMask==null || subnetMask.length()==0 
                    || ip1==null || ip1.length()==0 
                    || ip2==null || ip2.length()==0) {
                    System.out.println(1);
                    break;
                }*/
            String[] subnetArray = subnetMask.split("\\.");
            String[] ip1Array = ip1.split("\\.");
            String[] ip2Array = ip2.split("\\.");
            //遍历将字符串数字转换为二进制字符串，然后再转化为整数
            for(int i=0;i<4;i++){
                String xs = Integer.toBinaryString(Integer.parseInt(ip1Array[i]));
                String ys = Integer.toBinaryString(Integer.parseInt(ip2Array[i]));
                String zs = Integer.toBinaryString(Integer.parseInt(subnetArray[i]));
                //这里要标记为2进制，不然会出错
                //因为数组里存的是二进制码，而不是十进制数
                //ip1AfterHex[i]=Integer.parseInt(xs);
                //ip2AfterHex[i]=Integer.parseInt(ys);
                //subnetAfterHex[i]=Integer.parseInt(zs);
                //这里可能出现字符大小大于int的情况，所以改为long比较好
                ip1AfterHex[i]=Long.parseLong(xs,2);
                ip2AfterHex[i]=Long.parseLong(ys,2);
                subnetAfterHex[i]=Long.parseLong(zs,2);
            }
            //判断IP地址或者子网掩码格式是否合法
            if(!isIp(ip1AfterHex)||!isIp(ip2AfterHex)||!isAd(subnetAfterHex)){
            System.out.println(1);
            continue;//回到while循环，判断下一组
            }
        boolean flag=true;
        for(int i=0;i<4;i++){
        	//直接利用相与结果判断是否相等
           if((ip1AfterHex[i]&subnetAfterHex[i])!=(ip2AfterHex[i]&subnetAfterHex[i])){
                System.out.println(2);
                flag=false;
                break;//退出for循环
            }
        }
        if(flag)
            System.out.println(0);
        }
    }
    public static boolean isAd(long[] a){
    return  a[0]>=0&&a[0]<=255&&
            a[1]>=0&&a[1]<=255&&
            a[2]>=0&&a[2]<=255&&
            a[3]>=0&&a[3]<=255&&
            a[0]>=a[1]&&
            a[1]>=a[2]&&
            a[2]>=a[3];
    }

    public static boolean isIp(long[] a){
    return  a[0]>=0&&a[0]<=255&&
            a[1]>=0&&a[1]<=255&&
            a[2]>=0&&a[2]<=255&&
            a[3]>=0&&a[3]<=255;
    }

}
