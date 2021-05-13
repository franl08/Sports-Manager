package View;

import java.io.Serializable;

// TODO showPlayers && showMessage, see Controller to know what is supposed to do.
public class View implements Serializable
{
    private final ViewPlayer vp;
    private final Outputs out;

    public View()
    {
        vp = new ViewPlayer();

        out = new Outputs();
    }
}