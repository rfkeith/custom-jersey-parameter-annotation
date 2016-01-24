/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcl.rest;

import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Providers;
import org.apache.commons.lang.StringUtils;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.internal.LocalizationMessages;
import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.internal.inject.AbstractContainerRequestValueFactory;

/**
 *
 * @author rfk
 */
public class MultiPartFactory extends AbstractContainerRequestValueFactory<MultivaluedMap<String, String>> {

    @Inject
    Providers providers;

    @Override
    public MultivaluedMap<String, String> provide() {

        Object entity = saveEntityToRequest();
        MultivaluedMap<String, String> x = new MultivaluedHashMap<>();
        FormDataMultiPart fdmp = (FormDataMultiPart) entity;
        fdmp.getFields().forEach((key, parts) -> {
            if (parts.size() == 1 && StringUtils.isBlank(parts.get(0).getContentDisposition().getFileName())) {
                x.putSingle(key, parts.get(0).getValueAs(String.class));
            }
        });
        return x;
    }

    private Object saveEntityToRequest() throws BadRequestException {
        final ContainerRequest request = getContainerRequest();
        final String requestPropertyName = FormDataMultiPart.class.getName();
        Object entity = request.getProperty(requestPropertyName);
        if (entity == null) {
            entity = request.readEntity(FormDataMultiPart.class);
            if (entity == null) {
                throw new BadRequestException(LocalizationMessages.ENTITY_IS_EMPTY());
            }
            request.setProperty(requestPropertyName, entity);
        }
        return entity;
    }

    @Override
    public void dispose(MultivaluedMap instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
