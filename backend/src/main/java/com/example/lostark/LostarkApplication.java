package com.example.lostark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LostarkApplication {

    public static void main(String[] args) {
        System.out.println("🚀 LostarkApplication 시작 준비 중...");
        SpringApplication.run(LostarkApplication.class, args);
        System.out.println("✅ LostarkApplication 실행 완료!");
    }

}
