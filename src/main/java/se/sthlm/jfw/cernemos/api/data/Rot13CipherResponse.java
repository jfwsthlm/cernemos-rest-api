package se.sthlm.jfw.cernemos.api.data;

public class Rot13CipherResponse
{
    String text;

    public Rot13CipherResponse(String text)
    {
        this.text = text;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }
}
