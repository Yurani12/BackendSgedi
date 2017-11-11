package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Formalities;
import co.edu.sena.adsi.jpa.entities.Promotions;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-10T09:22:20")
@StaticMetamodel(Packages.class)
public class Packages_ { 

    public static volatile ListAttribute<Packages, Promotions> promotionsList;
    public static volatile SingularAttribute<Packages, Integer> durationMonths;
    public static volatile SingularAttribute<Packages, Double> price;
    public static volatile SingularAttribute<Packages, Integer> id;
    public static volatile SingularAttribute<Packages, String> packageName;
    public static volatile ListAttribute<Packages, Formalities> formalitiesList;

}