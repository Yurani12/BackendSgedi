package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.DocumentsHasState;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-25T09:58:22")
@StaticMetamodel(RetentionTables.class)
public class RetentionTables_ { 

    public static volatile SingularAttribute<RetentionTables, String> subSerie;
    public static volatile SingularAttribute<RetentionTables, Date> date;
    public static volatile SingularAttribute<RetentionTables, String> documentType;
    public static volatile SingularAttribute<RetentionTables, String> serie;
    public static volatile ListAttribute<RetentionTables, DocumentsHasState> documentsHasStateList;
    public static volatile SingularAttribute<RetentionTables, String> procedimet;
    public static volatile SingularAttribute<RetentionTables, Integer> id;
    public static volatile SingularAttribute<RetentionTables, String> totalConservation;

}