package Vista;

import Entidades.TblEstudiante;
import Vista.util.JsfUtil;
import Vista.util.JsfUtil.PersistAction;
import Controlador.TblEstudianteFacade;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "tblEstudianteController")
@SessionScoped
public class TblEstudianteController implements Serializable {

    @EJB
    private Controlador.TblEstudianteFacade ejbFacade;
    private List<TblEstudiante> items = null;
    private List<TblEstudiante> filteredItems;
    private TblEstudiante selected;
    private String destination = ResourceBundle.getBundle("/BundleUpload").getString("Destino");
    private UploadedFile imgAlumno;
    private UploadedFile imgRepreM;
    private UploadedFile imgRepreP;
    private UploadedFile imgAutorizado;

    public UploadedFile getImgAlumno() {
        return imgAlumno;
    }

    public void setImgAlumno(UploadedFile imgAlumno) {
        this.imgAlumno = imgAlumno;
    }

    public UploadedFile getImgRepreM() {
        return imgRepreM;
    }

    public void setImgRepreM(UploadedFile imgRepreM) {
        this.imgRepreM = imgRepreM;
    }

    public UploadedFile getImgRepreP() {
        return imgRepreP;
    }

    public void setImgRepreP(UploadedFile imgRepreP) {
        this.imgRepreP = imgRepreP;
    }

    public UploadedFile getImgAutorizado() {
        return imgAutorizado;
    }

    public void setImgAutorizado(UploadedFile imgAutorizado) {
        this.imgAutorizado = imgAutorizado;
    }
    
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
    
    public void uploadImgAlumno(FileUploadEvent event) {
        try {
            int i = 0;
            while (validaArchivo(i + "_" + event.getFile().getFileName())) {i++;}
            copyFile(i + "_" + event.getFile().getFileName(), event.getFile().getInputstream()); 
            selected.setFoto(i + "_" + event.getFile().getFileName());
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ImgUpload"));
        } catch (IOException ex) {
            Logger.getLogger(TblEstudianteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void uploadImgMadre(FileUploadEvent event) {
        try {
            int i = 0;
            while (validaArchivo(i + "_" + event.getFile().getFileName())) {i++;}
            copyFile(i + "_" + event.getFile().getFileName(), event.getFile().getInputstream()); 
            selected.getIdRepresentanteM().setFoto(i + "_" + event.getFile().getFileName());
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ImgUpload"));
        } catch (IOException ex) {
            Logger.getLogger(TblEstudianteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void uploadImgPadre(FileUploadEvent event) {
        try {
            int i = 0;
            while (validaArchivo(i + "_" + event.getFile().getFileName())) {i++;}
            copyFile(i + "_" + event.getFile().getFileName(), event.getFile().getInputstream()); 
            selected.getIdRepresentanteP().setFoto(i + "_" + event.getFile().getFileName());
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ImgUpload"));
        } catch (IOException ex) {
            Logger.getLogger(TblEstudianteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void uploadImgAutorizado(FileUploadEvent event) {
        try {
            int i = 0;
            while (validaArchivo(i + "_" + event.getFile().getFileName())) {i++;}
            copyFile(i + "_" + event.getFile().getFileName(), event.getFile().getInputstream()); 
            selected.getIdAutorizado().setFoto(i + "_" + event.getFile().getFileName());
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ImgUpload"));
        } catch (IOException ex) {
            Logger.getLogger(TblEstudianteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardar(){
//         try {
//            System.out.println("Guardar " + destination + "alumno."+FilenameUtils.getExtension(imgAlumno.getFileName()));
//            selected.setFoto("alumno."+FilenameUtils.getExtension(imgAlumno.getFileName()));
//            copyFile("alumno."+FilenameUtils.getExtension(imgAlumno.getFileName()), imgAlumno.getInputstream());
//            selected.getIdRepresentanteM().setFoto("repreM."+FilenameUtils.getExtension(imgRepreM.getFileName()));
//            copyFile("repreM."+FilenameUtils.getExtension(imgRepreM.getFileName()), imgRepreM.getInputstream());
//            selected.getIdRepresentanteP().setFoto("repreP."+FilenameUtils.getExtension(imgRepreP.getFileName()));
//            copyFile("repreP."+FilenameUtils.getExtension(imgRepreP.getFileName()), imgRepreP.getInputstream());
//            selected.getIdAutorizado().setFoto("autorizado."+FilenameUtils.getExtension(imgAutorizado.getFileName()));
//            copyFile("autorizado."+FilenameUtils.getExtension(imgAutorizado.getFileName()), imgAutorizado.getInputstream());
//        } catch (IOException e) {}
        create();
    }
    
    public void copyFile(String fileName, InputStream in) {
        try {
            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(destination + fileName));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            System.out.println("Archivo Creado!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean validaArchivo(String archivo) {
        File files = new File(ResourceBundle.getBundle("/BundleUpload").getString("Destino") + archivo);
//        Seteamos el destino de los archivos que seran subidos
//        destination = ResourceBundle.getBundle("/BundleUpload").getString("Destino") ;
        return files.exists();
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
