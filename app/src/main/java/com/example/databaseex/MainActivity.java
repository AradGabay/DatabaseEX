package com.example.databaseex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    HelperDB hlp;
    EditText studname, studphone, homephone, eTaddress, momsname, dadsname, dadsphone, momsphone;
    EditText gradesubj, gradenum, gradequarter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studname = findViewById(R.id.studname);
        studphone = findViewById(R.id.phonenumber);
        homephone = findViewById(R.id.homephone);
        eTaddress = findViewById(R.id.address);
        momsname = findViewById(R.id.momsname);
        momsphone = findViewById(R.id.momsphone);
        dadsname = findViewById(R.id.dadsname);
        dadsphone = findViewById(R.id.dadsphone) ;

        gradesubj = findViewById(R.id.gradesubj);
        gradenum = findViewById(R.id.grade);
        gradequarter = findViewById(R.id.quarter);

        hlp = new HelperDB(this);


    }

        //enter student's data into students database
    public void enterStudentData(View view) {
        String name, phone, home, address, mom, momphone, dad, dadphone;

        name = studname.getText().toString();
        phone = studphone.getText().toString();
        home = homephone.getText().toString();
        address = eTaddress.getText().toString();
        mom = momsname.getText().toString();
        momphone = momsphone.getText().toString();
        dad = dadsname.getText().toString();
        dadphone = dadsphone.getText().toString();


        ContentValues cv = new ContentValues();
        cv.put(Students.NAME,name);
        cv.put(Students.ADDRESS,address);
        cv.put(Students.PHONENUMBER,phone);
        cv.put(Students.HOMEPHONE,home);
        cv.put(Students.MOMNAME,mom);
        cv.put(Students.MOMPHONE,momphone);
        cv.put(Students.DADNAME,dad);
        cv.put(Students.DADPHONE,dadphone);

        db = hlp.getWritableDatabase();
        db.insert(Students.TABLE_STUDENTS,null,cv);
        db.close();


    }
        //enter student's grade data into grades database
    public void enterGradeData(View view) {
        String subject;
        int grade,quarter;

        subject = gradesubj.getText().toString();
        grade = Integer.parseInt(gradenum.getText().toString());
        quarter = Integer.parseInt(gradequarter.getText().toString());

        ContentValues cv = new ContentValues();
        cv.put(Grades.NAME,subject);
        cv.put(Grades.GRADE,grade);
        cv.put(Grades.QUARTER,quarter);

        db = hlp.getWritableDatabase();
        db.insert(Grades.TABLE_GRADES, null, cv);
        db.close();
    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case (R.id.menuWatch): {
                Intent t = new Intent(this, Watchtables.class);
                startActivity(t);
                break;
            }
            case (R.id.menuUpdate): {
                Intent t = new Intent(this, Update.class);
                startActivity(t);
                break;
            }
            case (R.id.menuSort): {
                Intent t = new Intent(this, Sort.class);
                startActivity(t);
                break;
            }
            default:
                break;
        }
        return true;
    }
}
