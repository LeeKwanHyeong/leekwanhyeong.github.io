package Constitution_Suvey_14;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;

import Constitution_Suveyout.Check_Constitution;

public class result extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        HashMap<Integer, Boolean> data=(HashMap<Integer,Boolean>)getIntent().getSerializableExtra("output");
        HashMap<String, Double> body_info=(HashMap<String,Double>)getIntent().getSerializableExtra("body_info");
        int activity_index=getIntent().getIntExtra("activity_index",0);
        HashMap<String,ArrayList> pal_filter=(HashMap<String, ArrayList>)getIntent().getSerializableExtra("check_pal");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView=(TextView) findViewById(R.id.textView);
        //체질 조사 선언
        Check_Constitution checking= new Check_Constitution();
        ArrayList checked=checking.final_con_out(data);
        //신체정보 성별,나이,키,몸무게
        //활동지수
        //PAL 지수

        //통합 아웃풋
        //Common_output_with_Tdee real_output=new Common_output_with_Tdee();
        //Hash 반환값 ArrayList
        //HashMap co=real_output.common_output_ingredient_judgement(body_info,activity_index,pal_filter,checked);
        //ArrayList Carbo= (ArrayList) co.get("Carbo");
        //ArrayList Protein=(ArrayList) co.get("Protein");
        //ArrayList Fat=(ArrayList) co.get("Fat");
        //ArrayList to UI
        textView.setText(body_info.toString()+data.toString()+checked.toString()+activity_index+pal_filter.toString());
    }
}