package step.learning.services.kdf;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import step.learning.services.hash.HashService;

@Singleton
public class DigestHashKdfService implements KdfService
{
    private final HashService _hash_service;

    @Inject
    public DigestHashKdfService(@Named("Digest-hash") HashService hash_service)
    {
        _hash_service = hash_service;
    }

    @Override
    public String GetDerivedKey(String password, String salt)
    {
        return _hash_service.Hash(salt + password + salt);
    }
}