package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Packages;
import co.edu.sena.adsi.jpa.entities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-23T09:28:19")
@StaticMetamodel(Formalities.class)
public class Formalities_ { 

    public static volatile SingularAttribute<Formalities, Date> dateStart;
    public static volatile SingularAttribute<Formalities, Double> totalPrice;
    public static volatile SingularAttribute<Formalities, String> description;
    public static volatile SingularAttribute<Formalities, Integer> id;
    public static volatile SingularAttribute<Formalities, Date> dateEnd;
    public static volatile SingularAttribute<Formalities, Users> idUsers;
    public static volatile SingularAttribute<Formalities, Packages> idPackages;

}