package pl.szymonsmenda.backendAssignment.models.repositiories;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.szymonsmenda.backendAssignment.models.audit.AuditResult;
import pl.szymonsmenda.backendAssignment.models.audit.AuditUtils;
import pl.szymonsmenda.backendAssignment.models.entity.NoteEntity;
import pl.szymonsmenda.backendAssignment.models.entity.NoteHistory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NoteHistoryRepository implements INoteHistoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<NoteHistory> listNoteHistoryAudit(long id) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        AuditQuery auditQuery = auditReader.createQuery()
                .forRevisionsOfEntity(NoteEntity.class, false, true)
                .add(AuditEntity.id().eq(id));

        return AuditUtils.getListAuditResults(auditQuery, NoteEntity.class).stream()
                .map(x -> getCustomerHistory(x))
                .collect(Collectors.toList());
    }

    private static NoteHistory getCustomerHistory(AuditResult<NoteEntity> auditResult) {
        return new NoteHistory(
                auditResult.getEntity(),
                auditResult.getRevision().getRevisionNumber(),
                auditResult.getType()
        );
    }
}

