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

public class Suvey14 extends AppCompatActivity {
    TextView suvey;
    Button btn_yes,btn_no,btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        HashMap<Integer, Boolean> data=(HashMap<Integer,Boolean>)getIntent().getSerializableExtra("output");
        HashMap<String, ArrayList> body_info=(HashMap<String,ArrayList>)getIntent().getSerializableExtra("body_info");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suvey12);
        setTitle("질문지 14");
        suvey=(TextView) findViewById(R.id.textView2);
        btn_yes=(Button) findViewById(R.id.btn_yes);
        btn_no=(Button) findViewById(R.id.btn_no);
        btn_next=(Button) findViewById(R.id.btn_next);

        View.OnClickListener onClickListener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.btn_yes:
                        btn_yes.setBackgroundColor(Color.parseColor("#bbccff"));
                        btn_yes.setEnabled(false);
                        data.put(14,true);
                        btn_next.setVisibility(v.VISIBLE);
                        btn_no.setEnabled(true);
                        break;
                    case R.id.btn_no:
                        btn_yes.setBackgroundColor(Color.parseColor("#bbccff"));
                        btn_no.setEnabled(false);
                        data.put(14,false);
                        btn_next.setVisibility(v.VISIBLE);
                        btn_yes.setEnabled(true);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected Value"+v.getId());
                }
            }
        };
        btn_yes.setOnClickListener(onClickListener);
        btn_no.setOnClickListener(onClickListener);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Activity_index.class);
                intent.putExtra("body_info",body_info);
                intent.putExtra("output",data);
                startActivity(intent);
            }
        });
    }
}