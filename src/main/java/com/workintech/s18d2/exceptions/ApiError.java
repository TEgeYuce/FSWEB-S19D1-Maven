package com.workintech.s18d2.exceptions;
import lombok.Data;
import lombok.Builder;
import java.time.Instant;

@Data
@Builder
public class ApiError {

    private Instant timestamp;
    private int status;
    private String error;
    private String message;
    private String path;


}

