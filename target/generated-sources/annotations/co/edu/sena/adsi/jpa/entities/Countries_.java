package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Departaments;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-25T09:58:22")
@StaticMetamodel(Countries.class)
public class Countries_ { 

    public static volatile SingularAttribute<Countries, String> description;
    public static volatile ListAttribute<Countries, Departaments> departamentsList;
    public static volatile SingularAttribute<Countries, Integer> id;

}