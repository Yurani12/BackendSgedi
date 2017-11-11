/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.sessions;

import co.edu.sena.adsi.jpa.entities.Countries;
import co.edu.sena.adsi.jpa.entities.Departaments;
import co.edu.sena.adsi.jpa.entities.Departaments_;
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
public class DepartamentsFacade extends AbstractFacade<Departaments> {

    @PersistenceContext(unitName = "co.edu.sena_BAKEND_SGEDI_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentsFacade() {
        super(Departaments.class);
    }
    public List<Departaments> findDepartamentByNombre(String query, Integer idCountry) {
        
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Departaments> cq = cb.createQuery(Departaments.class);
        Root<Departaments> city = cq.from(Departaments.class);
        
        Predicate restrictions = cb.conjunction();
        
        if(idCountry != null){
            restrictions = cb.and(restrictions, cb.equal(city.get(Departaments_.idCountries), new Countries(idCountry)));
        }
        
        if(query != null){
            restrictions = cb.and(restrictions, cb.like(city.get(Departaments_.description), "%" + query + "%"));
        }
        
        cq.where(restrictions);
        cq.orderBy(cb.asc(city.get(Departaments_.description)));
        TypedQuery<Departaments> q = em.createQuery(cq);
        try {
            return q.setMaxResults(100).getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
