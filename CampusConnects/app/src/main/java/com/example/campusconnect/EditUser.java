package com.example.campusconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditUser extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        Button confirm;
        EditText newUser;
        confirm= findViewById(R.id.btn_editname);
        newUser = findViewById(R.id.et_newname);


        Intent cadta= getIntent();
        int userid= cadta.getIntExtra("uid",-1);
        System.out.println(userid);
        if(userid != -1){
            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatabaseHelper databaseHelper = new DatabaseHelper(EditUser.this);
                    int status= databaseHelper.editUser(userid,newUser.getText().toString());
                    if(status ==1){
                        Toast.makeText(EditUser.this, "Success", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(EditUser.this, "Failure", Toast.LENGTH_SHORT).show();
                    }
                    startActivity(new Intent(EditUser.this,AdminDashboard.class));
                    finish();
                }
            });
        }

    }
}