package com.sample.calculator;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.util.logging.ConsoleHandler;


public class MainActivity extends ActionBarActivity {

    Button btnAdd, btnSub, btnMul, btnDiv, btnPow, btnClear;
    EditText tvField1, tvField2;
    char operator = '+';
    Double result = 0.;

    protected void calculate(double a){
        switch(operator)
        {
            case '+': result+=a; break;
            case '-': result-=a; break;
            case '*': result*=a; break;
            case '/': result/=a; break;
            case '^': result = Math.pow(result, a);
        }
        Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button)findViewById((R.id.btnAdd));
        btnSub = (Button)findViewById((R.id.btnSub));
        btnMul = (Button)findViewById((R.id.btnMul));
        btnDiv = (Button)findViewById((R.id.btnDiv));
        btnPow = (Button)findViewById((R.id.btnPow));
        btnClear = (Button)findViewById((R.id.btnClear));

        tvField1 = (EditText)findViewById(R.id.tvField1);
        tvField2 = (EditText)findViewById(R.id.tvField2);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = Double.parseDouble(tvField1.getText().toString().equals("")?"0":tvField1.getText().toString());
                operator='+';
                calculate(Double.parseDouble(tvField2.getText().toString().equals("")?"0":tvField2.getText().toString()));
                tvField1.setText(result.toString());
                tvField2.setText("");
                result = 0.;
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = Double.parseDouble(tvField1.getText().toString().equals("")?"0":tvField1.getText().toString());
                operator='-';
                calculate(Double.parseDouble(tvField2.getText().toString().equals("")?"0":tvField2.getText().toString()));
                tvField1.setText(result.toString());
                tvField2.setText("");
                result = 0.;
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = Double.parseDouble(tvField1.getText().toString().equals("")?"0":tvField1.getText().toString());
                operator='*';
                calculate(Double.parseDouble(tvField2.getText().toString().equals("")?"0":tvField2.getText().toString()));
                tvField1.setText(result.toString());
                tvField2.setText("");
                result = 0.;
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = Double.parseDouble(tvField1.getText().toString().equals("")?"0":tvField1.getText().toString());
                operator='/';
                calculate(Double.parseDouble(tvField2.getText().toString().equals("")?"0":tvField2.getText().toString()));
                tvField1.setText(result.toString());
                tvField2.setText("");
                result = 0.;
            }
        });
        btnPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = Double.parseDouble(tvField1.getText().toString().equals("")?"0":tvField1.getText().toString());
                operator='^';
                calculate(Double.parseDouble(tvField2.getText().toString().equals("")?"0":tvField2.getText().toString()));
                tvField1.setText(result.toString());
                tvField2.setText("");
                result = 0.;
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = 0.;
                operator='0';
                tvField1.setText("");
                tvField2.setText("");
                result = 0.;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
