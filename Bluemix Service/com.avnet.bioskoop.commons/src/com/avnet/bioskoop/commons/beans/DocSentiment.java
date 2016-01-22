package com.avnet.bioskoop.commons.beans;

public class DocSentiment
{
    private String score;

    private String type;

    public String getScore ()
    {
        return score;
    }

    public void setScore (String score)
    {
        this.score = score;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "DocSentiment [score = "+score+", type = "+type+"]";
    }
}
	