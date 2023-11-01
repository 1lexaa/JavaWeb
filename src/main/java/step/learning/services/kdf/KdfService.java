package step.learning.services.kdf;

public interface KdfService
{
    String GetDerivedKey(String password, String salt);
}