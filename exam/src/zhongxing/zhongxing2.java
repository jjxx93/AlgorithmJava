package zhongxing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zhongxing2 {
    long calculatePower(int numOfKids, int cardDrawn, int[][] studentPair, int[] strength) {
        long max_power = 0;
        for(int i=0;i<numOfKids;i++){
            int power_tmp = strength[i];
            if (power_tmp > max_power) {
                max_power = power_tmp;
            }
        }
        List<int[]> array = new ArrayList<int[]>();
        for (int i = 0; i < cardDrawn; i++) {
            int power_tmp = 0;
            for (int k = 0; k < studentPair[i].length; k++) {
                power_tmp += strength[studentPair[i][k]-1];
            }
            if (power_tmp > max_power) {
                max_power = power_tmp;
            }
            array.add(studentPair[i]);
        }
        for (int i = 0; i < cardDrawn; i++) {
            for (int j = i + 1; j < cardDrawn; j++) {
                int n1 = studentPair[i].length;
                int n2 = studentPair[j].length;
                int[] result = union(studentPair[i], studentPair[j]);
                if (result.length < (n1 + n2)) {
                    array.add(result);
                    int power_tmp=0;
                    for (int aResult : result) {
                        power_tmp += strength[aResult - 1];
                    }
                    if(power_tmp>max_power){
                        max_power=power_tmp;
                    }
                }
            }
        }
        for(int i=0;i<array.size();i++){
            for(int j=i+1;j<array.size();j++){
                int[] n1 = array.get(i);
                int[] n2 = array.get(j);
                int[] result = union(n1,n2);
                if (result.length <(n1.length+n2.length)) {
                    int power_tmp=0;
                    for(int k=0;k<result.length;k++){
                        power_tmp+=strength[result[k]-1];
                    }
                    if(power_tmp>max_power){
                        max_power=power_tmp;
                    }
                }
            }
        }
        return max_power;
    }

    public static int[] union(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<Integer>();
        for (int str : arr1) {
            set.add(str);
        }
        for (int str : arr2) {
            set.add(str);
        }
        int[] result = {};
        result = SetToInt(set);
        return result;
    }

    private static int[] SetToInt(Set<Integer> allSet) {
        Integer[] temp = allSet.toArray(new Integer[]{});

        int[] intArray = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            intArray[i] = temp[i].intValue();
        }
        return intArray;
    }

    public static void main(String[] args) {
//        int numOfKids = 4;
//        int cardDrawn = 3;
//        int[][] studentPair = {{1, 2}, {2, 3}, {3, 1}};
//        int[] strength = {11, 2, 3, 5};
        int numOfKids = 9;
        int cardDrawn = 6;
        int[][] studentPair = {{1, 2}, {2, 3}, {7, 8},{5,6},{7,9},{4,5}};
        int[] strength = {25,34,23,45,16,51,29,38,47};
//        System.out.println(studentPair[0][0]);
        zhongxing2 mSolution = new zhongxing2();
        System.out.println(mSolution.calculatePower(numOfKids, cardDrawn, studentPair, strength));
    }
}