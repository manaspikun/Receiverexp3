package com.techpalle.receiverexp3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private   EditText editText1;
    private   TextView textView1;
    private    Button button1;


    // creae a dynamic broadcast receiver

    public class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            textView1.setText("done");
        }
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText);
        textView1 = (TextView) findViewById(R.id.textView);
        button1 = (Button) findViewById(R.id.button);

        MyReceiver myReceiver = new MyReceiver();
        IntentFilter intentFilter =  new IntentFilter();
        intentFilter.addAction("WORK_DONE");
        registerReceiver(myReceiver,intentFilter);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // here start service and pass edit text value
                String name = editText1.getText().toString();
                Intent intent = new Intent(MainActivity.this, MyService.class);
                intent.putExtra("name",name);
                startService(intent);

            }
        });
    }
}
