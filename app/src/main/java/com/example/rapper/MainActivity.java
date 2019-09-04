package com.example.rapper;

//import statements
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

//main activity
public class MainActivity extends AppCompatActivity {

    //a testing variable
    static TextView r1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //identifying the textview to manipulate
        r1=(TextView) findViewById(R.id.appTitle);
    }


}
