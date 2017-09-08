package 招银;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjxx9 on 2017/5/8.
 */

public class Zhaoying_2 {

    /**
     * <Description>
     *
     * @since Apr 25, 2016
     * @param args <Description>
     *
     */
    public static void main(String[] args) {

        //输入打分数组、评委数M、取N名评委
        M = 5; N = 2;
        scores = new double[] {1.9, 2.62, 3.04, 4.1, 5.0};
        zuhe = new double[N];
        //从M中取N时，所有组合
        comb(M, N);
        showZuhe();
        //从组合中找到方差最小的
        //1. 计算方差，比较
        double[] resArr = new double[N];
        double Fangcha = -1;
        StringBuilder sbFang = new StringBuilder(); //////////////////
        for (int i = 0; i < Cmn.size(); i++) {
            CandScores tmp = (CandScores)Cmn.get(i);
            double[] tmpZuhe = tmp.scores;
            double tmpFangcha = vari(tmpZuhe);
            sbFang.append(tmpFangcha + ","); /////////////////
            if (tmpFangcha < Fangcha) {
                Fangcha = tmpFangcha;
                resArr = tmpZuhe;
            }
        }

        StringBuilder sbRes = new StringBuilder();
        for (int i = 0; i < resArr.length; i++) {
            sbRes.append(resArr[i] + ",");
        }
        System.out.println("最终打分：" + sbRes.toString());


        //2. 计算分数
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += resArr[i];
        }
        double finalScore = sum / N;

        System.out.println("最终得分:" + finalScore);
    }

    //取所有组合
    public static void comb(int n, int m) {
        if (m == 0) {
            CandScores tmp = new CandScores(zuhe);
            Cmn.add(tmp);
            return;
        } else {
            for(int j = n-1; j >= 0; --j) {
                zuhe[m-1] = scores[j];
                comb(n-1, m-1);
            }
        }
    }
    //计算方差
    public static double vari(double[] score){
        double sum = 0.00, ave = 0.00 , vari = 0.00;
        for(int i = 0; i < score.length; i ++) {
            sum += score[i];
        }
        ave = sum / score.length;
        for(int i = 0; i < score.length; i ++) {
            vari += (ave - score[i]) * (ave - score[i]);
        }
        vari = vari / score.length;
        return vari;
    }

    //打印Cmn
    public static void showZuhe() {
        for (int i = 0; i < Cmn.size(); i++) {
            CandScores tmp = (CandScores)Cmn.get(i);
            double[] tmpZuhe = tmp.scores;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < tmpZuhe.length; j++) {
                sb.append(tmpZuhe[j] + ",");
            }
            System.out.println(sb.toString());
        }
    }

    public static int M = 0; //评委数
    public static int N = 0; //几名评委

    public static double[] scores; //M评委打分数组，已知
    public static double[] zuhe;   //其中N名评委的打分数组
    public static List Cmn = new ArrayList(); //Cmn，从M中取N名评委时，打分组合
}

class CandScores {
    public double[] scores;
    public CandScores(double[] avlScores) {
        scores = new double[avlScores.length];
        for (int i = 0; i < avlScores.length; i++) {
            scores[i] = avlScores[i];
        }
    }
}