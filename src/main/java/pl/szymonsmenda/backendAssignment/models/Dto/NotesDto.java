package pl.szymonsmenda.backendAssignment.models.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotesDto {

    private final Long id;
    private final String content;
    private final String title;

    public NotesDto(@JsonProperty("id") Long id, @JsonProperty("content") String content, @JsonProperty("title") String title) {
        this.id = id;
        this.content = content;
        this.title = title;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }
}