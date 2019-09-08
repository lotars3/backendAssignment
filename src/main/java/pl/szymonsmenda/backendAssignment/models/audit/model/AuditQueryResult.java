// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package pl.szymonsmenda.backendAssignment.models.audit.model;

import lombok.Data;
import org.hibernate.envers.RevisionType;
@Data
public class AuditQueryResult<T> {

    private final T entity;
    private final NotesAudEntity revision;
    private final RevisionType type;


}
