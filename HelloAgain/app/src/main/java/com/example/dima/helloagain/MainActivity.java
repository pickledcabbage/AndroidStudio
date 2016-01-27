package com.example.dima.helloagain;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView firstTextView = (TextView)findViewById(R.id.textView);
        final Button firstButton = (Button)findViewById(R.id.button);
        final NumberValue NV = new NumberValue(0);
        firstButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                NV.increment();
                firstTextView.setText("You have clicked " + NV.getNumber() + " time(s)!");
            }
        });
        Button secondButton = (Button)findViewById(R.id.button2);
        secondButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                firstTextView.setText("The highest value is " + NV.getNumber());
                NV.setNumber(0);
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
