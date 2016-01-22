package com.avnet.bioskoop.commons.beans;

public class Children
{
private String id;

private String category;

private String percentage;

private String name;

private String sampling_error;

public String getId ()
{
return id;
}

public void setId (String id)
{
this.id = id;
}

public String getCategory ()
{
return category;
}

public void setCategory (String category)
{
this.category = category;
}

public String getPercentage ()
{
return percentage;
}

public void setPercentage (String percentage)
{
this.percentage = percentage;
}

public String getName ()
{
return name;
}

public void setName (String name)
{
this.name = name;
}

public String getSampling_error ()
{
return sampling_error;
}

public void setSampling_error (String sampling_error)
{
this.sampling_error = sampling_error;
}

@Override
public String toString()
{
return "Children [id = "+id+", category = "+category+", percentage = "+percentage+", name = "+name+", sampling_error = "+sampling_error+"]";
}
}

