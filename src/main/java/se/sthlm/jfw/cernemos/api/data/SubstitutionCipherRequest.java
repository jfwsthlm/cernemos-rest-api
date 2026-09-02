package se.sthlm.jfw.cernemos.api.data;

import java.util.Map;

public class SubstitutionCipherRequest
{
    String originalText;

    Map<Character, Character> substitutionMap;

    public String getOriginalText()
    {
        return originalText;
    }

    public void setOriginalText(String originalText)
    {
        this.originalText = originalText;
    }

    public Map<Character, Character> getSubstitutionMap()
    {
        return substitutionMap;
    }

    public void setSubstitutionMap(Map<Character, Character> substitutionMap)
    {
        this.substitutionMap = substitutionMap;
    }

}
