package com.github.shyam0507.appvisitcounter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String NUMBER_OF_RESTART = "restart_count";
    int restartCount;
    TextView appVisitView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appVisitView = (TextView) findViewById(R.id.appVisitView);

        //get the  Shared Preference
        SharedPreferences sharedPreferences = getSharedPreferences("my_preference", Context.MODE_PRIVATE);
        restartCount = sharedPreferences.getInt(NUMBER_OF_RESTART, 0);//get the value if user is visiting for the first time then it will return 0 -default value

        if (restartCount == 0) {//if first time user show a greeting toast
            Toast.makeText(this, "Welcome to my app.", Toast.LENGTH_LONG).show();
        }

        int currentCount = restartCount + 1;//add 1 to the previous visit count

        //now add the number of restart times
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(NUMBER_OF_RESTART, currentCount);
        editor.commit();//commit the editor

        //now show the visit counter in the text view
        appVisitView.setText("Visit Counter: " + currentCount);

    }
}
