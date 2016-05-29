package com.jirayut.snrurun;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class SignupActivity extends AppCompatActivity {
    //การประกาศตัวแปร
    private EditText  nameEditText,surnameEditText,userEditText,
            passwordEditText,addessEditText,phoneEditText;
    private String nameString,surnameString,userString,
            passwordString,addessString,phoneString = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Bind Widget

        bindWidget();

        //การสร้างตัวควบคุมการเลือกซ้อย Radio Button Cotroller

    }   //เมททอดหลักจบด้วย ; (เชมิโคร่อน)

    private void bindWidget() {
        nameEditText= (EditText) findViewById(R.id.editText);
        surnameEditText = (EditText) findViewById(R.id.editText2);
        userEditText= (EditText) findViewById(R.id.editText3);
        passwordEditText= (EditText) findViewById(R.id.editText4);
        addessEditText = (EditText) findViewById(R.id.editText5);
        phoneEditText = (EditText) findViewById(R.id.editText6);


    }

    public void clickSignUpSign(View view) {
        //Get Value EditText  รับค่าจาก signup เมื่อคลิก
        nameString=nameEditText.getText().toString().trim();
        surnameString=surnameEditText.getText().toString().trim();
        userString=userEditText.getText().toString().trim();
        passwordString=passwordEditText.getText().toString().trim();
        addessString=addessEditText.getText().toString().trim();
        phoneString=phoneEditText.getText().toString().trim();
        //Check Space
        if (nameString.equals("")  || surnameString.equals("")  || userString.equals("")  || passwordString.equals("")  || addessString.equals("")  || phoneString.equals("")) {

            MyAlert myAlert=new MyAlert();
            myAlert.myDialog(this,"มีช่องว่างอ่ะดูหน่อย","ตาบอดรึงัย ดูบ้างน่ะ");

        } else {
            //ทำการส่งข้อมูลเข้าฐานข้อมูล
            updateUserTABLE();
        }
    }

    private void updateUserTABLE() {

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd","true")
                .add("Name", nameString)
                .add("Surname", surnameString)
                .add("User", userString)
                .add("Password", passwordString)
                .add("Addess", addessString)
                .add("Phone", phoneString)
                .build();
        Request.Builder builder = new Request.Builder();
        Request request = builder
                .url("http://swiftcodingthai.com/snru/add_user_pn.php")
                .post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
            finish();
            }
        });
    }//ขอบเขตของ updateUserTABLE

}   //main class หรือ คลาสหลัก
