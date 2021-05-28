package Constitution_Suveyout;

import java.util.ArrayList;
import java.util.HashMap;
public class Common_output_with_Tdee {
    //activate_tdee td=new activate_tdee();
    //double tdee=td.activate_tdee_out();
    //private double[] output;
    //private double carbohydrate,protein,fat;
    //다이어트 건강유지 관련
    //1. 체질 조사를 통해 우선적으로 분배율 구한 후 그에 맞게 단백질 구한다.
    //2. 그렇지 않을 경우 체중과 HAL에 맞게 단백질 섭취량을 구한다.(이미 만들어짐)

    public HashMap common_output_ingredient_judgement(HashMap<String,Double> body_info,int activity_index,ArrayList pal_index,ArrayList Consti_judge)
    {
        //activate_tdee td=new activate_tdee();
        Ingredient_Macro_Module macro=new Ingredient_Macro_Module();
        ArrayList consti_arr,carbo,protein,fat=new ArrayList();

        double consti_carbo=(double) Consti_judge.get(0);
        double consti_protein=(double) Consti_judge.get(1);
        double consti_fat=(double) Consti_judge.get(2);

        ArrayList tdee=Activate_tdee.activate_tdee_out(body_info,pal_index);
        double tdee_kcal=(double) tdee.get(0);
        double tdee_protein=(double) tdee.get(1);
        double tdee_weight=(double) tdee.get(2);
        carbo=macro.constitution_carbohydrate_macro(tdee_kcal, consti_carbo);
        protein=macro.constitution_protein_macro(tdee_protein, tdee_weight);
        fat=macro.constitution_fat_macro(tdee_kcal, consti_fat);
        HashMap<String,ArrayList> common_output=new HashMap<String, ArrayList>();
        common_output.put("Carbo",carbo);
        common_output.put("Protein",protein);
        common_output.put("Fat",fat);
        return common_output;
    }
    public HashMap diet_output_ingredient_judgement(HashMap<String,Double> body_info,int activity_index,ArrayList pal_index,ArrayList Consti_judge)
    {

        Ingredient_Macro_Module macro=new Ingredient_Macro_Module();
        ArrayList consti_arr,carbo,protein,fat=new ArrayList();
        double consti_carbo=(double) Consti_judge.get(0);
        double consti_protei=(double) Consti_judge.get(1);
        double consti_fat=(double) Consti_judge.get(2);

        ArrayList tdee=Activate_tdee.activate_tdee_out(body_info,pal_index);
        double tdee_kcal=(double)(tdee.get(0))*0.8;
        double tdee_protein=(double) tdee.get(1);
        double tdee_weight=(double) tdee.get(2);
        carbo=macro.constitution_carbohydrate_macro(tdee_kcal,consti_carbo);
        protein=macro.constitution_protein_macro(tdee_protein, tdee_weight);
        fat=macro.constitution_fat_macro(tdee_kcal, consti_fat);
        HashMap<String,ArrayList> common_output=new HashMap<String, ArrayList>();
        common_output.put("Carbo",carbo);
        common_output.put("Protein",protein);
        common_output.put("Fat",fat);
        return common_output;
    }
}
