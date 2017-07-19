package com.jimmy.godeye;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity {

    TextView tv_target;
    TextView tv_score;
    TextView tv_index;
    Button btn_ok;
    ImageButton btn_help;
    ImageButton btn_replay;
    SeekBar sb_godeye;

    int randomScore;
    int finalScore;

    int totalScore;
    int totaltime;

    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        findView();
        randomOfScore();


        setOnclick();


    }

//    private void initSeekBar() {
//       // sb_godeye
//    }

    private void setOnclick() {
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentScore = sb_godeye.getProgress();

                finalScore = 100 - Math.abs(currentScore - randomScore);

                totalScore += finalScore;
                totaltime++;

                showTextView();
                randomOfScore();
            }
        });

        btn_replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomOfScore();
                totalScore = 0;
                totaltime = 0;
                showTextView();

            }


        });


        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("help").setMessage("这是帮助").setPositiveButton(R.string.ensure, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                });


                AlertDialog dialog = builder.create();


                dialog.show();


            }
        });


    }

    private void showTextView() {
        tv_score.setText("分数：" + totalScore);
        tv_index.setText("局数：" + totaltime);
        sb_godeye.setProgress(0);
    }

    private void randomOfScore() {
        Random random = new Random();
        randomScore = random.nextInt(99) + 1;

        tv_target.setText("小伙子麻烦把进度条拖到：" + randomScore);
    }

    private void findView() {
        tv_target = (TextView) this.findViewById(R.id.tv_target);
        tv_score = (TextView) this.findViewById(R.id.tv_score);
        tv_index = (TextView) this.findViewById(R.id.tv_index);

        btn_ok = (Button) this.findViewById(R.id.btn_ok);
        btn_help = (ImageButton) this.findViewById(R.id.btn_help);
        btn_replay = (ImageButton) this.findViewById(R.id.btn_replay);

        sb_godeye = (SeekBar) this.findViewById(R.id.sb_godeye);

    }


}
