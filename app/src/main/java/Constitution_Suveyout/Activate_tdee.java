package Constitution_Suveyout;

import java.util.ArrayList;
import java.util.HashMap;
public class Activate_tdee {


    public static ArrayList activate_tdee_out(HashMap<String, Double> body_info, ArrayList pal_index)
    {
        double sex=body_info.get("sex");
        double age=body_info.get("age");
        double weight=body_info.get("weight");
        double height=body_info.get("height");
        double bmi=body_info.get("bmi");
        ArrayList arr=new ArrayList();

        Tdee_module tdee=new Tdee_module();
        Object obj=pal_index.get(0);
        Double temp=(Double) obj;
        double pal_index_num=temp.doubleValue();

        //double ree=tdee.REE_revised(sex, age, weight, height);
        double bmr=tdee.BMR_module(sex, age, weight, height);
        System.out.println(bmr);
        double tef=tdee.TEF(sex, age, weight, height);
        System.out.println(tef);
        //double eee=tdee.EEE_s(age, weight, bmi);
        //System.out.println(eee);
        //double eee=tdee.EEE(pal_arr);
        double neat=tdee.NEAT(pal_index_num);
        double output_tdee=bmr+tef+250+neat;
        arr.add(output_tdee);
        arr.add(pal_index_num);
        arr.add(weight);
        return arr;
    }


    }

