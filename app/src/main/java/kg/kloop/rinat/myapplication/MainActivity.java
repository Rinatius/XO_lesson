package kg.kloop.rinat.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b00;
    Button b10;
    Button b20;
    Button b01;
    Button b11;
    Button b21;
    Button b02;
    Button b12;
    Button b22;
    TextView textView;
    Button button;
    GameGrid grid;
    GameLogic gameLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVars();

        View.OnClickListener oclBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.b00:
                        update(0, 0);
                        break;
                    case R.id.b10:
                        update(1, 0);
                        break;
                    case R.id.b20:
                        update(2, 0);
                        break;
                    case R.id.b01:
                        update(0, 1);
                        break;
                    case R.id.b11:
                        update(1, 1);
                        break;
                    case R.id.b21:
                        update(2, 1);
                        break;
                    case R.id.b02:
                        update(0, 2);
                        break;
                    case R.id.b12:
                        update(1, 2);
                        break;
                    case R.id.b22:
                        update(2, 2);
                        break;
                    case R.id.button:
                        restart();
                        break;
                }

            }


        };
    }

    private void restart() {
        gameLogic.restart();
        draw();
    }

    private void initVars() {
        b00 = (Button) findViewById(R.id.b00);
        b10 = (Button) findViewById(R.id.b10);
        b20 = (Button) findViewById(R.id.b20);
        b01 = (Button) findViewById(R.id.b01);
        b11 = (Button) findViewById(R.id.b11);
        b21 = (Button) findViewById(R.id.b21);
        b02 = (Button) findViewById(R.id.b02);
        b12 = (Button) findViewById(R.id.b12);
        b22 = (Button) findViewById(R.id.b22);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        grid = new GameGrid();
        gameLogic = new GameLogic(grid);
    }

    private void update(int x, int y) {
        gameLogic.press(x, y);
        draw();
        textView.setText(grid.getMessage());
    }

    private void draw(){
        drawButton(b00, 0, 0);
        drawButton(b10, 1, 0);
        drawButton(b20, 2, 0);
        drawButton(b01, 0, 1);
        drawButton(b11, 1, 1);
        drawButton(b21, 2, 1);
        drawButton(b02, 0, 2);
        drawButton(b12, 1, 2);
        drawButton(b22, 2, 2);
    }

    private void drawButton(Button b, int x, int y) {
        b.setText(grid.getContent(x, y));
        if (grid.isWon(x, y)) b.setBackgroundColor(Color.RED);
    }
}
