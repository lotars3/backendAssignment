package pl.szymonsmenda.backendAssignment.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NoteHistoryDto {

    private final NoteDto noteDto;
    private final Long revision;
    private final RevisionTypeDto type;

    public NoteHistoryDto(NoteDto noteDto, Long revision, RevisionTypeDto type) {
        this.noteDto = noteDto;
        this.revision = revision;
        this.type = type;
    }

    @JsonProperty("noteDto")
    public NoteDto getNoteDto() {
        return noteDto;
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
