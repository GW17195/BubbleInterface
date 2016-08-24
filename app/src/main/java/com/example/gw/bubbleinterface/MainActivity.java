package com.example.gw.bubbleinterface;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView msgListView;
    private EditText inputText;
    private  Button speakKey;
    private  int speakKeyAndInputTextFlag=0;
    private Button send;
    private Button switchKey;
    private  MsgAdapter adapter;
    private List<Msg> msgList=new ArrayList<Msg>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_activity_layout);

        initMsgs();
        adapter=new MsgAdapter(MainActivity.this,R.layout.msg_item,msgList);
        inputText=(EditText)findViewById(R.id.input_text);
        speakKey=(Button)findViewById(R.id.speakKey);
        speakKey.setVisibility(View.GONE);
        send=(Button)findViewById(R.id.send);
        switchKey=(Button)findViewById(R.id.switchKey);
        msgListView=(ListView)findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg=new Msg(content,Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();//当有新消息时刷新listview中的显示
                    msgListView.setSelection(msgList.size());//将listview定位到最后一行
                    inputText.setText("");
                }
            }
        });

        switchKey.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (speakKeyAndInputTextFlag==0){//为零表示说话按钮不可见，而文本框可见，需要在这个条件中做处理
                    inputText.setVisibility(View.GONE);
                    speakKey.setVisibility(View.VISIBLE);
                    speakKeyAndInputTextFlag=1;
                }else if(speakKeyAndInputTextFlag==1){
                    inputText.setVisibility(View.VISIBLE);
                    speakKey.setVisibility(View.GONE);
                    speakKeyAndInputTextFlag=0;
                }

            }
        });

        speakKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"hahahaha",Toast.LENGTH_SHORT).show();;
            }
        });
        /*speakKey.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Toast.makeText(MainActivity.this,"ACTION_DOWN",Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Toast.makeText(MainActivity.this,"ACTION_MOVE",Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        Toast.makeText(MainActivity.this,"ACTION_CANCEL",Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_UP:
                        Toast.makeText(MainActivity.this,"ACTION_UP",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });*/
    /*    speakKey.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this,"onTouch",Toast.LENGTH_SHORT).show();
                return false;
            }
        });*/
    }

    private void initMsgs(){
        Msg msg1=new Msg("Hello guy",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2=new Msg("Hello Who is that?",Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3=new Msg("This is Tom.Nice talking to you",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }








}
