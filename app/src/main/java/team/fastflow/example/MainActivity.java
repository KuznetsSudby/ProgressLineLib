package team.fastflow.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import team.fastflow.kusu.ui.Models.State;
import team.fastflow.kusu.ui.Views.ProgressLine;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ProgressLine progressLine = (ProgressLine) findViewById(R.id.stepper);
        findViewById(R.id.buttonBad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressLine.nextStep(State.BAD);
            }
        });

        findViewById(R.id.buttonGood).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressLine.nextStep(State.GOOD);
            }
        });
    }
}
