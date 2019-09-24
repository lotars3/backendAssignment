package pl.szymonsmenda.backendAssignment.models.audit;

import org.hibernate.envers.query.AuditQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AuditUtils {

    private AuditUtils() {
    }

    public static <TTargetType> List<AuditResult<TTargetType>> getListAuditResults(AuditQuery query, Class<TTargetType> targetType) {

        List<?> results = query.getResultList();

        if (results == null) {
            return new ArrayList<>();
        }
        return results.stream()
                .filter(x -> x instanceof Object[])
                .map(x -> (Object[]) x)
                .map(x -> AuditResultUtils.getAuditResult(x, targetType))
                .collect(Collectors.toList());
    }
}