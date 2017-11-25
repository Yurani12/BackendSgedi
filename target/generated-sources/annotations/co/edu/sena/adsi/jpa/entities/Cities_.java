package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Departaments;
import co.edu.sena.adsi.jpa.entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-23T09:28:19")
@StaticMetamodel(Cities.class)
public class Cities_ { 

    public static volatile ListAttribute<Cities, Users> usersList;
    public static volatile SingularAttribute<Cities, String> description;
    public static volatile SingularAttribute<Cities, Integer> id;
    public static volatile SingularAttribute<Cities, Departaments> idDepartaments;

}