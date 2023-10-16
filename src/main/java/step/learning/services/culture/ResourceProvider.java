package step.learning.services.culture;

public interface ResourceProvider
{
    String GetString(String name, String culture);

    String GetString(String name);

    void SetCulture(String culture);

    String GetCulture();
}