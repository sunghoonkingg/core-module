package com.example.basiccrud.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class SubjectRequestDto {

    private String subjectName;


    public SubjectRequestDto(String subjectName) {
        this.subjectName = subjectName;
    }
}
