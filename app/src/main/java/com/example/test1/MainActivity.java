package com.example.test1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test1.Model.Drink;
import com.example.test1.Model.DrinksMockup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    Spinner spinner;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        setSpinner();

    }

    private void setSpinner() {
        //this to give the spinner its items without the need of xml
        DrinksMockup drinksMockup = new DrinksMockup();
        String[] cat = drinksMockup.getCategories();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,cat);
        spinner.setAdapter(arrayAdapter);
    }

    private void setViews() {
        spinner = findViewById(R.id.select);
        editText = findViewById(R.id.textArea);
    }
    public void btnSubmit_Click(View view){
        String drink = spinner.getSelectedItem().toString();
        editText.setText(drink);
        DrinksMockup database = new DrinksMockup();
        ArrayList<Drink> result = database.getDrinks(drink);
        String str = "";
        for(Drink d : result){
            str+= d.getName()+" price:"+d.getUnitPrice()+"\n";
        }
        editText.setText(str);
    }


}