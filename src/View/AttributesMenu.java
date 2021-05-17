package View;

import java.io.Serializable;

public final class AttributesMenu implements Serializable
{
    public static void printAttributesMenu()
    {
        String[] positionMenuArgs = new String[]{"Automatic.", "Manual."};
        Outputs.printMenu(positionMenuArgs, "Attribute", false);
    }
}
