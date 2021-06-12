package Model;

/**
 * Enum of possible positions
 */
public enum Position
{
    /**
     * Goalkeeper position
     */
    GOALKEEPER,
    /**
     * Defender position
     */
    DEFENDER,
    /**
     * Winger position
     */
    WINGER,
    /**
     * Midfielder position
     */
    MIDFIELDER,
    /**
     * Forward position
     */
    FORWARD;

    /**
     * Method to get one position as a string
     * @return Position in a String
     */
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
