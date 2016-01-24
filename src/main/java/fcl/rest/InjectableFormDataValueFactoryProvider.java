/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcl.rest;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Providers;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.server.internal.inject.AbstractValueFactoryProvider;
import org.glassfish.jersey.server.internal.inject.MultivaluedParameterExtractorProvider;
import org.glassfish.jersey.server.model.Parameter;

/**
 *
 * @author rfk
 */
@Singleton
public class InjectableFormDataValueFactoryProvider extends AbstractValueFactoryProvider{
    
    @Inject
    public InjectableFormDataValueFactoryProvider(MultivaluedParameterExtractorProvider mpep, ServiceLocator locatator) {
        super(mpep, locatator, Parameter.Source.UNKNOWN);
    }

    @Override
    protected Factory<?> createValueFactory(Parameter parameter) {
        return new MultiPartFactory();
    }
    
}
