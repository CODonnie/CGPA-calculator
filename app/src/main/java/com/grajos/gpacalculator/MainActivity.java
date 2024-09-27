package com.grajos.gpacalculator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText credit, grade;
    private TextView result,currentBatch;
    double counter=0,total_credit=0,singleCredit=0,singleGrade=0,gcounter=0,gtotal_credit=0,gsingleCredit=0,gsingleGrade=0;
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        credit = findViewById(R.id.credit);
        grade = findViewById(R.id.grade);
        Button add = findViewById(R.id.add);
        Button erase = findViewById(R.id.erase);
        Button compute = findViewById(R.id.compute);
        result = findViewById(R.id.result);
        currentBatch = findViewById(R.id.current_batch);

        add.setOnClickListener(view -> {
            if (credit.getText().toString().isEmpty() || grade.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Empty fields.", Toast.LENGTH_LONG).show();
            } else {
                try {
                    singleCredit = Double.parseDouble(credit.getText().toString());
                    gsingleCredit = Double.parseDouble(credit.getText().toString());
                    singleGrade = Double.parseDouble(grade.getText().toString());
                    gsingleGrade = Double.parseDouble(grade.getText().toString());

                    counter += (singleGrade * singleCredit);
                    gcounter += (singleGrade * singleCredit);
                    total_credit += singleCredit;
                    gtotal_credit += singleCredit;

                    Toast.makeText(getApplicationContext(), "credit: " + singleCredit + "\ngrade: " + singleGrade, Toast.LENGTH_LONG).show();

                    credit.setText("");
                    grade.setText("");
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Please enter valid numbers", Toast.LENGTH_LONG).show();
                }
            }
        });


        compute.setOnClickListener(view -> {
            double res = counter/total_credit;
            double gres = gcounter/gtotal_credit;
            result.setText(String.format("%.2f",res));
            currentBatch.setText(String.format("%.2f", gres));

            // Hide the keyboard
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }

            gcounter=0;
            gtotal_credit=0;
            gsingleCredit=0;
            gsingleGrade=0;
        });
        erase.setOnClickListener(view -> {
            counter=0;
            total_credit=0;
            singleCredit=0;
            singleGrade=0;
            gcounter=0;
            gtotal_credit=0;
            gsingleCredit=0;
            gsingleGrade=0;
            credit.setText("");
            grade.setText("");
            result.setText("");
            currentBatch.setText("");
        });


    }
}