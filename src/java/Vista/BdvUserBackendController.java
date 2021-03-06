package Vista;

import Entidades.BdvUserBackend;
import Vista.util.JsfUtil;
import Vista.util.JsfUtil.PersistAction;
import Controlador.BdvUserBackendFacade;
import java.io.IOException;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.NoResultException;

@ManagedBean(name = "bdvUserBackendController")
@SessionScoped
public class BdvUserBackendController implements Serializable {

    @EJB
    private Controlador.BdvUserBackendFacade ejbFacade;
    private List<BdvUserBackend> items = null;
    private BdvUserBackend selected;
    private BdvUserBackend selected2;

    public BdvUserBackendController() {
    }

    public BdvUserBackend getSelected2() {
        return selected2;
    }

    public void setSelected2(BdvUserBackend selected2) {
        this.selected2 = selected2;
    }

    public BdvUserBackend getSelected() {
        return selected;
    }

    public void setSelected(BdvUserBackend selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private BdvUserBackendFacade getFacade() {
        return ejbFacade;
    }

    public BdvUserBackend prepareCreate() {
        selected = new BdvUserBackend();
        initializeEmbeddableKey();
        return selected;
    }
    
    public BdvUserBackend prepareCreate2() {
        System.out.println("En Prepare");
        selected2 = new BdvUserBackend();
        return selected2;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("BdvUserBackendCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("BdvUserBackendUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("BdvUserBackendDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<BdvUserBackend> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<BdvUserBackend> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<BdvUserBackend> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public String entrarHomeBackend(String userBackend, String contrasenia) {
        try {
            BdvUserBackend user = getFacade().obtenerUsuario(userBackend, contrasenia);
            if (user != null) { //Si el usuario esta activo
                try {
                    ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                    context.redirect(context.getRequestContextPath() + "/faces/index.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(BdvUserBackendController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else { //Si el usuario esta inactivo
                JsfUtil.addErrorMessage("Usuario o contraseña incorrecta.");
                return null;
            }

        } catch (EJBException | NoResultException | NullPointerException ex) {
            System.out.println("NO USER");
//            JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("EmailOrPasswordErrorOccured"));
        }
        return null;
    }
    @FacesConverter(forClass = BdvUserBackend.class)
    public static class BdvUserBackendControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            BdvUserBackendController controller = (BdvUserBackendController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "bdvUserBackendController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof BdvUserBackend) {
                BdvUserBackend o = (BdvUserBackend) object;
                return getStringKey(o.getIdUser());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), BdvUserBackend.class.getName()});
                return null;
            }
        }

    }

}
