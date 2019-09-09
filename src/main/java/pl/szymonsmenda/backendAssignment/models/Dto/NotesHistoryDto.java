package pl.szymonsmenda.backendAssignment.models.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotesHistoryDto {

    private final NotesDto notesDto;
    private final Long revision;
    private final RevisionTypeDto type;

    public NotesHistoryDto(NotesDto notesDto, Long revision, RevisionTypeDto type) {
        this.notesDto = notesDto;
        this.revision = revision;
        this.type = type;
    }

    @JsonProperty("notesDto")
    public NotesDto getNotesDto() {
        return notesDto;
    }

    @JsonProperty("revision")
    public Long getRevision() {
        return revision;
    }

    @JsonProperty("type")
    public RevisionTypeDto getType() {
        return type;
    }
}
