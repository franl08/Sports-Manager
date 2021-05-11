package View;

import java.io.Serializable;

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