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

public class Activity_index extends AppCompatActivity {
    TextView suvey;
    Button check_1,check_2,check_3,btn_next,check_4,check_5;
    double out=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        HashMap<Integer, Boolean> data=(HashMap<Integer,Boolean>)getIntent().getSerializableExtra("output");
        HashMap<String, ArrayList> body_info=(HashMap<String,ArrayList>)getIntent().getSerializableExtra("body_info");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        setTitle("활동량1");
        suvey=(TextView) findViewById(R.id.textView2);
        check_1=(Button) findViewById(R.id.check_1);
        check_2=(Button) findViewById(R.id.check_2);
        check_3=(Button) findViewById(R.id.check_3);
        btn_next=(Button) findViewById(R.id.btn_next);

        Button.OnClickListener onClickListener= new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.check_1:
                        check_1.setBackgroundColor(Color.parseColor("#bbccff"));
                        check_1.setEnabled(false);
                        out=1.0;
                        btn_next.setVisibility(v.VISIBLE);
                        check_2.setEnabled(true);
                        check_3.setEnabled(true);
                        break;
                    case R.id.check_2:
                        check_2.setBackgroundColor(Color.parseColor("#bbccff"));
                        check_2.setEnabled(false);
                        out=2.0;
                        btn_next.setVisibility(v.VISIBLE);
                        check_1.setEnabled(true);
                        check_3.setEnabled(true);
                        break;
                    case R.id.check_3:
                        check_3.setBackgroundColor(Color.parseColor("#bbccff"));
                        check_3.setEnabled(false);
                        out=3.0;
                        btn_next.setVisibility(v.VISIBLE);
                        check_1.setEnabled(true);
                        check_2.setEnabled(true);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected Value= "+v.getId());
                }
            }
        };
        check_1.setOnClickListener(onClickListener);
        check_2.setOnClickListener(onClickListener);
        check_3.setOnClickListener(onClickListener);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), PAL_index.class);
                intent.putExtra("output",data);
                intent.putExtra("body_info",body_info);
                intent.putExtra("activity_index",out);
                startActivity(intent);
            }
        });
    }
}