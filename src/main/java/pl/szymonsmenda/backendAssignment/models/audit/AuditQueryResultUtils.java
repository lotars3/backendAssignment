package pl.szymonsmenda.backendAssignment.models.audit;

import org.hibernate.envers.RevisionType;

public class AuditQueryResultUtils {

    private AuditQueryResultUtils() {
    }

    public static <TargetType> AuditQueryResult<TargetType> getAuditQueryResult(Object[] item, Class<TargetType> type) {

        if (item == null) {
            return null;
        }
        TargetType entity = null;
        if (type.isInstance(item[0])) {
            entity = type.cast(item[0]);
        }
        NotesAudEntity revision = null;
        if (item[1] instanceof NotesAudEntity) {
            revision = (NotesAudEntity) item[1];
        }
        RevisionType revisionType = null;
        if (item[2] instanceof RevisionType) {
            revisionType = (RevisionType) item[2];
        }
        return new AuditQueryResult<TargetType>(entity, revision, revisionType);
    }
}
