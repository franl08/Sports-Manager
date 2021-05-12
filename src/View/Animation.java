package View;

import java.io.Serializable;
import java.time.Duration;
import java.util.Arrays;

public class Animation implements Serializable
{
    private final static Duration TIC = Duration.ofSeconds(1/10);
    private final static int LINES = 12;
    private final static int COLUMNS = 60;

    private final char[][] screen;
    private final Outputs out;

    public Animation()
    {
        this.screen = new char[Animation.LINES][Animation.COLUMNS];
        for(int i = 0; i < Animation.LINES; i++)
            for(int j = 0; j < Animation.COLUMNS; j++)
                this.screen[i][j] = ' ';
        this.out = new Outputs();
    }

    public void testFrame()
    {
        for(int i = 0; i < Animation.LINES; i++)
        {
            for(int j = 0; j < Animation.COLUMNS; j++)
            {
                this.screen[i][j] = '*';
            }
        }
    }

    public void lastFrame()
    {
        writeFMatrix(0, 0);
        writeOMatrix(0, 7);
        writeOMatrix(0, 15);
        writeTMatrix(0, 22);
    }

    private void writeFMatrix(int x_pos, int y_pos)
    {
        boolean cond = 0 <= x_pos && x_pos < Animation.LINES && (x_pos + 5) < Animation.LINES &&
                0 <= y_pos && y_pos < Animation.COLUMNS && (y_pos + 11) <= Animation.COLUMNS;

        if(cond)
        {
            // First row
            for(int i = y_pos + 5; i < y_pos + 12; i++)
                this.screen[x_pos][i] = '_';

            // Second row
            this.screen[x_pos+1][y_pos+4] = '/';
            for(int i = y_pos+7; i < y_pos +11; i++)
                this.screen[x_pos+1][i] = '_';
            this.screen[x_pos+1][y_pos + 11] = '/';

            // Third row
            this.screen[x_pos+2][y_pos+3] = this.screen[x_pos+2][y_pos+6] = '/';
            for(int i = y_pos+7; i < y_pos + 8; i++)
                this.screen[x_pos+2][i] = '_';

            // Fourth row
            this.screen[x_pos+3][y_pos+2] = '/';
            for(int i = y_pos+5; i < y_pos + 7; i++)
                this.screen[x_pos+3][i] = '_';
            this.screen[x_pos+3][y_pos+7] = '/';

            // Fifth row
            this.screen[x_pos+4][y_pos+1] = this.screen[x_pos+4][y_pos+4] = '/';

            // Sixth row
            this.screen[x_pos+5][y_pos] = this.screen[x_pos+5][y_pos+3] = '/';
            this.screen[x_pos+5][y_pos+1] = this.screen[x_pos+5][y_pos+2] =  '_';
        }
    }

    private void writeOMatrix(int x_pos, int y_pos)
    {
        boolean cond = 0 <= x_pos && x_pos < Animation.LINES && (x_pos + 5) < Animation.LINES &&
                0 <= y_pos && y_pos < Animation.COLUMNS && (y_pos + 10) <= Animation.COLUMNS;

        if(cond) {
            // First and second row doesn't write

            // Third row
            for (int i = y_pos + 3; i < y_pos + 10; i++)
                this.screen[x_pos + 2][i] = '_';

            // Fourth row
            this.screen[x_pos + 3][y_pos + 2] = this.screen[x_pos + 3][y_pos + 9] = '/';
            for (int i = y_pos + 4; i < y_pos + 7; i++)
                this.screen[x_pos + 3][i] = '_';

            // Fifth row
            this.screen[x_pos + 4][y_pos + 1] = this.screen[x_pos + 4][y_pos + 3] = this.screen[x_pos + 4][y_pos + 6] = this.screen[x_pos + 4][y_pos + 8] = '/';
            for (int i = y_pos + 4; i < y_pos + 6; i++)
                this.screen[x_pos + 4][i] = '_';

            // Sixth row
            this.screen[x_pos + 5][y_pos] = this.screen[x_pos + 5][y_pos + 7] = '/';
            for (int i = y_pos + 1; i < y_pos + 7; i++)
                this.screen[x_pos + 5][i] = '_';
        }
    }

    private void writeTMatrix(int x_pos, int y_pos)
    {
        boolean cond = 0 <= x_pos && x_pos < Animation.LINES && (x_pos + 5) < Animation.LINES &&
                0 <= y_pos && y_pos < Animation.COLUMNS && (y_pos + 14) <= Animation.COLUMNS;

        if(cond)
        {
            // First row
            for(int i = y_pos+8; i < y_pos + 11; i++)
                this.screen[x_pos][i] = '_';

            // Second row
            this.screen[x_pos+1][y_pos+7] = this.screen[x_pos+1][y_pos+10] = '/';
            this.screen[x_pos+1][y_pos+5] = this.screen[x_pos+1][y_pos+6] = '_';
            for(int i = y_pos+11; i < y_pos+14; i++)
                this.screen[x_pos+1][i] = '_';

            // Third row
            this.screen[x_pos+2][y_pos+4] = this.screen[x_pos+2][y_pos+13] = '/';
            this.screen[x_pos+2][y_pos+5] = '_';
            for(int i = y_pos+9; i < y_pos+13; i++)
                this.screen[x_pos+2][i] = '_';

            // Fourth row
            this.screen[x_pos+3][y_pos+5] = this.screen[x_pos+3][y_pos+8] = '/';

            // Fifth row
            this.screen[x_pos+4][y_pos+4] = this.screen[x_pos+4][y_pos+7] = this.screen[x_pos+4][y_pos+9] = '/';
            this.screen[x_pos+4][y_pos+10] ='\\';
            this.screen[x_pos+4][y_pos+8] = '_';

            // Sixth row
            this.screen[x_pos+5][y_pos+4] = '\\';
            this.screen[x_pos+5][y_pos+10] = '/';
            for(int i = y_pos+5 ; i < y_pos+10; i++)
                this.screen[x_pos+5][i] = '_';
        }
    }

    public void printFrame()
    {
        out.printMatrix(this.screen, Animation.LINES);
    }
}
