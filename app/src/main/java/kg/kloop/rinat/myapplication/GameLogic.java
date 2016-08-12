package kg.kloop.rinat.myapplication;

/**
 * Класс содержит логику игры XO.
 */
public class GameLogic {

    /**
     * Задает переменную grid, выводит сообщение, кто ходит.
     * @param grid состояние игры
     */
    public GameLogic(GameGrid grid) {
        this.grid = grid;
        restart();
    }

    public void restart() {
        grid.reset();
        grid.setMessage("It is now turn of X");
        active = true;
        winner = ' ';
    }

    public void press(int x, int y) {
        if (isActive()){
            if (grid.getContent(x, y) == 'e'){
                if(grid.getTurn() == 'x') {
                    grid.setContent(x, y, 'x');
                    grid.setTurn('o');
                    grid.setMessage("This now turn of O");
                } else if (grid.getTurn() == 'o'){
                    grid.setContent(x, y, 'o');
                    grid.setTurn('x');
                    grid.setMessage("This now turn of X");
                }
            }

            if (isVictory()){
                active = false;
                grid.setMessage("The winner is " + winner);

            }
        }
    }

    private boolean isActive() {
        return active;
    }

    private boolean isVictory(){
        boolean result = false;
        if (grid.getContent(0, 0) == 'x' && grid.getContent(1, 0) == 'x' && grid.getContent(2, 0) == 'x'){
            grid.setContent(0, 0, 'X');
            grid.setContent(1, 0, 'X');
            grid.setContent(2, 0, 'X');
            winner = 'x';
            result = true;
        }
        return result;
    }


    private boolean active;
    private GameGrid grid;
    private char winner;

}