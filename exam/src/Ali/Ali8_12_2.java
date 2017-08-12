package Ali;

import java.util.Scanner;
/**
 * Created by xiongjiaxin on 2017/8/12.
 *
4
2
3
0
3
 */
public class Ali8_12_2 {
    static int maxScore(int[] score) {
//        if (score == null || score.length == 0) {
//            return 0;
//        }
//        if (score.length == 1) {
//            return score[0];
//        }
//
//        int max = 0, shotIndex = 0;
//        for (int i = 0; i < score.length; i++) {
//            if (score[i] != 0) {
//                int left = 1;
//                if (i > 0 && score[i-1] != 0) {
//                    left = score[i - 1];
//                }
//                int right = 1;
//                if (i+1 < score.length && score[i+1] != 0) {
//                    right = score[i + 1];
//                }
//
//                int temp = left * right * score[i];
//                if (temp > max) {
//                    shotIndex = i;
//                    max = temp;
//                }
//            }
//        }
//
//        int[] newScore = new int[score.length - 1];
//        for (int i = 0, j = 0; i < score.length; i++) {
//            if (i != shotIndex) {
//                newScore[j++] = score[i];
//            }
//        }
//
//        return max + maxScore(newScore);

        int total = 0;
        if (score.length <= 1) {
            //数组长度为0的时候 & 不存在左边和右边的时候
            return total;  }
        for (int i = 0; i < score.length; i++) {
            if (score[i] == 0) {
                //分数为0的时候
                continue;
            } else {
                if (i == 0) { //左边不存在的时候
                    total += score[i] * score[i + 1];
                } else if (i == score.length - 1) {
                    //右边不存在的时候
                    total += score[i] * score[0];
                } else {
                    total += score[i - 1] * score[i] * score[i + 1];
                }
            }
        }

        return total;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _score_size = 0;
        _score_size = Integer.parseInt(in.nextLine().trim());
        int[] _score = new int[_score_size];
        int _score_item;
        for(int _score_i = 0; _score_i < _score_size; _score_i++) {
            _score_item = Integer.parseInt(in.nextLine().trim());
            _score[_score_i] = _score_item;
        }

        res = maxScore(_score);
        System.out.println(String.valueOf(res));

    }
}
