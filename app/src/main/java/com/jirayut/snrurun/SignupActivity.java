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
    private EditText nameEditText, userEditText,passwordEditText;
    private RadioGroup radioGroup;
    private RadioButton choiceRadioButton,choiceRadioButton2,
            choiceRadioButton3,choiceRadioButton4,choiceRadioButton5;
    private String nameString,userString,passwordString,avataString = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Bind Widget

        bindWidget();

        //การสร้างตัวควบคุมการเลือกซ้อย Radio Button Cotroller
        RadioButtonController();

    }   //เมททอดหลักจบด้วย ; (เชมิโคร่อน)

    private void RadioButtonController() {

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {

                switch (i) {
                    case R.id.radioButton:
                        avataString = "0";
                        break;
                    case R.id.radioButton2:
                        avataString = "1";
                        break;
                    case R.id.radioButton3:
                        avataString = "2";
                        break;
                    case R.id.radioButton4:
                        avataString = "3";
                        break;
                    case R.id.radioButton5:
                        avataString = "4";
                        break;
                }

            }
        });

    }

    private void bindWidget() {
        nameEditText= (EditText) findViewById(R.id.editText);
        userEditText= (EditText) findViewById(R.id.editText2);
        passwordEditText= (EditText) findViewById(R.id.editText3);
        radioGroup= (RadioGroup) findViewById(R.id.ragAvata);
        choiceRadioButton= (RadioButton) findViewById(R.id.radioButton);
        choiceRadioButton2= (RadioButton) findViewById(R.id.radioButton2);
        choiceRadioButton3= (RadioButton) findViewById(R.id.radioButton3);
        choiceRadioButton4= (RadioButton) findViewById(R.id.radioButton4);
        choiceRadioButton5= (RadioButton) findViewById(R.id.radioButton5);

    }

    public void clickSignUpSign(View view) {
        //Get Value EditText  รับค่าจาก signup เมื่อคลิก
        nameString=nameEditText.getText().toString().trim();
        userString=userEditText.getText().toString().trim();
        passwordString=passwordEditText.getText().toString().trim();
        //Check Space
        if (nameString.equals("")  || userString.equals("")  || passwordString.equals("")) {

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
                .add("Password", passwordString)
                .add("User", userString)
                .add("Avata", avataString)
                .build();
        Request.Builder builder = new Request.Builder();
        Request request = builder
                .url("http://swiftcodingthai.com/snru/add_user_master.php")
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
