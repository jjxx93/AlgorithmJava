import java.util.Scanner;

public class Sohu2 {
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int[] nums = new int[7];
        while(sc.hasNextLine()){
            int sum =0 ;
            for(int i=1;i<7;i++){
                nums[i]=sc.nextInt();
                sum += nums[i];
            }
            if(sum>0)
                System.out.println(min_Box(nums));
            else
                break;
        }

    }

    public static int min_Box(int[] nums){
        int sum=0;
        sum=nums[3]/4+nums[4]+nums[5]+nums[6];
        int num_1=Math.max(0,nums[1]-11*nums[5]);
        int num_2=Math.max(0,nums[2]-5*nums[4]);
        if(num_2==0)
            num_1=Math.max(0,num_1-4*(5*nums[4]-nums[2]));
        int num_3=nums[3]%4;
        int temp=0;
        switch(num_3){
            case 0:
                break;
            case 1:
                sum +=1;
                temp=num_2;
                num_2=Math.max(0,num_2-5);
                temp=Math.min(temp,5);
                num_1=Math.max(0,num_1-(36-9-temp*4));
                break;
            case 2:
                sum +=1;
                num_2=Math.max(0,num_2-3);
                temp=Math.min(temp,3);
                num_1=Math.max(0,num_1-(36-18-temp*4));
                break;
            case 3:
                sum +=1;
                num_2=Math.max(0,num_2-1);
                temp=Math.min(temp,1);
                num_1=Math.max(0,num_1-(36-27-temp*4));
                break;
        }
        sum += Math.ceil((num_2*4+num_1)/36);
        return sum;
    }
}