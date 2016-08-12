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
    private View.OnClickListener oclBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oclBtn = new View.OnClickListener() {
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
        initVars();
        draw();
    }

    private void restart() {
        gameLogic.restart();
        draw();
    }

    private void initVars() {
        b00 = (Button) findViewById(R.id.b00);
        b00.setOnClickListener(oclBtn);
        b10 = (Button) findViewById(R.id.b10);
        b10.setOnClickListener(oclBtn);
        b20 = (Button) findViewById(R.id.b20);
        b20.setOnClickListener(oclBtn);
        b01 = (Button) findViewById(R.id.b01);
        b01.setOnClickListener(oclBtn);
        b11 = (Button) findViewById(R.id.b11);
        b11.setOnClickListener(oclBtn);
        b21 = (Button) findViewById(R.id.b21);
        b21.setOnClickListener(oclBtn);
        b02 = (Button) findViewById(R.id.b02);
        b02.setOnClickListener(oclBtn);
        b12 = (Button) findViewById(R.id.b12);
        b12.setOnClickListener(oclBtn);
        b22 = (Button) findViewById(R.id.b22);
        b22.setOnClickListener(oclBtn);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(oclBtn);
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
        if(grid.getContent(x, y) == 'e') b.setText("");
        else b.setText(String.valueOf(grid.getContent(x, y)));
        //if (gameLogic.isWon(x, y)) b.setBackgroundColor(Color.RED);
    }
}
