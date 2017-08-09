package Toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jjxx9 on 2017/3/30.
 */
public class Toutiao_3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] NM = scanner.nextLine().split(" ");
        int N = Integer.valueOf(NM[0]);
        int M = Integer.valueOf(NM[1]);

        //N句话
        List<String[]> NList = new ArrayList();
        for (int i = 0; i < N; i++) {
            String[] temp = scanner.nextLine().split(" ");
            NList.add(temp);
        }

        //M查询句子
        List<String[]> MList = new ArrayList();
        for (int i = 0; i <M; i++) {
            String[] temp = scanner.nextLine().split(" ");
            MList.add(temp);
        }



        for (int i = 0; i < M; i++) { //M个查询语句

            int Mlength = MList.get(i).length;



            int NmaxCount = 0;
            int num = 0;
            for (int j = 0; j < N; j++) {  //N句话

                int Ncount = 0;
                int Nlength =  NList.get(j).length;
                for (int k = 0; k < Mlength; k++) { //M一句话包含单词数

                    for (int l = 0; l < Nlength; l++) {  //N一句话包含单词数
                        if (MList.get(i)[k].equals(NList.get(j)[l])) {
                            Ncount++;
                        }
                    }
                }

                if (Ncount>NmaxCount){
                    NmaxCount = Ncount;
                    num = j;
                }


            }

            String[] resultArray = NList.get(num);
            String result = "";
            for (int j = 0; j < resultArray.length; j++) {
                if (j == resultArray.length - 1) {
                    result += resultArray[j];
                } else {
                    result += resultArray[j] + " ";
                }
            }
            System.out.println(result);

        }

    }
}