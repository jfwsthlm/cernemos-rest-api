package se.sthlm.jfw.cernemos.api.data;

public class Rot13CipherRequest
{
    String text;

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }
}
