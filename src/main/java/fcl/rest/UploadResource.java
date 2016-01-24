/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcl.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author rfk
 */
@Path("upload")
public class UploadResource {
   
    @GET
    @Path("status")
    public String status() {
        return "UP";
    }
    
    @POST
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Path("file")
    public String uploadFile(@FormDataValues MultivaluedMap<String,String> formFields) {
        Map<String,String> data = new HashMap<>();
        formFields.forEach((key, values) -> data.put(key, values.stream().collect(Collectors.joining(","))));
        return data.toString();
    }
    
    @POST
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Path("detailedFile")
    public String uploadFileDetails(@BeanParam UploadDetails details) throws IOException {
        return details.formParameters.toString() + IOUtils.toString(details.data);
    }
}
