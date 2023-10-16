package step.learning.services.random;

public interface RandomServices
{
    void Seed(String iv);
    String RandomHex(int char_length);
}