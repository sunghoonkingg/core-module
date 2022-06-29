package com.example.basiccrud.utills.validator;

public class UserValidator {


    public static void validateCreateUser(String username, String password) {
        if (username == null || username.trim().length() == 0) {
            throw new IllegalArgumentException("입력된 닉네임이 없습니다");
        }
        if (password == null || password.trim().length() == 0) {
            throw new IllegalArgumentException("입력된 비밀번호가 없습니다");
        }
        if (password.length() < 6) {
            throw new IllegalArgumentException("비밀번호를 6자 이상 입력해주세요");
        }


    }
}