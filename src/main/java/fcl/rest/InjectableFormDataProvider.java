/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcl.rest;

import org.glassfish.jersey.server.internal.inject.ParamInjectionResolver;

/**
 *
 * @author rfk
 */
public class InjectableFormDataProvider extends ParamInjectionResolver<FormDataValues> {
    

    public InjectableFormDataProvider() {
        super(InjectableFormDataValueFactoryProvider.class);
    }
    
   
}
