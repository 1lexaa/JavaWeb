package step.learning.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import step.learning.services.culture.ResourceProvider;
import step.learning.services.culture.StringResourceProvider;
import step.learning.services.formparse.FormParsService;
import step.learning.services.formparse.MixedFormParsService;
import step.learning.services.hash.HashService;
import step.learning.services.hash.Md5HashService;
import step.learning.services.hash.Sha1HashService;
import step.learning.services.random.*;

public class ServicesModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(HashService.class).annotatedWith(Names.named("Digest-hash")).to(Md5HashService.class);
        bind(HashService.class).annotatedWith(Names.named("Signature-hash")).to(Sha1HashService.class);
        bind(ResourceProvider.class).to(StringResourceProvider.class);
        bind(FormParsService.class).to(MixedFormParsService.class);
    }

    private RandomServices random_service ;

    @Provides
    private RandomServices InjectRandomService()
    {
        if( random_service == null )
        {
            random_service = new RandomServiceV1() ;

            random_service.Seed( "initial" ) ;
        }
        return random_service ;
    }
}