package Vista;

import Entidades.TblEstudiante;
import Vista.util.JsfUtil;
import Vista.util.JsfUtil.PersistAction;
import Controlador.TblEstudianteFacade;
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
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "tblEstudianteController")
@SessionScoped
public class TblEstudianteController implements Serializable {

    @EJB
    private Controlador.TblEstudianteFacade ejbFacade;
    private List<TblEstudiante> items = null;
    private List<TblEstudiante> filteredItems;
    private TblEstudiante selected;

    public TblEstudianteController() {
    }

    public TblEstudiante getSelected() {
        return selected;
    }

    public void setSelected(TblEstudiante selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TblEstudianteFacade getFacade() {
        return ejbFacade;
    }

    public List<TblEstudiante> getFilteredItems() {
        return filteredItems;
    }

    public void setFilteredItems(List<TblEstudiante> filteredItems) {
        this.filteredItems = filteredItems;
    }

    public TblEstudiante prepareCreate() {
        selected = new TblEstudiante();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TblEstudianteCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        try {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/faces/tblEstudiante/List.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(TblEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TblEstudianteUpdated"));
    }

    public void destroy() {
        this.selected.setStatus(false);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TblEstudianteDeleted"));
//        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TblEstudianteDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TblEstudiante> getItems() {
        if (items == null) {
            //Obtenemos solos los usuarios con status true
            items = getFacade().obtenerEstudiantesActivos();
            //items = getFacade().findAll();
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

    public List<TblEstudiante> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TblEstudiante> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }
    
    public void logOut() {
        getRequest().getSession().invalidate();
        this.selected = null;
        try {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/faces/login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(TblEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    @FacesConverter(forClass = TblEstudiante.class)
    public static class TblEstudianteControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TblEstudianteController controller = (TblEstudianteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tblEstudianteController");
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
            if (object instanceof TblEstudiante) {
                TblEstudiante o = (TblEstudiante) object;
                return getStringKey(o.getIdEstudiante());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TblEstudiante.class.getName()});
                return null;
            }
        }

    }

}
