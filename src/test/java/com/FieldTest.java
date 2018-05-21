package com;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FieldTest {

        /*  1.Создание поля.
            2. Смена игрока при выполненении хода: в начале игрок Х, после вызова set стал О
            3. Разные варианты победы. Варианты не только по направлениям, но и по расположению
            победившего хода: в начале линии, в конце линии, в середине линии
            4.Проверка на добавление/удаление колонок и строк (реализация бесконечного поля)
    */
        @Test
        public void testFieldCreate() {
            Field fld = new Field(14, 12);

            assertEquals(14, fld.getHeight());
            assertEquals(12, fld.getWidth());

            fld.set(10, 10, Player.X);

            assertEquals(Player.X, fld.get(10, 10));
            assertEquals(null, fld.get(0, 1));
        }

        @Test
        public void playerChange() {
            Field fld = new Field(10, 10);
            //Если X действительно сменяется на О, то первый игрок X, а второй O
            fld.set(8, 9);//X
            fld.set(4, 5);// предположительно O

            assertEquals(Player.X, fld.get(8, 9));
            assertEquals(Player.O, fld.get(4, 5));
        }

        @Test
        public void horizontalWinnerInTheBeginningOfTheField() {
            Field fld = new Field(15, 15);

            fld.set(0, 0);
            fld.set(1, 3);
            fld.set(1, 0);
            fld.set(1, 1);
            fld.set(2, 0);
            fld.set(4, 4);
            fld.set(3, 0);
            fld.set(4, 1);
            fld.set(4, 0);

            assertEquals(Player.X, fld.getWinner());

        }

        @Test
        public void verticalWinnerAtTheBeginningOfTheField() {
            Field fld = new Field(15, 15);

            fld.set(0, 0);
            fld.set(1, 3);
            fld.set(0, 1);
            fld.set(1, 1);
            fld.set(0, 2);
            fld.set(4, 4);
            fld.set(0, 3);
            fld.set(4, 1);
            fld.set(0, 4);

            assertEquals(Player.X, fld.getWinner());
        }

        @Test
        public void diagonalLeftToRightWinnerAtTheBeginningOfTheField() {
            Field fld = new Field(15, 15);

            fld.set(0, 0);
            fld.set(1, 3);
            fld.set(1, 1);
            fld.set(1, 0);
            fld.set(2, 2);
            fld.set(4, 2);
            fld.set(3, 3);
            fld.set(4, 1);
            fld.set(4, 4);

            assertEquals(Player.X, fld.getWinner());
        }

        @Test
        public void diagonalRightToLeftWinnerAtTheBeginningOfTheField() {
            Field fld = new Field(15, 15);

            fld.set(0, 4);
            fld.set(1, 2);
            fld.set(1, 3);
            fld.set(1, 0);
            fld.set(2, 2);
            fld.set(4, 2);
            fld.set(3, 1);
            fld.set(4, 1);
            fld.set(4, 0);

            assertEquals(Player.X, fld.getWinner());
        }

        @Test
        public void horizontalWinnerInTheMiddleOfTheField() {
            Field fld = new Field(15, 15);

            fld.set(8, 8);
            fld.set(9, 3);
            fld.set(8, 9);
            fld.set(6, 9);
            fld.set(8, 10);
            fld.set(7, 4);
            fld.set(8, 11);
            fld.set(6, 2);
            fld.set(8, 12);

            assertEquals(Player.X, fld.getWinner());
        }

        @Test
        public void verticalWinnerAtTheMiddleOfTheField() {
            Field fld = new Field(15, 15);

            fld.set(8, 8);
            fld.set(11, 3);
            fld.set(9, 8);
            fld.set(10, 1);
            fld.set(10, 8);
            fld.set(9, 4);
            fld.set(11, 8);
            fld.set(8, 1);
            fld.set(12, 8);

            assertEquals(Player.X, fld.getWinner());
        }

        @Test
        public void diagonalLeftToRightWinnerAtTheMiddleOfTheField() {
            Field fld = new Field(15, 15);

            fld.set(8, 8);
            fld.set(8, 3);
            fld.set(9, 9);
            fld.set(12, 0);
            fld.set(10, 10);
            fld.set(10, 8);
            fld.set(11, 11);
            fld.set(9, 8);
            fld.set(12, 12);

            assertEquals(Player.X, fld.getWinner());
        }

        @Test
        public void diagonalRightToLeftWinnerAtTheMiddleOfTheField() {
            Field fld = new Field(15, 15);

            fld.set(3, 8);
            fld.set(0, 0);
            fld.set(4, 7);
            fld.set(0, 1);
            fld.set(5, 6);
            fld.set(4, 2);
            fld.set(6, 5);
            fld.set(10, 8);
            fld.set(7, 4);

            assertEquals(Player.X, fld.getWinner());
        }

        @Test
        public void horizontalWinnerAtTheEndOfTheField() {
            Field fld = new Field(15, 15);

            fld.set(14, 14);
            fld.set(10, 10);
            fld.set(13, 14);
            fld.set(12, 8);
            fld.set(12, 14);
            fld.set(12, 10);
            fld.set(11, 14);
            fld.set(13, 11);
            fld.set(10, 14);

            assertEquals(Player.X, fld.getWinner());

        }

        @Test
        public void verticalWinnerAtTheEndOfTheField() {
            Field fld = new Field(15, 15);

            fld.set(14, 14);
            fld.set(10, 10);
            fld.set(14, 13);
            fld.set(12, 8);
            fld.set(14, 12);
            fld.set(12, 10);
            fld.set(14, 11);
            fld.set(13, 11);
            fld.set(14, 10);

            assertEquals(Player.X, fld.getWinner());
        }

        @Test
        public void diagonalLeftToRightWinnerAtTheEndOfTheField() {
            Field fld = new Field(15, 15);

            fld.set(14, 14);
            fld.set(10, 11);
            fld.set(13, 13);
            fld.set(12, 9);
            fld.set(12, 12);
            fld.set(10, 8);
            fld.set(11, 11);
            fld.set(9, 8);
            fld.set(10, 10);

            assertEquals(Player.X, fld.getWinner());
        }

        @Test
        public void diagonalRightToLeftWinnerAtTheEndOfTheField() {
            Field fld = new Field(15, 15);

            fld.set(10, 14);
            fld.set(9, 9);
            fld.set(11, 13);
            fld.set(10, 1);
            fld.set(12, 12);
            fld.set(4, 2);
            fld.set(13, 11);
            fld.set(10, 8);
            fld.set(14, 10);

            assertEquals(Player.X, fld.getWinner());
        }


        @Test
        public void testAddRow() {
            Field fld = new Field(14, 12);
            fld.set(2, 4, Player.X);
            fld.addRow();

            assertEquals(Player.X, fld.get(2, 4));
            assertEquals(15, fld.getHeight());
        }

        @Test
        public void testInsertRow() {
            Field fld = new Field(14, 12);
            fld.set(2, 4, Player.X);
            fld.insertRow();

            assertEquals(null, fld.get(2, 4));
            assertEquals(Player.X, fld.get(2, 5));
            assertEquals(15, fld.getHeight());
        }

        @Test
        public void testAddColumn() {
            Field fld = new Field(14, 12);
            fld.set(2, 4, Player.X);
            fld.addColumn();

            assertEquals(Player.X, fld.get(2, 4));
            assertEquals(13, fld.getWidth());
        }

        @Test
        public void testInsertColumn() {
            Field fld = new Field(14, 12);
            fld.set(2, 4, Player.X);
            fld.insertColumn();

            assertEquals(null, fld.get(2, 4));
            assertEquals(Player.X, fld.get(3, 4));
            assertEquals(13, fld.getWidth());
        }


}