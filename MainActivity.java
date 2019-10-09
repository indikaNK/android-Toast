package com.example.simpletoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //properties
    private EditText password;
    private Button btnRevealPass;

    //add the checkboxes
    private CheckBox checkbox1,checkbox2,checkbox3;
    private Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButtonAction(); //use the method
        addListnerOnBtnCheck();//use method for button check
        addListnerToCheckBox();//method for dynamic toast


    }
    //create a method for button click action
    public void addButtonAction(){

        //cast items in activity main
        password = (EditText)findViewById(R.id.etPass);
        btnRevealPass = (Button)findViewById(R.id.btnSubmit);

        //set on click listner to the button
        btnRevealPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        MainActivity.this ,password.getText(),
                        Toast.LENGTH_LONG //toast disaspear after 3,5s
                ).show();
            }
        });
    }



    //create method for button check @checkbox menu
    public void addListnerOnBtnCheck(){

        //casting
        checkbox1 = (CheckBox)findViewById(R.id.chboxVeg);
        checkbox2 = (CheckBox)findViewById(R.id.chboxNonveg);
        checkbox3 = (CheckBox)findViewById(R.id.chboxSea);
        btnCheck = (Button)findViewById(R.id.btnCheck);

        btnCheck.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //create a String buffer so that we can manipulate it by methods
                        StringBuffer result = new StringBuffer();

                        result.append("Vegetarian :").append(checkbox1.isChecked());
                        result.append("\nNon - Vegetarian :").append(checkbox2.isChecked());
                        result.append("\nSeafood only :").append(checkbox3.isChecked());

                        //toast
                        Toast.makeText(
                                MainActivity.this,result,
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        );
    }


    //add listner to checkbox it self
    public void addListnerToCheckBox(){


        checkbox1 = (CheckBox)findViewById(R.id.chboxVeg);
        checkbox2 = (CheckBox)findViewById(R.id.chboxNonveg);
        checkbox3 = (CheckBox)findViewById(R.id.chboxSea);

        checkbox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkbox1.isChecked()) {
                    Toast.makeText(
                            MainActivity.this,
                            "vegetarian Selected",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });

        checkbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkbox2.isChecked()) {
                    Toast.makeText(
                            MainActivity.this,
                            "non - vegetarian Selected",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });

        checkbox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkbox3.isChecked()) {
                    Toast.makeText(
                            MainActivity.this,
                            "Sea food Selected",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });




            }


}
