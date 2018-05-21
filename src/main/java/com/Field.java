package com;


public class Field {

    private Player[][] data;
    private Player gamer = Player.X;
    private Player winner = null;

    // Проверка на размер поля. Поле не должно быть меньше минимального размера
    public Field(int height, int width) {
        if (height < Constants.MIN_SIZE)
            throw new IllegalArgumentException("height");

        if (width < Constants.MIN_SIZE)
            throw new IllegalArgumentException("width");

        data = new Player[height][width];
    }

    // Полю присваивается размер
    public Field() {
        this(Constants.DEFAULT_SIZE, Constants.DEFAULT_SIZE);
    }

    // Добавляется ряд
    public void addRow() {
        Player[][] replace = new Player[this.getHeight() + 1][];

        for (int i = 0; i < data.length; i++)
            replace[i] = data[i];

        replace[replace.length - 1] = new Player[this.getWidth()];

        data = replace;
    }

    // Удаляется ряд
    public void insertRow() {
        Player[][] replace = new Player[this.getHeight() + 1][];

        replace[0] = new Player[this.getWidth()];

        for (int i = 0; i < data.length; i++)
            replace[i + 1] = data[i];

        data = replace;
    }

    // Добавляется столбик
    public void addColumn() {
        Player[][] replace = new Player[this.getHeight()][this.getWidth() + 1];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < this.getWidth(); j++)
                replace[i][j] = data[i][j];
        }

        data = replace;
    }

    //Удаляется столбик
    public void insertColumn() {
        Player[][] replace = new Player[this.getHeight()][this.getWidth() + 1];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < this.getWidth(); j++)
                replace[i][j + 1] = data[i][j];
        }

        data = replace;
    }

    public Player getGamer() {
        return gamer;
    }

    public Player getWinner() {
        return winner;
    }

    public int getHeight() {
        return this.data.length;
    }

    public int getWidth() {
        return this.data[0].length;
    }

    //Сброс, возвращение на первоначальный этап
    public void reset() {
        gamer = Player.X;
        winner = null;

        data = new Player[Constants.DEFAULT_SIZE][Constants.DEFAULT_SIZE];

    }

    public Player get(int x, int y) {
        return this.data[y][x];
    }


    public void set(int x, int y, Player value) {
        this.data[y][x] = value;
    }

    //Смена игрока
    public void set(int x, int y) {
        if (get(x, y) != null)
            return;

        set(x, y, gamer);
        if (searchWinner(x, y))
            winner = gamer;
        else {
            if (gamer == Player.X)
                gamer = Player.O;
            else if (gamer == Player.O)
                gamer = Player.X;
        }
    }

    // Победитель по горизонтали
    private boolean searchHorizontal(int x, int y, int minx, int maxx) {
        Player current = get(x, y);
        int counter = 1;
        for (int i = x - 1; i >= minx; i--) {
            if (current.equals(get(i, y)))
                counter++;
            else
                break;
        }

        for (int i = x + 1; i <= maxx; i++) {
            if (current.equals(get(i, y)))
                counter++;
            else
                break;
        }

        return counter >= Constants.MIN_SIZE;
    }

    // Победитель по вертикали
    private boolean searchVertical(int x, int y, int miny, int maxy) {
        Player current = get(x, y);
        int counter = 1;
        for (int i = y - 1; i >= miny; i--) {
            if (current.equals(get(x, i)))
                counter++;
            else
                break;
        }

        for (int i = y + 1; i <= maxy; i++) {
            if (current.equals(get(x, i)))
                counter++;
            else
                break;
        }

        return counter >= Constants.MIN_SIZE;
    }

    // Победитель слева на право
    private boolean searchXY(int x, int y, int minx, int miny, int maxx, int maxy) {
        Player current = get(x, y);
        int counter = 1;

        for (int i = x - 1, j = y - 1; i >= minx && j >= miny; i--, j--) {
            if (current.equals(get(i, j)))
                counter++;
            else
                break;
        }

        for (int i = x + 1, j = y + 1; i <= maxx && j <= maxy; i++, j++) {
            if (current.equals(get(i, j)))
                counter++;
            else
                break;
        }

        return counter >= Constants.MIN_SIZE;
    }

    // Победитель справо на лево
    private boolean searchYX(int x, int y, int minx, int miny, int maxx, int maxy) {
        Player current = get(x, y);
        int counter = 1;

        for (int i = x - 1, j = y + 1; i >= minx && j <= maxy; i--, j++) {
            if (current.equals(get(i, j)))
                counter++;
            else
                break;
        }

        for (int i = x + 1, j = y - 1; i <= maxx && j >= miny; i++, j--) {
            if (current.equals(get(i, j)))
                counter++;
            else
                break;
        }

        return counter >= Constants.MIN_SIZE;
    }

    private boolean searchWinner(int x, int y) {
        int minx = Math.max(0, x - Constants.MIN_SIZE);
        int maxx = Math.min(x + Constants.MIN_SIZE, this.getWidth() - 1);
        int miny = Math.max(0, y - Constants.MIN_SIZE);
        int maxy = Math.min(y + Constants.MIN_SIZE, this.getHeight() - 1);

        return searchHorizontal(x, y, minx, maxx) || searchVertical(x, y, miny, maxy)
                || searchXY(x, y, minx, miny, maxx, maxy) || searchYX(x, y, minx, miny, maxx, maxy);
    }
}
