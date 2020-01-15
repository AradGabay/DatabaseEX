package com.example.databaseex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    HelperDB hlp;
    EditText studname, studage;
    EditText gradesubj, gradetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studname = findViewById(R.id.studname);
        studage = findViewById(R.id.studage);
        gradesubj = findViewById(R.id.gradesubj);
        gradetext = findViewById(R.id.grade);

        hlp = new HelperDB(this);


    }

    public void enterStudentData(View view) {
        String name = studname.getText().toString();
        int age = Integer.parseInt(studname.getText().toString());

        ContentValues cv = new ContentValues();

        db = hlp.getWritableDatabase();
        cv.put(Students.NAME, name);
        cv.put(Students.AGE, age);
        db.insert(Students.TABLE_STUDENTS,null,cv);
        db.close();
    }

    public void enterGradeData(View view) {
        String subject, strgrade;
        int grade;

        subject = gradesubj.getText().toString();
        strgrade = gradetext.getText().toString();
        grade = Integer.parseInt(strgrade);

        ContentValues cv = new ContentValues();
        cv.put(Grades.SUBJECT, subject);
        cv.put(Grades.GRADE, grade);

        db = hlp.getWritableDatabase();
        db.insert(Grades.TABLE_GRADES, null, cv);
        db.close();
    }
}
