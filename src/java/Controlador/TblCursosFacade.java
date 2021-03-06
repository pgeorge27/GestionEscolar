/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.TblCursos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author georgeperez
 */
@Stateless
public class TblCursosFacade extends AbstractFacade<TblCursos> {
    @PersistenceContext(unitName = "Gestion_EscolarPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblCursosFacade() {
        super(TblCursos.class);
    }
    
}
