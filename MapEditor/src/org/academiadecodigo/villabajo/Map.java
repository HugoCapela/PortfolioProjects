package org.academiadecodigo.villabajo;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.*;

/**
 * Started the exercise with Map and Player classes separated.
 * Later, refactored the structure so Player would be an inner class of Map
 */
public class Map {

    private final int INC = 20;
    private final int INITX = 0;
    private final int INITY = 0;
    private final int PADDING = 10;
    private final int CELL_SIZE = 20;
    /*private Line[] linesX = new Line[20];
    private Line[] linesY = new Line[20];*/
    private int rows = 20;
    private int cols = 20;
    private Rectangle[][] grid = new Rectangle[rows][cols];

    private final Color[] colors = {
            Color.BLACK,
            Color.GREEN,
            Color.BLUE,
            Color.GRAY,
            Color.CYAN,
            Color.DARK_GRAY,
            Color.LIGHT_GRAY,
            Color.MAGENTA,
            Color.ORANGE,
            Color.PINK,
            Color.RED,
            Color.WHITE,
            Color.YELLOW
    };

    private int colorCounter = 0;
    private Color color = Color.BLACK;

    public Map() {

        for( int i = 0; i < rows; i++ ) {
            for( int j = 0; j < cols; j++ ) {
                grid[i][j] = new Rectangle( (PADDING + INITX + (INC * j)), (PADDING + INITY + (INC * i)), CELL_SIZE, CELL_SIZE );
                grid[i][j].setColor(Color.BLACK);
                grid[i][j].draw();
            }
        }
        Player player = new Player();
    }

    public int getWidth() {
        return rows * CELL_SIZE;
    }
    public int getHeight() {
        return cols * CELL_SIZE;
    }

    public class Player implements KeyboardHandler {

        private Rectangle player;

        public Player() {
            player = new Rectangle(10, 10, 20, 20);
            player.setColor(Color.GREEN);
            player.fill();
            keyboardInit();
        }

        public int getCol() {
            return (player.getY() - PADDING) / CELL_SIZE;
        }

        public int getRow() {
            return (player.getX() - PADDING) / CELL_SIZE;
        }

        // Keyboard init
        public void keyboardInit() {

            Keyboard keyboard = new Keyboard(this);

            // Up Key
            KeyboardEvent upPress = new KeyboardEvent();
            upPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            upPress.setKey(KeyboardEvent.KEY_UP);

            // Down Key
            KeyboardEvent downPress = new KeyboardEvent();
            downPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            downPress.setKey(KeyboardEvent.KEY_DOWN);

            // Left Key
            KeyboardEvent leftPress = new KeyboardEvent();
            leftPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            leftPress.setKey(KeyboardEvent.KEY_LEFT);

            // Right Key
            KeyboardEvent rightPress = new KeyboardEvent();
            rightPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            rightPress.setKey(KeyboardEvent.KEY_RIGHT);

            // Space Key -> Paint or Unpaint
            KeyboardEvent spacePress = new KeyboardEvent();
            spacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            spacePress.setKey(KeyboardEvent.KEY_SPACE);

            // C Key -> Clean All
            KeyboardEvent cPress = new KeyboardEvent();
            cPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            cPress.setKey(KeyboardEvent.KEY_C);

            // S Key -> Save drawing
            KeyboardEvent sPress = new KeyboardEvent();
            sPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            sPress.setKey(KeyboardEvent.KEY_S);

            // L Key -> Load last saved drawing
            KeyboardEvent lPress = new KeyboardEvent();
            lPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            lPress.setKey(KeyboardEvent.KEY_L);

            // N Key -> Paint color changes to the next
            KeyboardEvent nPress = new KeyboardEvent();
            nPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            nPress.setKey(KeyboardEvent.KEY_N);

            // Add the events created to be listened by the keyboard
            keyboard.addEventListener(upPress);
            keyboard.addEventListener(downPress);
            keyboard.addEventListener(leftPress);
            keyboard.addEventListener(rightPress);

            keyboard.addEventListener(spacePress);
            keyboard.addEventListener(cPress);

            keyboard.addEventListener(sPress);
            keyboard.addEventListener(lPress);

            keyboard.addEventListener(nPress);

        }

        // Moving the Player inside the "Grid"
        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {
            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_UP:
                    if( player.getY() > CELL_SIZE) {
                        player.translate(0, -CELL_SIZE);
                    }
                    break;

                case KeyboardEvent.KEY_DOWN:
                    if( player.getY() < getHeight() - CELL_SIZE ) {
                        player.translate(0, CELL_SIZE);
                    }
                    break;

                case KeyboardEvent.KEY_LEFT:
                    if( player.getX() > CELL_SIZE ) {
                        player.translate(-CELL_SIZE, 0);
                    }
                    break;

                case KeyboardEvent.KEY_RIGHT:
                    if( player.getX() < getWidth() - CELL_SIZE ) {
                        player.translate(CELL_SIZE, 0);
                    }
                    break;

                case KeyboardEvent.KEY_SPACE:
                    if( grid[ getCol() ][ getRow() ].isFilled()) {
                        unpaint();
                        break;
                    }
                    paint();
                    break;

                case KeyboardEvent.KEY_C:
                    cleanAll();
                    break;

                case KeyboardEvent.KEY_S:
                    try {
                        save();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    break;

                case KeyboardEvent.KEY_L:
                    try {
                        load();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    break;

                case KeyboardEvent.KEY_N:
                    paintColor();
                    break;
            }
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {
            // don't need this
        }

        // paint the cell
        public void paint() {
            /*for( int i = 0; i < rows; i++ ) {
                for( int j = 0; j < cols; j++ ) {
                    if( player.getX() == grid[i][j].getX() && player.getY() == grid[i][j].getY() ) {
                        grid[i][j].fill();
                    }
                }
            }*/
            grid[ getCol() ][ getRow() ].setColor( color );
            grid[ getCol() ][ getRow() ].fill();
        }

        // unpaint the cell
        public void unpaint() {
            /*for( int i = 0; i < rows; i++ ) {
                for( int j = 0; j < cols; j++ ) {
                    if( player.getX() == grid[i][j].getX() && player.getY() == grid[i][j].getY() ) {
                        grid[i][j].draw();
                    }
                }
            }*/
            grid[ getCol() ][ getRow() ].setColor(Color.BLACK);
            grid[ getCol() ][ getRow() ].draw();

        }

        // clean all the cells -> get a new board to paint
        public void cleanAll() {
            for(int i = 0; i < cols; i++) {
                for( int j = 0; j < rows; j++ ) {
                    grid[i][j].setColor(Color.BLACK);
                    grid[i][j].draw();
                }
            }
        }

        // save the drawing into a file
        public void save() throws IOException {

            String separator = ":";
            BufferedWriter bWriter = new BufferedWriter( new FileWriter("positions.txt") );

            for( int i = 0; i < rows; i++ ) {
                for( int j = 0; j < cols; j++ ) {
                    if( grid[i][j].isFilled() ) {
                        bWriter.write(i + separator + j + "\n");
                        // Write the index i and index j of every filled position on the grid separated by : and force next line

                        //bWriter.write(i + separator + j + separator + grid[i][j].getColor() + "\n");
                    }
                }
            }

            bWriter.flush(); // if the buffer is not full, flush will force disk write
            bWriter.close(); // close the stream
        }

        // load the last drawing saved to a file
        public void load() throws IOException {

            cleanAll();

            String line = "";
            BufferedReader bReader = new BufferedReader( new FileReader("positions.txt") );

            Color temp = colors[ (int) Math.floor( Math.random() * 13 ) ];

            // while bReader has next line:
            // read the line
            // split the string
            // fill the grid in that position
            while( (line = bReader.readLine()) != null ) {
                String[] arr = line.split(":");
                grid[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])].setColor( temp );
                grid[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])].fill();
            }

            bReader.close(); // close the stream
        }

        // change the color of the paint
        public Color paintColor() {

            if( colorCounter > 12 ) {
                colorCounter = 0;
            }

            color = colors[colorCounter];
            colorCounter++;
            return color;

        }

    }
}
