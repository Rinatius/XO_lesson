package kg.kloop.rinat.myapplication;

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

    }

    /**
     * Возвращает содержимое клетки в массиве.
     * @param x координата по оси x, min - 0, max - 2
     * @param y координата по оси y, min - 0, max - 2
     * @return значение из массива: x, y, X, Y, e.
     * Большие буквы для выигрышной комбинации.
     * e для пустых клеток.
     */
    public char getContent(int x, int y) {
        return 'x';
    }

    /**
     * Проверка клетки на то, что она находится выигрышной строке.
     * @param x координата по оси x, min - 0, max - 2
     * @param y координата по оси y, min - 0, max - 2
     * @return Возвращает true, если клетка находится по выигрышной строке.
     */
    public boolean isWon(int x, int y) {
        return false;
    }

    /**
     * Текущее послание игрокам.
     * @return возвращает текущее послание.
     */
    public String getMessage() {
        return message;
    }

    char[][] gridArray;
    char turn;
    String message;


}
