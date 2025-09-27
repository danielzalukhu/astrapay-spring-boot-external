package com.astrapay.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class NoteDto {
    @NotEmpty
    @Size(max = 255, message = "Title must not exceed 255 characters")
    private String title;
    @NotEmpty
    @Size(max = 1024, message = "Content must not exceed 1024 characters")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}