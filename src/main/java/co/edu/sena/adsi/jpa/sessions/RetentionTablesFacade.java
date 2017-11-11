/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.sessions;

import co.edu.sena.adsi.jpa.entities.RetentionTables;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adsi1261718
 */
@Stateless
public class RetentionTablesFacade extends AbstractFacade<RetentionTables> {

    @PersistenceContext(unitName = "co.edu.sena_BAKEND_SGEDI_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RetentionTablesFacade() {
        super(RetentionTables.class);
    }
    
}
