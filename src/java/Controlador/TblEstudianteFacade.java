/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.TblEstudiante;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author georgeperez
 */
@Stateless
public class TblEstudianteFacade extends AbstractFacade<TblEstudiante> {
    @PersistenceContext(unitName = "Gestion_EscolarPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblEstudianteFacade() {
        super(TblEstudiante.class);
    }
    
    public List obtenerEstudiantesActivos(){
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("TblEstudiante.findByStatus");
            q.setParameter("status", true);
            return q.getResultList();
        } catch (EJBException | NoResultException | NullPointerException e) {
            return null;
        }
    }
    
}
