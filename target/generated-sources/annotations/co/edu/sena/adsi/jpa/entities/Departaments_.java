package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Cities;
import co.edu.sena.adsi.jpa.entities.Countries;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-23T09:28:19")
@StaticMetamodel(Departaments.class)
public class Departaments_ { 

    public static volatile ListAttribute<Departaments, Cities> citiesList;
    public static volatile SingularAttribute<Departaments, Countries> idCountries;
    public static volatile SingularAttribute<Departaments, String> description;
    public static volatile SingularAttribute<Departaments, Integer> id;

}