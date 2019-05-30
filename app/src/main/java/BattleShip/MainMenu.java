package team2.BattleShip;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Paul
 */
public class MainMenu extends AppCompatActivity implements View.OnClickListener {
    Button button1;
    Button button11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        button1 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button11 = (Button) findViewById(R.id.button5);
        button11.setOnClickListener(this);
        //Setting custom font
        //TextView tx = (TextView)findViewById(R.id.title_textview);
        //Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/MachineStd.otf");
        //tx.setTypeface(custom_font);
    }

    private void button2Click() {
        startActivity(new Intent("team2.shattlebip.MainActivity"));
    }

    private void button5Click() {
        startActivity(new Intent("team2.shattlebip.Credits"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                button2Click();
                break;

            case R.id.button5:
                button5Click();
                break;
        }
    }
}
