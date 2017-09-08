package 携程;

import java.util.Scanner;

public class XieC_Chengji {
    private static int maxNum(int k){
        if(k==1) return 1;
        int sum=0;
        int left=0;
        int maxNum=1;
        int cnt=0;
        int[] ans = new int[200];
        for(int i=2;i<=k;i++)
        {
            ans[cnt++]=i;
            sum+=i;
            if(sum>k)
            {
                sum-=i;
                cnt--;
                left=k-sum;
                break;
            }
        }
        for(int i=cnt-1;i>left;i--) {
            ans[i]++;
            i--;
            if(i<0) i=cnt-1;
        }
        for(int i=0;i<cnt;i++) {

            maxNum=maxNum*ans[i];
        }
        return maxNum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str= scan.nextLine();
        int k = Integer.valueOf(str);
        int ans=maxNum(k);
        System.out.println(ans);
    }
}
