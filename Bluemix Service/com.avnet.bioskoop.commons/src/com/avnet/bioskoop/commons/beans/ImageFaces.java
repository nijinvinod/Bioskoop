package com.avnet.bioskoop.commons.beans;


public class ImageFaces
{
private String height;

private String positionX;

private String width;

private Age age;

private String positionY;

private Gender gender;

public String getHeight ()
{
return height;
}

public void setHeight (String height)
{
this.height = height;
}

public String getPositionX ()
{
return positionX;
}

public void setPositionX (String positionX)
{
this.positionX = positionX;
}

public String getWidth ()
{
return width;
}

public void setWidth (String width)
{
this.width = width;
}

public Age getAge ()
{
return age;
}

public void setAge (Age age)
{
this.age = age;
}

public String getPositionY ()
{
return positionY;
}

public void setPositionY (String positionY)
{
this.positionY = positionY;
}

public Gender getGender ()
{
return gender;
}

public void setGender (Gender gender)
{
this.gender = gender;
}

@Override
public String toString()
{
return "ImageFaces [height = "+height+", positionX = "+positionX+", width = "+width+", age = "+age+", positionY = "+positionY+", gender = "+gender+"]";
}
}
