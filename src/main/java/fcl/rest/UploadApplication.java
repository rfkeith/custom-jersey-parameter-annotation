/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcl.rest;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spi.internal.ValueFactoryProvider;

/**
 *
 * @author rfk
 */
@ApplicationPath("/rest")
public class UploadApplication extends ResourceConfig {

    public UploadApplication() {
        register(MultiPartFeature.class)
                .register(new FormDataValuesBinder()).packages("fcl.rest");

    }

    private class FormDataValuesBinder extends AbstractBinder {

        @Override
        protected void configure() {
//            bindFactory(MultipartFactory.class)
//                    .proxy(true)
//                    .proxyForSameScope(false)
//                    .to(Multipart.class)
//                    .in(RequestScoped.class);
            bind(InjectableFormDataValueFactoryProvider.class).to(ValueFactoryProvider.class).in(Singleton.class);
            bind(InjectableFormDataProvider.class).to(new TypeLiteral<InjectionResolver<FormDataValues>>() {
            }).in(Singleton.class);
        }

    }
    
}
