package com.avnet.bioskoop.commons.beans;

public class ProcessedTweetBean
{
    private DocSentiment docSentiment;

    private String status;

    private String totalTransactions;

    private String usage;

    private String language;

    public DocSentiment getDocSentiment ()
    {
        return docSentiment;
    }

    public void setDocSentiment (DocSentiment docSentiment)
    {
        this.docSentiment = docSentiment;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getTotalTransactions ()
    {
        return totalTransactions;
    }

    public void setTotalTransactions (String totalTransactions)
    {
        this.totalTransactions = totalTransactions;
    }

    public String getUsage ()
    {
        return usage;
    }

    public void setUsage (String usage)
    {
        this.usage = usage;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    @Override
    public String toString()
    {
        return "ProcessedTweetBean [docSentiment = "+docSentiment+", status = "+status+", totalTransactions = "+totalTransactions+", usage = "+usage+", language = "+language+"]";
    }
}
			