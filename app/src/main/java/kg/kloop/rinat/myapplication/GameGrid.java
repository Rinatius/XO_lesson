package kg.kloop.rinat.myapplication;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Этот класс хранит информацию о состоянии игры "XO",
 * в частности состояние поля, чей ход, и все послания
 * игрокам.
 */
public class GameGrid {

    /**
     * Конструктор инициализирует массив и заполняет его 'e',
     * назначает ход крестикам.
     */
    public GameGrid(){
        gridArray = new char[3][3];
        reset();
    }

    /**
     * Возвращает содержимое клетки в массиве.
     * @param x координата по оси x, min - 0, max - 2
     * @param y координата по оси y, min - 0, max - 2
     * @return значение из массива: x, o, X, O, e.
     * Большие буквы для выигрышной комбинации.
     * e для пустых клеток.
     */
    public char getContent(int x, int y) {
        return gridArray[x][y];
    }

    /**
     * Записывет содержимое клетки в массиве.
     * @param x координата по оси x, min - 0, max - 2
     * @param y координата по оси н, min - 0, max - 2
     * @param symbol значение из массива: x, o, X, O, e.
     * Большие буквы для выигрышной комбинации.
     * e для пустых клеток.
     */
    public void setContent(int x, int y, char symbol){
        gridArray[x][y] = symbol;
    }

    /**
     * Текущее послание игрокам.
     * @return возвращает текущее послание.
     */
    public String getMessage() {
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }


    public void reset() {
        Arrays.fill(gridArray[0], 'e');
        Arrays.fill(gridArray[1], 'e');
        Arrays.fill(gridArray[2], 'e');
        turn = 'x';
        message = "";
    }

    public char getTurn() {
        return turn;
    }

    public void setTurn(char turn) {
        this.turn = turn;
    }

    public char[][] getArray() {
        return gridArray;
    }

    private char[][] gridArray;
    private char turn;
    private String message;



}
