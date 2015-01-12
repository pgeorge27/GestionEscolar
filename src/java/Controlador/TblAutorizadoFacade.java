/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.TblAutorizado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author georgeperez
 */
@Stateless
public class TblAutorizadoFacade extends AbstractFacade<TblAutorizado> {
    @PersistenceContext(unitName = "Gestion_EscolarPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblAutorizadoFacade() {
        super(TblAutorizado.class);
    }
    
}
