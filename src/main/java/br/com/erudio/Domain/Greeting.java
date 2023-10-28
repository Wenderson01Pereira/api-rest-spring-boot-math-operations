package br.com.erudio.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Greeting {
    private final long id;
    private final String content;
}
