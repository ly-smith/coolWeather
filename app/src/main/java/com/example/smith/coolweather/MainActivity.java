package com.example.smith.coolweather;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.send_btn);
        btn.setOnClickListener(this);               //一、点击事件
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send_btn:                    //二、判断点击事件
                //Log.e("OnClick","onClick");
                new Thread(runnable).start();       //三、开启子线程runnable
                break;
        }
    }

    Handler myHandler = new Handler(){
        public  void handleMessage(Message msg){
            super.handleMessage(msg);
            Bundle data = new Bundle();
            data = msg.getData();
            Log.e("Tag","id:"+data.get("id").toString());
            Log.e("Tag","name:"+data.get("name").toString());
            Log.e("Tag","age:"+data.get("age").toString());

        }
    };

    Runnable runnable = new Runnable() {
        private Connection con = null;
        @Override
        public void run() {
            try {
                //四、连接数据库，测试连接
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/coolweather","root","123456");
                Log.e("mysql","Mysql successful");
                testConnection(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
            /*
            try {
                testConnection(con);
            }catch (SQLException e){
                e.printStackTrace();
            }*/
        }
    };

    //为数据库提供链接测试
    public void testConnection(Connection con1) throws java.sql.SQLException{
        try{
            //Log.e("connection","testConnection");
            String sql = "select * from users";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.print(rs);
            Bundle bundle = new Bundle();
            while (rs.next()){
                bundle.clear();
                bundle.putInt("id",rs.getInt("id"));
                bundle.putString("name",rs.getString("name"));
                bundle.putInt("age",rs.getInt("age"));
                Message msg = new Message();
                msg.setData(bundle);
                myHandler.sendMessage(msg);
            }

            rs.close();
            stmt.close();
        }catch (SQLException e){

        }finally {
            if(con1 != null) {
                try{
                    con1.close();
                }catch(SQLException e){ }
            }
        }
    }

}
