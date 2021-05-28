package Constitution_Suveyout;

import java.util.ArrayList;
import java.util.HashMap;

public class Pal_filter {


    public static ArrayList Pal_index_filter(HashMap<String,Double> index) {

        ArrayList arr=new ArrayList();
        if(index.containsValue(1.0)==true){
            arr.add(1.0);
            arr.add(1.2);
        }
        else if(index.containsValue(2.0)==true){
            arr.add(2.0);
            arr.add(1.375);
        }
        else if(index.containsValue(3.0)==true){
            arr.add(3.0);
            arr.add(1.55);
        }
        else if(index.containsValue(4.0)==true){
            arr.add(4.0);
            arr.add(1.725);
        }
        else if(index.containsValue(5.0)==true){
            arr.add(5.0);
            arr.add(1.9);
        }
        return arr;
    }
}
