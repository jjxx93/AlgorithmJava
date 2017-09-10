package 盛大;

/**
 * Created by 熊佳新 on 2017/9/10.
 * 现公司要开发一个业务管理系统，要求注册环节的密码需要提示用户其安全等级，密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
 一、密码长度:
 5 分: 小于等于4 个字符
 10 分: 5 到7 字符
 25 分: 大于等于8 个字符
 二、字母:
 0 分: 没有字母
 10 分: 全都是小（大）写字母
 20 分: 大小写混合字母
 三、数字:
 0 分: 没有数字
 10 分: 1 个数字
 20 分: 大于1 个数字
 四、符号:
 0 分: 没有符号
 10 分: 1 个符号
 25 分: 大于1 个符号
 五、奖励:
 2 分: 字母和数字
 3 分: 字母、数字和符号
 5 分: 大小写字母、数字和符号
 最后的评分标准:
 大于等于 90: 非常安全
 大于等于80: 安全
 大于等于70: 非常强
 大于等于 60: 强
 大于等于 50: 一般
 大于等于 25: 弱
 大于等于0:  非常弱

 对应输出为：
 VERY_WEAK,
 WEAK,
 AVERAGE,
 STRONG,
 VERY_STRONG,
 SECURE,
 VERY_SECURE
 */
import java.util.Scanner;

public class Shengda2 {
    /**
     * 安全评级用枚举类型表示
     */
    enum SafetyLevel{
        VERY_WEAK, WEAK, AVERAGE, STRONG, VERY_STRONG, SECURE, VERY_SECURE
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in) ;
        String password = cin.nextLine() ;
        cin.close() ;

        SafetyLevel res = getPwdSecurityLevel(password) ;
        System.out.println(res.name()) ;
    }
    
    private static SafetyLevel getPwdSecurityLevel(String password) {
        int len = password.length() ;
        int upper = 0 ;
        int lower = 0 ;
        int num = 0 ;
        int sym = 0 ;

        int score = 0 ;
        char tempChar ;
        for(int i = 0 ; i < len ; i++){
            tempChar = password.charAt(i) ;
            if((tempChar <= 'Z') && (tempChar >= 'A')){
                upper++ ;
            }else if((tempChar <= 'z') && (tempChar >= 'a')){
                lower++ ;
            }else if((tempChar <= '9') && (tempChar >= '0')){
                num++ ;
            }else if(((tempChar >= 0x21) && (tempChar <= 0x2F)) || ((tempChar >= 0x3A) && (tempChar <= 0x40)) ||
                ((tempChar >= 0x7B) && (tempChar <= 0x7E))){
                sym++ ;
            }
        }

        //计算根据长度判断的得分
        if(len <= 4){
            score += 5 ;
        }else if(len <= 7){
            score += 10 ;
        }else{
            score += 25 ;
        }
        
        //计算根据字母情况判断得分
        if(((upper != 0) && (lower == 0)) ||
            ((upper == 0) && (lower != 0))){
            score += 10 ;
        }else if(upper != 0){
            score += 20 ;
        }
        
        //计算根据数字个数判断得分
        if(num == 1){
            score += 10 ;
        }else if(num > 1){
            score += 20 ;
        }
        
        //计算根据符号个数判断的得分
        if(sym == 1){
            score += 10 ;
        }else if(sym > 1){
            score += 25 ;
        }
        
        //计算奖励的判断得分
        if((upper != 0) && (lower != 0) &&
            (num != 0) && (sym != 0)){
            score += 5 ;
        }else if(((upper + lower) != 0) &&
            (num != 0) && (sym != 0)){
            score += 3 ;
        }else if(((upper + lower) != 0) &&
            (num != 0) && (sym == 0)){
            score += 2 ;
        }
        
        //根据得分确定最后的评级，并返回
        if(score >= 90){
            return SafetyLevel.VERY_SECURE ;
        }else if(score >= 80){
            return SafetyLevel.SECURE ;
        }else if(score >= 70){
            return SafetyLevel.VERY_STRONG ;
        }else if(score >= 60){
            return SafetyLevel.STRONG ;
        }else if(score >= 50){
            return SafetyLevel.AVERAGE ;
        }else if(score >= 25){
            return SafetyLevel.WEAK ;
        }else{
            return SafetyLevel.VERY_WEAK ;
        }

    }

}


