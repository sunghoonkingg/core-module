package com.example.basiccrud.utills.validator;

public class SubjectValidator {

    public static void validateCreateSubject(String subject){

        if(subject == null || subject.trim().length() == 0){
            throw new IllegalArgumentException("입력된 과목이 없습니다");
        }
    }
}
