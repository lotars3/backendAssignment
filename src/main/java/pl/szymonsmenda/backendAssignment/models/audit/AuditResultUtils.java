package pl.szymonsmenda.backendAssignment.models.audit;

import org.hibernate.envers.RevisionType;

public class AuditResultUtils {

    private AuditResultUtils() {
    }

    public static <TargetType> AuditResult<TargetType> getAuditResult(Object[] item, Class<TargetType> type) {

        TargetType entity = null;
        if (type.isInstance(item[0])) {
            entity = type.cast(item[0]);
        }
        NoteAudEntity revision = null;
        if (item[1] instanceof NoteAudEntity) {
            revision = (NoteAudEntity) item[1];
        }
        RevisionType revisionType = null;
        if (item[2] instanceof RevisionType) {
            revisionType = (RevisionType) item[2];
        }
        return new AuditResult<TargetType>(entity, revision, revisionType);
    }
}
