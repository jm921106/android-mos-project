package com.example.sejune.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    //Login 변수
    EditText login_email, login_pwd;
    Button login_login;
    TextView login_newAccount, login_forgetPW;

    //디비객체생성
    final dataBase dbManager = new dataBase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, splash.class));
        setContentView(R.layout.mos_login);

        login_email = (EditText) findViewById(R.id.login_email);
        login_pwd = (EditText) findViewById(R.id.login_pwd);
        login_login = (Button) findViewById(R.id.login_login);
        login_newAccount = (TextView) findViewById(R.id.login_newAccount);
        login_forgetPW = (TextView) findViewById(R.id.login_forgetPW);


        try {
            SQLiteDatabase db = dbManager.getWritableDatabase();
            dbManager.onUpgrade(db, 1, 2);
            dbManager.insert("INSERT INTO accountTBL VALUES('email1', 'pw1234', '유재석', 0);");

            dbManager.insert("INSERT INTO accountTBL VALUES('email2', 'pw1234', '박명수', 2);");
            dbManager.insert("INSERT INTO accountTBL VALUES('email3', 'pw1234', '정준하', 2);");
            dbManager.insert("INSERT INTO accountTBL VALUES('email4', 'pw1234', '하동훈', 2);");
            dbManager.insert("INSERT INTO accountTBL VALUES('email5', 'pw1234', '황광희', 2);");
            dbManager.insert("INSERT INTO accountTBL VALUES('email6', 'pw1234', '정형돈', 2);");
            dbManager.insert("INSERT INTO accountTBL VALUES('email7', 'pw1234', '노홍철', 2);");

            dbManager.insert("INSERT INTO accountTBL VALUES('email9', 'pw1234', '김종국', 2);");
            dbManager.insert("INSERT INTO accountTBL VALUES('email10', 'pw1234', '송지효', 2);");
            dbManager.insert("INSERT INTO accountTBL VALUES('email11', 'pw1234', '강개리', 2);");
            dbManager.insert("INSERT INTO accountTBL VALUES('email12', 'pw1234', '이광수', 2);");
            dbManager.insert("INSERT INTO accountTBL VALUES('email13', 'pw1234', '지석진', 2);");

            dbManager.insert("INSERT INTO accountTBL VALUES('email14', 'pw1234', '양현석', 0);");

            dbManager.insert("INSERT INTO accountTBL VALUES('email15', 'pw1234', 'GD', 2);");
            dbManager.insert("INSERT INTO accountTBL VALUES('email16', 'pw1234', 'TOP', 2);");
            dbManager.insert("INSERT INTO accountTBL VALUES('email17', 'pw1234', '태양', 2);");
            dbManager.insert("INSERT INTO accountTBL VALUES('email18', 'pw1234', '대성', 2);");
            dbManager.insert("INSERT INTO accountTBL VALUES('email19', 'pw1234', '승리', 2);");

            dbManager.insert("INSERT INTO storeTBL VALUES(0, '무한도전', '유재석', '111', 'MBC');");
            dbManager.insert("INSERT INTO staffTBL VALUES(0, 'email1', '무한도전');");

            dbManager.insert("INSERT INTO storeTBL VALUES(1, '런닝맨', '유재석', '112', 'SBS');");
            dbManager.insert("INSERT INTO staffTBL VALUES(1, 'email1', '런닝맨');");

            dbManager.insert("INSERT INTO storeTBL VALUES(2, '빅뱅', '양현석', '113', 'YG');");
            dbManager.insert("INSERT INTO staffTBL VALUES(2, 'email13', '빅뱅');");

            Toast.makeText(getApplicationContext(), "insert ok", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "error!", Toast.LENGTH_SHORT).show();
        }


        //로그인 버튼
        login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //go to SelectStore
            Intent intent = new Intent(getApplicationContext(), selectStore.class);

            //go to Base
            //Intent intent = new Intent(getApplicationContext(), Base.class);
            startActivity(intent);
            //Intent intent = new Intent(getApplicationContext(), selectStore.class);
            /*
            class_Login login = new class_Login();
            String ID = login_email.getText().toString();
            int key = login.login(ID, login_pwd.getText().toString());
            switch(key){
                case 0:
                    Toast.makeText(getApplicationContext(),"" + ID + " 님 환영합니다!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Base.class);
                    startActivity(intent);
                    break;
                case 1:
                    Toast.makeText(getApplicationContext(), "비밀번호를 다시 확인해 주세요.", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(getApplicationContext(), "존재하지 않는 계정입니다.", Toast.LENGTH_SHORT).show();
                    break;
            }
            */
            }
        });

        //신규 계정
        login_newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), newAccount.class);
                startActivity(intent);
            }
        });

        //비밀번호 찾기
        login_forgetPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), forgetPW.class));
            }
        });
    }
}
