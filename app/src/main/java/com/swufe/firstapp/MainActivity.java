package com.swufe.firstapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inintView();
    }

    private final  int scoreArray[]={3,2,1};
    private int lastScore_a,score_a;
    private Button btna_1,btna_2,btna_3,btn4_reset;
    private TextView test_score_a;

    private void inintView() {
        //获取按钮id
        btna_1=findViewById(R.id.button1);
        btna_2=findViewById(R.id.button2);
        btna_3=findViewById(R.id.button3);
        btn4_reset=findViewById(R.id.button4);

        //得分情况和清零
        test_score_a=findViewById(R.id.textView2);

        //按钮实现监听
        btna_1.setOnClickListener(this);
        btna_2.setOnClickListener(this);
        btna_3.setOnClickListener(this);
        btn4_reset.setOnClickListener(this);
    }

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
                reset();
                break;
            default:
                break;
        }
    }

    //显示
    private void ShowText(){
        test_score_a.setText(Integer.toString(score_a));
    }

    //加分
    private void scoreAdd(int Tage,int score){
        //Tage:0:a
        if (Tage==0){
            //表示a进行加分
            lastScore_a=score;
            score_a+=lastScore_a;
        }
        ShowText();
    }
    //重置
    private void reset() {
        //弹出提示框，提示用户你是否要重置
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("提示")
                .setMessage("你确定要重置分数吗?")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        score_a=0;
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