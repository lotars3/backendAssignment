// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package pl.szymonsmenda.backendAssignment.models.Dto;

import org.hibernate.envers.RevisionType;
import pl.szymonsmenda.backendAssignment.models.entites.NotesEntity;
import pl.szymonsmenda.backendAssignment.models.entites.NotesHistory;

public class Converters {

    public static NotesDto convert(NotesEntity source) {

        if(source == null) {
            return null;
        }

        return new NotesDto(source.getId(), source.getContent(), source.getTitle());
    }

//    public static NotesEntity convert(NotesDto source) {
//
//        if(source == null) {
//            return null;
//        }
//
//        return new NotesEntity(source.getId(), source.getTitle(), source.getContent());
//    }

    public static RevisionTypeDto convert(RevisionType source) {

        if(source == null) {
            return null;
        }

        switch (source) {
            case ADD:
                return RevisionTypeDto.ADD;
            case MOD:
                return RevisionTypeDto.MOD;
            case DEL:
                return RevisionTypeDto.DEL;
            default:
                throw new IllegalArgumentException("source");
        }
    }

    public static NotesHistoryDto convert(NotesHistory source) {

        if(source == null) {
            return null;
        }

        NotesDto notesDto = convert(source.getNotesEntity());
        Long revision = source.getRevision().longValue();
        RevisionTypeDto revisionTypeDto = convert(source.getRevisionType());

        return new NotesHistoryDto(notesDto, revision, revisionTypeDto);
    }
}
