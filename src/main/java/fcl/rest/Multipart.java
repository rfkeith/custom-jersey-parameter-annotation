/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcl.rest;

import java.util.Collections;
import java.util.List;
import org.jvnet.mimepull.MIMEMessage;
import org.jvnet.mimepull.MIMEPart;

/**
 *
 * @author rfk
 */
public class Multipart {
    
    private final MIMEMessage msg;
    private final List<MIMEPart> attachments;
    
    public Multipart() {
        msg = null;
        attachments = Collections.emptyList();
    }

    public Multipart(MIMEMessage msg) {
        this.msg = msg;
        this.attachments = msg.getAttachments();
    }
    
    public int size() {
        return attachments.size();
    }
    
}
