package Constitution_Suvey_14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;

public class body_info extends AppCompatActivity {
    /*성별,나이,체중,키,bmi값을 입력받아 Intent를 통해 넘기는 과정*/
    double sex_d,age_d,weight_d,height_d,bmi_d;
    EditText sex,age,weight,height,bmi;
    Button btn_next;
    //인텐트를 넘길때 HashMap을 활용하여 데이터 이동.
    HashMap<String, ArrayList> body_info=new HashMap<String, ArrayList>();
    //ArrayList body_info=new ArrayList();
    ArrayList body_temp=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_info);
        sex= findViewById(R.id.sex);
        age=findViewById(R.id.age);
        weight=findViewById(R.id.weight);
        height=findViewById(R.id.height);
        bmi=findViewById(R.id.bmi);
        btn_next=findViewById(R.id.btn_next);




        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    sex_d = Double.parseDouble(sex.getText().toString());
                    age_d = Double.parseDouble(age.getText().toString());
                    weight_d = Double.parseDouble(weight.getText().toString());
                    height_d = Double.parseDouble(height.getText().toString());
                    bmi_d=Double.parseDouble(bmi.getText().toString());
                    //body_info.put("sex",sex_d);
                }catch(NumberFormatException e){e.printStackTrace();}

                body_temp.add(sex_d);body_temp.add(age_d);body_temp.add(weight_d);body_temp.add(height_d);body_temp.add(bmi_d);

                body_info.put("body_info",body_temp);
                Intent intent=new Intent(getApplicationContext(),Suvey1.class);
                intent.putExtra("body_info",body_info);
                startActivity(intent);
            }
        });

    }
}