package br.com.erudio.Domain.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1;

    private Date timestamp;
    private String message;
    private String details;

}
