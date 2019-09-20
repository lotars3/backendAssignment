package pl.szymonsmenda.backendAssignment.models.services;

import org.hibernate.envers.RevisionType;
import pl.szymonsmenda.backendAssignment.models.dto.NoteDto;
import pl.szymonsmenda.backendAssignment.models.dto.NoteHistoryDto;
import pl.szymonsmenda.backendAssignment.models.dto.RevisionTypeDto;
import pl.szymonsmenda.backendAssignment.models.entites.NoteEntity;
import pl.szymonsmenda.backendAssignment.models.entites.NoteHistory;

public class Converters {

    public static NoteDto convert(NoteEntity source) {
        if (source == null) {
            return null;
        }
        return new NoteDto(source.getId(), source.getContent(), source.getTitle());
    }

    public static RevisionTypeDto convert(RevisionType source) {
        if (source == null) {
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

    public static NoteHistoryDto convert(NoteHistory source) {
        if (source == null) {
            return null;
        }
        NoteDto noteDto = convert(source.getNoteEntity());
        Long revision = source.getRevision().longValue();
        RevisionTypeDto revisionTypeDto = convert(source.getRevisionType());
        return new NoteHistoryDto(noteDto, revision, revisionTypeDto);
    }
}
