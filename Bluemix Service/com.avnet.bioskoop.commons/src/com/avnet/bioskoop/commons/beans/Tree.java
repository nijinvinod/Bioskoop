package com.avnet.bioskoop.commons.beans;


public class Tree
{
private String id;

private String name;

private Children[] children;

public String getId ()
{
return id;
}

public void setId (String id)
{
this.id = id;
}

public String getName ()
{
return name;
}

public void setName (String name)
{
this.name = name;
}

public Children[] getChildren ()
{
return children;
}

public void setChildren (Children[] children)
{
this.children = children;
}

@Override
public String toString()
{
return "Tree [id = "+id+", name = "+name+", children = "+children+"]";
}
}