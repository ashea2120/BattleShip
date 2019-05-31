package BattleShip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import BattleShip.AdapterBoard;
import BattleShip.Cell;
import BattleShip.Game;
import team2.BattleShip.R;

/**
 * android activity for game play
 *
 */
public class MainActivity extends AppCompatActivity {
    private int numCellsBoardSide;
    private TextView textViewGameStage, textViewMessage;
    private Button buttonAttack, buttonUpgrade, buttonRestart;
    private GridView gridViewBoard1, gridViewBoard2;
    private AdapterBoard adapterBoard1, adapterBoard2;
    private String gameState;
    private Button turnOver;

    /**
     * passes variables to class Game and initializes game
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null)
        {
            //gameState = savedInstanceState.getString(text_view_message);
        }
        else
        {

            setContentView(R.layout.main_activity);
            setFields();
            enableGame();
            turnOver = (Button)findViewById(R.id.button_turn_over);
            turnOver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,
                            Transition.class);
                    //intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                    startActivity(intent);
                }
            });
        }
    }

    private void enableGame() {
        Game game = Game.getInstance();
        game.setFields(this, numCellsBoardSide, textViewGameStage, textViewMessage,
                buttonAttack, buttonUpgrade, buttonRestart,
                gridViewBoard1, gridViewBoard2, adapterBoard1, adapterBoard2);
        game.initialize();
    }

    private void setFields() {
        numCellsBoardSide = getResources().getInteger(R.integer.num_cells_board_side);
        textViewGameStage = (TextView) findViewById(R.id.text_view_game_stage);
        textViewMessage = (TextView) findViewById(R.id.text_view_message);
        buttonRestart = (Button) findViewById(R.id.button_initialize);
        buttonAttack = (Button) findViewById(R.id.button_attack);
        buttonUpgrade = (Button) findViewById(R.id.button_upgrade);
        gridViewBoard1 = (GridView) findViewById(R.id.gridViewBoard1);
        gridViewBoard2 = (GridView) findViewById(R.id.gridViewBoard2);
        adapterBoard1 = new AdapterBoard(this, new ArrayList<Cell>());
        adapterBoard2 = new AdapterBoard(this, new ArrayList<Cell>());
    }


    public void turnOver(View view) {
        //preserve the state of main
        Intent transitionIntent = new Intent(this, Transition.class);
        startActivity(transitionIntent);
    }

    // This callback is called only when there is a saved instance that is previously saved by using
    // onSaveInstanceState(). We restore some state in onCreate(), while we can optionally restore
    // other state here, possibly usable after onStart() has completed.
    // The savedInstanceState Bundle is same as the one used in onCreate().
    /*@Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        //textView.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }*/


}
