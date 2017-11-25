package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Packages;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-23T09:28:19")
@StaticMetamodel(Promotions.class)
public class Promotions_ { 

    public static volatile SingularAttribute<Promotions, Date> promotionStart;
    public static volatile SingularAttribute<Promotions, String> promotionName;
    public static volatile SingularAttribute<Promotions, Date> promotionEnd;
    public static volatile SingularAttribute<Promotions, Double> discount;
    public static volatile SingularAttribute<Promotions, Integer> id;
    public static volatile SingularAttribute<Promotions, Packages> idPackages;

}