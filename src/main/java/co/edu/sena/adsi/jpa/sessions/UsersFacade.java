/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.sessions;

import co.edu.sena.adsi.jpa.entities.DocumentsType;
import co.edu.sena.adsi.jpa.entities.DocumentsType_;
import co.edu.sena.adsi.jpa.entities.Rol;
import co.edu.sena.adsi.jpa.entities.Rol_;
import co.edu.sena.adsi.jpa.entities.Users;
import co.edu.sena.adsi.jpa.entities.Users_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author adsi1261718
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "co.edu.sena_BAKEND_SGEDI_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    public Users findUsersByEmail(String email) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> users = cq.from(Users.class);
        cq.where(cb.equal(users.get(Users_.email), email));
        TypedQuery<Users> q = getEntityManager().createQuery(cq);
        try {
            return (Users) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }

    /**
     * Busca usuario por numDocumento
     *
     * @param numDocument
     * @return Usuario
      */
    public Users findUsersByNumDocument(String numDocument) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> users = cq.from(Users.class);
        cq.where(cb.equal(users.get(Users_.numDocument), numDocument));
        TypedQuery<Users> q = getEntityManager().createQuery(cq);
        try {
            return (Users) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }

    /**
     * Busca usuarios por parametros
     *
     * @param idUsuario
     * @param sexo
     * @param activo
     * @param numDocumento
     * @param email
     * @param idCiudad
     * @param idDepartamento
     * @param idTipoDocumento
     * @return
      */
    public List<Users> findUsers(Integer idUsuario, String sexo, Boolean activo,
            String numDocumento, String email, String cities, Integer idDepartamento,
            Integer idTipoDocumento) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> users = cq.from(Users.class);

        Predicate data = cb.conjunction();

        if (idUsuario != null) {
            data = cb.and(data, cb.equal(users.get(Users_.id), idUsuario));
        }

        if (sexo != null) {
            data = cb.and(data, cb.equal(users.get(Users_.sex), sexo));
        }

        if (activo != null) {
            data = cb.and(data, cb.equal(users.get(Users_.active), activo));
        }

        if (numDocumento != null) {
            data = cb.and(data, cb.equal(users.get(Users_.numDocument), numDocumento));
        }

        if (email != null) {
            data = cb.and(data, cb.equal(users.get(Users_.email), email));
        }
          if (cities != null) {
            data = cb.and(data, cb.equal(users.get(Users_.Cities), cities));
        }

        cq.where(data);
        cq.orderBy(cb.asc(users.get(Users_.lastName)));
        TypedQuery<Users> tq = em.createQuery(cq);

        try {
            return tq.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    /**
     * Busca usuario por rol
     *
     * @param rol
     * @return Usuarios
      */
    public List<Users> findAllUsersByRol(String rol) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Rol> rootRol = cq.from(Rol.class);
        cq.where(cb.equal(rootRol.get(Rol_.id), rol));
        ListJoin<Rol, Users> joinRol = rootRol.join(Rol_.usersList);
        CriteriaQuery<Users> cqq = cq.select(joinRol);

        TypedQuery<Users> q = getEntityManager().createQuery(cq);
        try {
            return q.getResultList();

        } catch (NoResultException ex) {
            return null;
        }
    }

    /**
     * Busca un usuario por filtros
     *
     * @param rango
     * @param sex
     * @param active
     * @param documentsType
     * @return
     */ 
    public List<Users> findUsersFiltro(int[] rango, String sex, Boolean active,
            String documentsType) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> users = cq.from(Users.class);

        Predicate filtro = cb.conjunction();

        if (sex != null) {
            filtro = cb.and(filtro, cb.equal(users.get(Users_.sex), sex));
        }

        if (active != null) {
            filtro = cb.and(filtro, cb.equal(users.get(Users_.active), active));
        }

        if (documentsType != null) {
            Join<Users, DocumentsType> joinDocumentsType = users.join(Users_.DocumentsType);
            filtro = cb.and(filtro, cb.equal(joinDocumentsType.get(DocumentsType_.id), documentsType));
        }

        cq.where(filtro);
        cq.orderBy(cb.asc(users.get(Users_.lastName)));
        TypedQuery<Users> tq = em.createQuery(cq);

        if (rango != null) {
            tq.setMaxResults(rango[1] - rango[0] + 1);
            tq.setFirstResult(rango[0]);
        }
        try {
            return tq.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public int countFiltro(String sex, Boolean active,
            String documentsType) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Users> users = cq.from(Users.class);

        Predicate filtro = cb.conjunction();

        if (sex != null) {
            filtro = cb.and(filtro, cb.equal(users.get(Users_.sex), sex));
        }

        if (active != null) {
            filtro = cb.and(filtro, cb.equal(users.get(Users_.active), active));
        }

        if (documentsType != null) {
            Join<Users, DocumentsType> joinDocumentsType = users.join(Users_.DocumentsType);
            filtro = cb.and(filtro, cb.equal(joinDocumentsType.get(DocumentsType_.id), documentsType));
        }

        cq.where(filtro);
        cq.select(cb.count(users));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
