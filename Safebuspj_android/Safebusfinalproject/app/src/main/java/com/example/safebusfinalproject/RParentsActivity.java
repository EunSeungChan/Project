package com.example.safebusfinalproject;

import android.content.ComponentName;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.safebusfinalproject.registerVO.RParentsVO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RParentsActivity extends AsyncTask<RParentsVO, Void, String> {
    String sendMsg, receiveMsg;

    @Override
    protected String doInBackground(RParentsVO... rp) {
        try {
            String str;
            Log.i("error","액티비티 들어옴");
            // 접속할 서버 주소 (이클립스에서 android.jsp 실행시 웹브라우저 주소)
            URL url = new URL("http://70.12.115.78:80/safebus/parents/add.do");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

            conn.setRequestMethod("POST");
            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

            // 전송할 데이터. GET 방식으로 작성
            sendMsg = "babyname=" + rp[0].getBabyName() + "&babygender=" + rp[0].getBabyGender()
                    + "&address=" + rp[0].getAddress() + "&station=" + rp[0].getStation() + "&id=" + rp[0].getMemberID()
                    + "&pw=" + rp[0].getMemberPW()  + "&name=" + rp[0].getMemberName()
                    + "&tel=" + rp[0].getMemberTel() + "&date=" + rp[0].getRegisterDate() + "&info=" + rp[0].getMemberinfo();

            Log.i("error",sendMsg);

            osw.write(sendMsg);
            osw.flush();

            //jsp와 통신 성공 시 수행
            if (conn.getResponseCode() == conn.HTTP_OK) {
                InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                BufferedReader reader = new BufferedReader(tmp);
                StringBuffer buffer = new StringBuffer();

                // jsp에서 보낸 값을 받는 부분
                while ((str = reader.readLine()) != null) {
                    buffer.append(str);
                }
                receiveMsg = buffer.toString();
                Log.i("error",receiveMsg);
                Log.i("error","addparetns 성공");

                //Intent i = new Intent();
                //ComponentName cname = new ComponentName("com.example.safebusfinalproject",
                 //       "com.example.safebusfinalproject.LoginActivity");
                //i.setComponent(cname);

                //startActivity(i);


            } else {
                // 통신 실패
                Log.i("error",receiveMsg);
                Log.i("error","addparents 실패 ");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //jsp로부터 받은 리턴 값
        return receiveMsg;
    }

}