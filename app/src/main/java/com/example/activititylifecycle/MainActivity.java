package com.example.activititylifecycle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    /* Android Life Cycle refers to the sequence of events that
    * occur as an Activity transitions through different states.
    *
    * Activities are fundamental building blocks of Android applications,
    * representing screens with user interfaces.
    *
    * Understanding the activity lifecycle is crucial for managing
    * the behavior and resources of your app effectively.
    *
    * The activity lifecycle consists of several key methods
    * that are called at different stages of an activities
    * such as:-
    * ~ onCreate
    * ~ onStart
    * ~ onResume
    * ~ onPause
    * ~ onStop
    * ~ onRestart
    * ~ onDestroy*/


//    First method called when Activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Initialize UI Elements and variables here

        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.google_btn);
        Button button2 = findViewById(R.id.other_btn);
        Toast.makeText(
                MainActivity.this,
                "OnCreate() is called",
                Toast.LENGTH_SHORT).show();

        button1.setOnClickListener(v->{
            openWebpage();
        });

        button2.setOnClickListener(v->{
            openAnotherActivity();
        });
    }

/*Called when Activity is visible to the user,
    but not yet interactive*/
    @Override
    protected void onStart() {
        super.onStart();
//        Good place to start animations or other UI related tasks

        Toast.makeText(
                MainActivity.this,
                "OnStart() is called",
                Toast.LENGTH_SHORT).show();

    }

//    Called when Activity is in foreground and ready for user interaction
    @Override
    protected void onResume() {
        super.onResume();
//    You can start components that need to be actively running,
//    such as sensors and location updates

        Toast.makeText(
                MainActivity.this,
                "OnResume() is called",
                Toast.LENGTH_SHORT).show();



    }

/* Called when the Activity is about to lose focus,
    typically another Activity is stating or the device
    is going into a multi-window mode.*/

    @Override
    protected void onPause() {
        super.onPause();

//   release resources or pose ongoing operations.

        Toast.makeText(
                MainActivity.this,
                "OnPause() is called",
                Toast.LENGTH_SHORT).show();

    }

//    Called when the Activity is no longer visible to the user
    @Override
    protected void onStop() {
        super.onStop();

//    release resources that are no longer needed, save data

        Toast.makeText(
                MainActivity.this,
                "OnStop() is called",
                Toast.LENGTH_SHORT).show();
    }

/*Called when the Activity is restarting after being stopped,
    followed by onStart method*/
    @Override
    protected void onRestart() {
        super.onRestart();

//  Perform any necessary restart tasks here

        Toast.makeText(
                MainActivity.this,
                "OnRestart() is called",
                Toast.LENGTH_SHORT).show();

    }

//    Called when the Activity is being destroyed
    @Override
    protected void onDestroy() {
        super.onDestroy();

//   clean up resources and perform final tasks

        Toast.makeText(
                MainActivity.this,
                "OnDestroy() is called",
                Toast.LENGTH_SHORT).show();
    }

//    Implicit intent
    public void openWebpage(){
        Uri webpage = Uri.parse("https://www.google.com");

        Intent intent = new Intent(Intent.ACTION_VIEW,webpage);

        startActivity(intent);
    }

//    Explicit intent
    public void openAnotherActivity(){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}