package com.swufe.firstapp.score;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.swufe.firstapp.R;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        inintView();
    }

    private final  int scoreArray[]={3,2,1};
    private  int lastScore_a,lastScore_b,score_a,score_b;
    private Button btna_1,btna_2,btna_3,btnb_1,btnb_2,btnb_3,btn_reset;
    private TextView test_score_a,test_score_b;

    private void inintView() {
        //获取按钮id
        btna_1=findViewById(R.id.button1);
        btna_2=findViewById(R.id.button2);
        btna_3=findViewById(R.id.button3);
        btnb_1=findViewById(R.id.button4);
        btnb_2=findViewById(R.id.button5);
        btnb_3=findViewById(R.id.button6);
        btn_reset=findViewById(R.id.button7);

        //得分情况
        test_score_a=findViewById(R.id.textView3);
        test_score_b=findViewById(R.id.textView4);

        //按钮实现监听
        btna_1.setOnClickListener(this);
        btna_2.setOnClickListener(this);
        btna_3.setOnClickListener(this);
        btnb_1.setOnClickListener(this);
        btnb_2.setOnClickListener(this);
        btnb_3.setOnClickListener(this);
        btn_reset.setOnClickListener(this);
    }

    //点击事件
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                scoreAdd(0,scoreArray[0]);
                break;
            case R.id.button2:
                scoreAdd(0,scoreArray[1]);
                break;
            case R.id.button3:
                scoreAdd(0,scoreArray[2]);
                break;
            case  R.id.button4:
                scoreAdd(1,scoreArray[0]);
                break;
            case  R.id.button5:
                scoreAdd(1,scoreArray[1]);
                break;
            case  R.id.button6:
                scoreAdd(1,scoreArray[2]);
                break;
            case  R.id.button7:
                reset();
                break;
            default:
                break;
        }
    }

    //显示
    private void ShowText(){
        test_score_a.setText(Integer.toString(score_a));
        test_score_b.setText(Integer.toString(score_b));
    }

    //加分
    private void scoreAdd(int Tage,int score){
        //Tage:   0:a  1:b
        if (Tage==0||Tage==1){
            if (Tage==0){
                //表示a进行加分
                lastScore_b=0;
                lastScore_a=score;
                score_a+=lastScore_a;
            }else if (Tage==1){
                //表示对b进行加分
                lastScore_a=0;
                lastScore_b=score;
                score_b+=lastScore_b;
            }
            ShowText();
        }
    }

    //重置
    private void reset() {
        //弹出提示框，提示用户是否要重置
        AlertDialog.Builder builder=new AlertDialog.Builder(SecondActivity.this);
        builder.setTitle("提示")
                .setMessage("你确定要重置分数吗?")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        score_a=0;
                        score_b=0;
                        ShowText();
                        dialog.dismiss();;
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog  dialog=builder.create();
        dialog.show();
    }
}