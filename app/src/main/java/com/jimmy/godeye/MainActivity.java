package com.jimmy.godeye;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_target;
    TextView tv_sorce;
    TextView tv_index;
    Button btn_ok;
    Button btn_help;
    Button btn_replay;
    SeekBar sb_godeye;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();

       tv_target.setText("");



    }

    private void findView() {
        tv_target = (TextView) this.findViewById(R.id.tv_target);
        tv_sorce = (TextView) this.findViewById(R.id.tv_sorce);
        tv_index = (TextView) this.findViewById(R.id.tv_index);

        btn_ok = (Button) this.findViewById(R.id.btn_ok);
        btn_help = (Button) this.findViewById(R.id.btn_help);
        btn_replay = (Button) this.findViewById(R.id.btn_replay);

        sb_godeye = (SeekBar) this.findViewById(R.id.sb_godeye);

    }


}
