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

import Constitution_Suveyout.Pal_filter;
public class PAL_index extends AppCompatActivity {
    TextView suvey;
    Button check_1,check_2,check_3,btn_next,check_4,check_5;
    ArrayList filter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //PAL 지수용 HASH
        HashMap<String,Double> Ac_index =new HashMap<>();
        //설문조사
        HashMap<Integer, Boolean> data=(HashMap<Integer,Boolean>)getIntent().getSerializableExtra("output");
        //신체정보(length=5)
        HashMap<String, ArrayList> body_info=(HashMap<String,ArrayList>)getIntent().getSerializableExtra("body_info");
        //활동지수
        double activity_index=getIntent().getIntExtra("activity_index",0);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pal_index);
        setTitle("활동량1");
        suvey=(TextView) findViewById(R.id.textView2);
        check_1=(Button) findViewById(R.id.check_1);
        check_2=(Button) findViewById(R.id.check_2);
        check_3=(Button) findViewById(R.id.check_3);
        check_4=(Button) findViewById(R.id.check_4);
        check_5=(Button) findViewById(R.id.check_5);
        btn_next=(Button) findViewById(R.id.btn_next);


        Button.OnClickListener onClickListener= new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch(v.getId()){
                    case R.id.check_1:
                        check_1.setBackgroundColor(Color.parseColor("#bbccff"));
                        check_1.setEnabled(false);
                        Ac_index.put("check",1.0);
                        btn_next.setVisibility(v.VISIBLE);
                        check_2.setEnabled(true);
                        check_3.setEnabled(true);
                        check_4.setEnabled(true);
                        check_5.setEnabled(true);
                        break;
                    case R.id.check_2:
                        check_2.setBackgroundColor(Color.parseColor("#bbccff"));
                        check_2.setEnabled(false);
                        Ac_index.put("check",2.0);
                        btn_next.setVisibility(v.VISIBLE);
                        check_1.setEnabled(true);
                        check_3.setEnabled(true);
                        check_4.setEnabled(true);
                        check_5.setEnabled(true);
                        break;
                    case R.id.check_3:
                        check_3.setBackgroundColor(Color.parseColor("#bbccff"));
                        check_3.setEnabled(false);
                        Ac_index.put("check",3.0);
                        btn_next.setVisibility(v.VISIBLE);
                        check_1.setEnabled(true);
                        check_2.setEnabled(true);
                        check_4.setEnabled(true);
                        check_5.setEnabled(true);
                        break;
                    case R.id.check_4:
                        check_4.setBackgroundColor(Color.parseColor("#bbccff"));
                        check_4.setEnabled(false);
                        Ac_index.put("check",4.0);
                        btn_next.setVisibility(v.VISIBLE);
                        check_1.setEnabled(true);
                        check_2.setEnabled(true);
                        check_3.setEnabled(true);
                        check_5.setEnabled(true);
                        break;
                    case R.id.check_5:
                        check_5.setBackgroundColor(Color.parseColor("#bbccff"));
                        check_5.setEnabled(false);
                        Ac_index.put("check",5.0);
                        btn_next.setVisibility(v.VISIBLE);
                        check_1.setEnabled(true);
                        check_2.setEnabled(true);
                        check_3.setEnabled(true);
                        check_4.setEnabled(true);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected Value= "+v.getId());
                }
            }
        };

        check_1.setOnClickListener(onClickListener);
        check_2.setOnClickListener(onClickListener);
        check_3.setOnClickListener(onClickListener);
        check_4.setOnClickListener(onClickListener);
        check_5.setOnClickListener(onClickListener);
        ArrayList filter= new ArrayList();
        filter.add(Pal_filter.Pal_index_filter(Ac_index));
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), result.class);
                intent.putExtra("check_pal",filter);
                intent.putExtra("output",data);
                intent.putExtra("body_info",body_info);
                intent.putExtra("activity_index",activity_index);
                startActivity(intent);
            }
        });
    }
}