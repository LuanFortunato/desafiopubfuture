
package utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensagens {
    
    public static void exibeMensagem(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
    
}
