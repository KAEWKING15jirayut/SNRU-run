package com.jirayut.snrurun;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    //ประกาศตัวแปร
    private MyManage myManage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myManage = new MyManage(MainActivity.this);
        //Test Add User
        //myManage.addUser("Jirayut1", "Kaewking2", "1234", "3");
        //การลบฐานข้อมูล
        deleteAllSQLite();

        //Sycchonize
        MySynchronize mySynchronize = new MySynchronize();
        mySynchronize.execute();

    }   //เมททอดหลักจบด้วย ; (เชมิโคร่อน)

    //สร้าง คลาส ช้อน คลาส
    public class MySynchronize extends AsyncTask<Void, Void, String> {




        @Override
        protected String doInBackground(Void... params) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url("http://swiftcodingthai.com/snru/get_user.php").build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {//การทำงานคือรอการกลับมา จากการเสี่ยงเออเลอ
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("Snru", "JSON==>" + s);
            try {

                JSONArray jsonArray = new JSONArray(s);
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String strName = jsonObject.getString
                            (MyManage.column_name);
                    String strUser = jsonObject.getString
                            (MyManage.column_user);
                    String strPassword = jsonObject.getString
                            (MyManage.column_password);
                    String strAvata = jsonObject.getString
                            (MyManage.column_avata);

                    myManage.addUser(strName, strUser, strPassword, strAvata);

                }



            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    } // MySyc Class



    private void deleteAllSQLite() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE,null);
        sqLiteDatabase.delete(MyManage.user_table, null, null);

    }

    public void clickSignUpMain(View view) {
        startActivity(new Intent(MainActivity.this, SignupActivity.class));
    }

}   //main class หรือ คลาสหลัก
