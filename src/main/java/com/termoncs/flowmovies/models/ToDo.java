package com.termoncs.flowmovies.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class ToDo {
    private Long id;
    private String title;
    private boolean done;
}
