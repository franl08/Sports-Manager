package View;

import java.io.Serializable;

public final class PositionMenu implements Serializable
{
    public static void printPositionMenu()
    {
        String[] positionMenuArgs = new String[]{"Goalkeeper.", "Defender.", "Winger.", "Midfielder.", "Forward."};
        Outputs.printMenu(positionMenuArgs, "Positions", false);
    }
}
