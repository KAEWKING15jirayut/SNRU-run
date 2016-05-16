package com.jirayut.snrurun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SignupActivity extends AppCompatActivity {
    //การประกาศตัวแปร
    private EditText nameEditText, userEditText,passwordEditText;
    private RadioGroup radioGroup;
    private RadioButton choiceRadioButton,choiceRadioButton2,
            choiceRadioButton3,choiceRadioButton4,choiceRadioButton5;
    private String nameString,userString,passwordString,avataString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Bind Widget

        bindWidget();

    }   //เมททอดหลักจบด้วย ; (เชมิโคร่อน)

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
            myAlert.myDialog(this,"มีช่องว่างอ่ะ","กรุณากรอกทุกช่องหน่อย");

        } else {
        }
    }

}   //main class หรือ คลาสหลัก
