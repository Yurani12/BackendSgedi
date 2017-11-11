/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.sessions;

import co.edu.sena.adsi.jpa.entities.Cities;
import co.edu.sena.adsi.jpa.entities.Cities_;
import co.edu.sena.adsi.jpa.entities.Departaments;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author adsi1261718
 */
@Stateless
public class CitiesFacade extends AbstractFacade<Cities> {

    @PersistenceContext(unitName = "co.edu.sena_BAKEND_SGEDI_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitiesFacade() {
        super(Cities.class);
    }
     public List<Cities> findCiudadByNombre(String query, Integer idDepartament) {
        
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Cities> cq = cb.createQuery(Cities.class);
        Root<Cities> city = cq.from(Cities.class);
        
        Predicate restrictions = cb.conjunction();
        
        if(idDepartament != null){
            restrictions = cb.and(restrictions, cb.equal(city.get(Cities_.idDepartaments), new Departaments(idDepartament)));
        }
        
        if(query != null){
            restrictions = cb.and(restrictions, cb.like(city.get(Cities_.description), "%" + query + "%"));
        }
        
        cq.where(restrictions);
        cq.orderBy(cb.asc(city.get(Cities_.description)));
        TypedQuery<Cities> q = em.createQuery(cq);
        try {
            return q.setMaxResults(10).getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
