package Constitution_Suveyout;

import java.util.ArrayList;
import java.util.HashMap;

public class Check_Constitution {
    public int check_con(HashMap out){
        int count_1=0;
        int count_2=0;
        int output = 0;
        for(int i=1; i<=14;i++){
            if(out.containsValue(true)){
                count_1++;
            }else count_2++;
        }
        //단백질형
        if(count_1>count_2){
            output=1;
        }
        //하이브리드형
        else if(count_1==count_2) output=2;
        //탄수화물형
        else if(count_1<count_2) output=3;
        return output;
    }
    public ArrayList final_con_out(HashMap out){
        ArrayList arr=new ArrayList();
        int check=check_con(out);
        switch(check){
            //단백질 형
            case 1:
                arr.add(0.35);arr.add(0.45);arr.add(0.2);
                break;
            //하이브리드 형
            case 2:
                arr.add(0.5);arr.add(0.4);arr.add(0.1);
                break;
            //탄수화물 형
            case 3:
                arr.add(0.7);arr.add(0.2);arr.add(0.1);
                break;
            default:
                throw new IllegalStateException("Unknown Value= "+check);
        }
        return arr;
    }
}
