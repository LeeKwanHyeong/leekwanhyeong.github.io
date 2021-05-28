package Constitution_Suveyout;

import java.util.ArrayList;

public class Ingredient_Macro_Module {

    //탄수화물 계산기
    public ArrayList constitution_carbohydrate_macro(double tdee, double output)
    {
        ArrayList arr=new ArrayList();
        double carbo_kcal=tdee*output;
        double carbo_g=carbo_kcal/4;
        arr.add(carbo_kcal);
        arr.add(carbo_g);
        return arr;
    }
    //단백질 계산기
    public ArrayList constitution_protein_macro(double tdee_index,double weight)
    {
        double output=0;
        ArrayList arr=new ArrayList();
        if (tdee_index==1.0)
        {
            output=weight*0.8;
        }
        else if(tdee_index==2.0) output=weight*0.9;
        else if(tdee_index==3.0) output=weight*1.0;
        else if(tdee_index==4.0) output=weight*1.1;
        else if(tdee_index==5.0) output=weight*1.2;
        double protein_g=output;
        double protein_kcal=output*4;
        arr.add(protein_kcal);
        arr.add(protein_g);
        return arr;
    }

    //지방 계산기
    public ArrayList constitution_fat_macro(double tdee,double output)
    {
        ArrayList arr=new ArrayList();
        double fat_kcal=tdee*output;
        double fat_g=fat_kcal/9;
        arr.add(fat_kcal);
        arr.add(fat_g);
        return arr;
    }
}
