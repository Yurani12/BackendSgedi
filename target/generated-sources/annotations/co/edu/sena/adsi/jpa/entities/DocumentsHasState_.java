package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Documents;
import co.edu.sena.adsi.jpa.entities.RetentionTables;
import co.edu.sena.adsi.jpa.entities.State;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-25T09:58:22")
@StaticMetamodel(DocumentsHasState.class)
public class DocumentsHasState_ { 

    public static volatile SingularAttribute<DocumentsHasState, Integer> idDocumentState;
    public static volatile SingularAttribute<DocumentsHasState, Date> dateStart;
    public static volatile SingularAttribute<DocumentsHasState, RetentionTables> idRetentionTables;
    public static volatile SingularAttribute<DocumentsHasState, String> description;
    public static volatile SingularAttribute<DocumentsHasState, Documents> idDocumentsType;
    public static volatile SingularAttribute<DocumentsHasState, Date> dateEnd;
    public static volatile SingularAttribute<DocumentsHasState, State> idState;

}