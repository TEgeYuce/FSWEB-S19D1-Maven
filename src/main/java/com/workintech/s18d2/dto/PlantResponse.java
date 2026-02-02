package com.workintech.s18d2.dto;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlantResponse<T> {

    private String message;
    private T data;

    public static <T> PlantResponse<T> success(String message, T data) {
        return new PlantResponse<>(message, data);
    }


}

