import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jjxx9 on 2017/4/11.
 */
class Dad {
    String name;
    private String nickName;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getNickName() {
        return nickName;
    }

    void setNickName(String nickName) {
        this.nickName = nickName;
    }
}


class Son extends Dad {
    String outSea;
}

public class Test {
    public static void main(String[] args){
        Dad d = new Dad();
        d.setNickName("jack");
        System.out.println(d.getNickName());
        Son s = new Son();
        s.setName("tom");
        System.out.println(s.getName());
    }
}
/*
while (上一次迭代中是有交换发生) {
    for（从第一个用户到最后一个用户）{     // Ni
        for（从第一个子载波到最后一个子载波）{       // SCk
            if （子载波SCk 没有连接到 用户Ni）{
                if (Ni-SCk的评价值 < Ni当前连接的最佳评价值) {
                    for (从Ni的最差连接子载波 到 低于连接SCk的评价值的最优连接子载波) {     // SCp
						for (从SCk的最差连接用户 到 最差连接用户) {		// Nj
							if (（Nj-SCp的评价值 > Ni-SCp的评价值） && （Ni-SCk的评价值 > Nj-SCk的评价值）) {
								交换
								记录有交换发生
								break; 跳出当前循环
							}
						}
                       
                    }
                }
            }
        }
    }
}
*/