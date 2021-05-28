package Constitution_Suvey_14;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;


public class Suvey1 extends AppCompatActivity {
    TextView suvey;
    Button btn_yes,btn_no,btn_next;
    HashMap<Integer, Boolean> map = new HashMap<>();


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suvey1);
        setTitle("질문지1");
        suvey=(TextView) findViewById(R.id.textView2);
        btn_yes=(Button) findViewById(R.id.btn_yes);
        btn_no=(Button) findViewById(R.id.btn_no);
        btn_next=(Button) findViewById(R.id.btn_next);




        Button.OnClickListener onClickListener=new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Hash 키값 덮어씌어준다.
                if(v.getId()==R.id.btn_yes){
                    btn_yes.setBackgroundColor(Color.parseColor("#bbccff"));
                    btn_yes.setEnabled(false);
                    map.put(1,true);
                    btn_next.setVisibility(v.VISIBLE);
                    btn_no.setEnabled(true);
                }
                else if(v.getId()==R.id.btn_no){
                    btn_no.setBackgroundColor(Color.parseColor("#bbccff"));
                    btn_no.setEnabled(false);
                    map.put(1,false);

                    btn_next.setVisibility(v.VISIBLE);
                    btn_yes.setEnabled(true);
                }
                //v는 하나밖에 들어오지 않는다.
                //자바 hash map
            }

            //intent=new Intent(getApplicationContext(),Suvey2.class);
             //           intent.putExtra("output",2);
            //startActivity(intent);
            //int value=intent.getExtras().getInt("output");
        };

        btn_no.setOnClickListener(onClickListener);
        btn_yes.setOnClickListener(onClickListener);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, ArrayList> body_info=(HashMap<String,ArrayList>)getIntent().getSerializableExtra("body_info");
                Intent intent=new Intent(getApplicationContext(),Suvey2.class);
                intent.putExtra("body_info",body_info);
                intent.putExtra("output", map);
                startActivity(intent);
            }
        });

    }
}

