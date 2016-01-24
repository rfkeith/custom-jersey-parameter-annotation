/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcl.rest;

import java.io.InputStream;
import javax.ws.rs.core.MultivaluedMap;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author rfk
 */
public class UploadDetails {
    
    @FormDataValues
    public MultivaluedMap<String,String> formParameters;
    
    @FormDataParam("fileToUpload")
    public InputStream data ;

//    public UploadDetails(@FormDataValues MultivaluedMap<String, String> formParameters, @FormDataParam("fileName") InputStream data) {
//        this.formParameters = formParameters;
//        this.data = data;
//    }
    
}
