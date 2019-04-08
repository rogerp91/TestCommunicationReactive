package com.github.rogerp91.testcommunicationreactive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.rogerp91.tasks_communication.NamesActivity;
import com.github.rogerp91.testcommunicationreactive.data.NamesRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NamesRepository namesRepository = new NamesRepository();
        Intent intent = new Intent(this, NamesActivity.class);
        intent.putExtra("DataSource", namesRepository);
        startActivity(intent);
    }
}
