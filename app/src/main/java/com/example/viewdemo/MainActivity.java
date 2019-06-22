package com.example.viewdemo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox checkBox=findViewById(R.id.checkbox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    Toast.makeText(MainActivity.this,"选中："+buttonView.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"取消选中",Toast.LENGTH_SHORT).show();
                }

            }
        });
        final AppCompatImageView imageView=findViewById(R.id.imag);
        final AppCompatTextView textView=findViewById(R.id.text);
        final AutoCompleteTextView autoCompleteTextView=findViewById(R.id.auto);
        final List<Book> bookList=new ArrayList<>();
        bookList.add(new Book("《小王子》",R.mipmap.ic_launcher));
        bookList.add(new Book("《狮子王》",R.mipmap.ic_launcher));
        bookList.add(new Book("《王小波全集》",R.mipmap.ic_launcher));
        final StyleFilterAdapter styleAdapter=new StyleFilterAdapter(MainActivity.this,bookList);
        autoCompleteTextView.setAdapter(styleAdapter);
        autoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){//保证在没有输入内容的情况下（但是有焦点）也能获得自动补全的提示
                    autoCompleteTextView    .showDropDown();//展示下拉列表（会根据内容自动筛选）
                }
            }
        });

//        TextView textView1=findViewById(R.id.as);
//        String htmlStr="https://www.baidu.com";
//        Spanned htmlSpanned= Html.fromHtml(htmlStr);
//        textView1.setText(htmlSpanned);
//        textView1.setMovementMethod(new LinkMovementMethod());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator=ObjectAnimator.ofObject(imageView,"fallingPos",new FallingEvaluator(),new Point(0,0),new Point(500,500));
                animator.setDuration(2000);
                ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(textView,"scaleX",0,3,1);
                ObjectAnimator objectAnimator1=ObjectAnimator.ofFloat(textView,"scaleY",0,3,1);
                objectAnimator1.setDuration(2222);
                objectAnimator.setDuration(2000);
                AnimatorSet animatorSet=new AnimatorSet();
              AnimatorSet.Builder builder=animatorSet.play(animator);
              builder.after(objectAnimator1);
         builder.before(objectAnimator);
            animatorSet.start();
            }
        });


    }
}
