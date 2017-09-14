package felipe.campominado;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    private Button[][] buttons = new Button[10][10];
    private TextView scoreTextView;
    private AlertDialog endGameDialog;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createGame();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        createGame();
    }

    @Override
    public void onClick(View view) {
        Button button = (Button)view;
        if(button.getText().equals("O")) {
            button.setBackgroundResource(R.mipmap.ic_bomb_field_exploded);
            endGameDialog.show();
        }
        else
        {
            incrementScore();
            button.setBackgroundResource(R.mipmap.ic_bomb_field_ok);
        }
    }

    private void createGame()
    {
        constructField();
        constructDialog();
        constructScore();
    }

    private void constructField()
    {
        for (int c = 0; c < 10; c++)
        {
            for (int r = 0; r < 10; r++)
            {
                Button button = (Button)findViewById(MainActivity.this.getResources()
                        .getIdentifier("field" + c + "" + r, "id", getPackageName()));

                button.setOnClickListener(this);

                button.setTextSize(0);
                button.setText(Math.random() < 0.2 ? "O" : "X");
                button.setHighlightColor(Color.WHITE);
                button.setBackgroundResource(R.mipmap.ic_bomb_field);
                button.setShadowLayer(0,0,0, Color.WHITE);

                buttons[c][r] = button;
            }
        }
    }

    private void constructDialog()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Fim de jogo !");
        alertDialogBuilder.setMessage("Sua pontuação foi de 0 pontos");
        alertDialogBuilder.setNeutralButton("Reiniciar", this);
        alertDialogBuilder.setCancelable(false);

        endGameDialog = alertDialogBuilder.create();
    }

    private void constructScore()
    {
        score = 0;
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        scoreTextView.setText("Pontuação: 0");
    }

    private void incrementScore()
    {
        score++;
        scoreTextView.setText("Pontuação: " + score);
        endGameDialog.setMessage("Sua pontuação foi de " + score + " pontos");
    }
}
