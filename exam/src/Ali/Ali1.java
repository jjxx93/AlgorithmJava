package Ali;

import java.util.Scanner;

/**
 * Created by jjxx9 on 2017/4/26.
 */
public class Ali1 {
    private char[] str ;
    private char[] pattern  ;
    public boolean match(char[] str, char[] pattern)
    {
        this.str = str  ;
        this.pattern = pattern ;
        return match(0 , 0) ;
    }
    private boolean judge(int sPos , int pPos){
        int i = pattern.length-1  ;
        while(i >= pPos){
            if(pattern[i] == '*' || (i+1 < pattern.length && pattern[i+1] == '*')){
                i-- ;
            }else{
                return false ;
            }
        }
        return true;
    }
    private boolean match(int sPos , int pPos){
        if(sPos == str.length){
            return judge(sPos , pPos) ;
        }
        while(sPos < str.length && pPos < pattern.length){
            if(pattern[pPos] == '*'){
                int ne = pPos+1 ;
                while(ne < pattern.length && pattern[ne] == '*')
                    ne++ ;
                if(pattern[pPos-1] == '.'){
                    for(int i = sPos;i <= str.length;i++){
                        if(match(i,ne))return true ;
                    }
                    return false ;
                }
                if(match(sPos , ne))return true ;
                for(int i = sPos;i < str.length && str[i] == pattern[pPos-1];i++){
                    if(match(i+1 , ne)){
                        return true ;
                    }
                }
                return false ;
            }else if(pPos+1 < pattern.length && pattern[pPos+1] == '*'){
                pPos++ ;
            }else if(pattern[pPos] == '.'){
                sPos++;
                pPos++ ;
            }else if(str[sPos] == pattern[pPos]){
                sPos++ ;
                pPos++ ;
            }else{
                return false ;
            }
        }
        if(pPos == pattern.length){
            if(sPos < str.length)return false ;
            else return true ;
        }
        return judge(sPos , pPos) ;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();

        if(line1 != null && !line1.isEmpty() && line2 != null && !line2.isEmpty()) {
            Ali1 ali1 = new Ali1();

            boolean result = ali1.match(line1.toCharArray(), line2.toCharArray());
            if (result) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
/*
100-trade-done
1*trade*done
 */