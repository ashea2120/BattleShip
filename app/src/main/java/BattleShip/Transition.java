package BattleShip;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import team2.BattleShip.R;

/**
 * Transition activity between passing the board between players
 */
public class Transition extends AppCompatActivity{

    public TextView switchText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        switchText = (TextView)findViewById(R.id.switchplayer);
        //simple if to switch between the character
        switchText.setText("Please hand the device to the other player.");
    }

    public Transition() {

    }

    public void doneSwitching(View view) {
        setContentView(R.layout.main_activity);
    }
}
