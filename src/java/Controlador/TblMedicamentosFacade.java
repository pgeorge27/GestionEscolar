/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.TblMedicamentos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author georgeperez
 */
@Stateless
public class TblMedicamentosFacade extends AbstractFacade<TblMedicamentos> {
    @PersistenceContext(unitName = "Gestion_EscolarPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblMedicamentosFacade() {
        super(TblMedicamentos.class);
    }
    
}
