package com.example.lacie.tp_projects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button but1, but0, but_clear;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but1 = (Button) findViewById(R.id.but1);
        but0 = findViewById(R.id.but0);//оказывается, теперь найденную вьюху можно не кастовать к
        //определённому типу
        //и это прикольно, ы
        but_clear = findViewById(R.id.but_clear);
        text = (EditText) findViewById(R.id.text);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                switch (id) {
                    case R.id.but1:
                        setText(but1.getText());
                        break;
                    case R.id.but0:
                        setText(but0.getText());
                        break;
                    case R.id.but_clear:
                        text.setText("");
                        break;
                }

            }
        };
        but1.setOnClickListener(listener);
        but0.setOnClickListener(listener);
        but_clear.setOnClickListener(listener);
    }
    protected void setText(CharSequence i){//здесь я немного натупил:
        /*
        оказывается, setText() может принимать не только CharSequence,
        как это написал я. В моём случае setText не мог принимать строковые переменные (та и константы тоже),
        поэтому я намутил отдельный метод. Для очистки я воспользовался уже более подходящим
        методом setText, который в качестве параметров может принимать строки
         */
        text.append(i);
    }
}
