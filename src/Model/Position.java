package Model;

public enum Position
{
    GOALKEEPER, DEFENDER, WINGER, MIDFIELDER, FORWARD;

    @Override
    public String toString()
    {
        switch (this)
        {
            case GOALKEEPER ->
                    {
                        return "Goalkeeper";
                    }

            case DEFENDER ->
                    {
                        return "Defender";
                    }

            case WINGER ->
                    {
                        return "Winger";
                    }

            case MIDFIELDER ->
                    {
                        return "Midfielder";
                    }

            case FORWARD ->
                    {
                        return "Forward";
                    }

            default ->
                    {
                        return null;
                    }
        }
    }
}
