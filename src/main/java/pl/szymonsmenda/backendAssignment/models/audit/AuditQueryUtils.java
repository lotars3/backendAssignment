package pl.szymonsmenda.backendAssignment.models.audit;

import org.hibernate.envers.query.AuditQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AuditQueryUtils {

    private AuditQueryUtils() {
    }

    public static <TTargetType> List<AuditQueryResult<TTargetType>> getAuditQueryResults(AuditQuery query, Class<TTargetType> targetType) {

        List<?> results = query.getResultList();

        if (results == null) {
            return new ArrayList<>();
        }
        return results.stream()
                .filter(x -> x instanceof Object[])
                .map(x -> (Object[]) x)
                .map(x -> AuditQueryResultUtils.getAuditQueryResult(x, targetType))
                .collect(Collectors.toList());
    }
}