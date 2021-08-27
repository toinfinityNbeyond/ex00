package com.example.ex00.sample;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@ToString
@Component
@Setter
public class Restaurant {

//        @Qualifier("englandChef") // 빈이 여러개가 있으면 그 중에 하나를 특정해 주는 것
//
//    @Autowired
    private Chef chef;



}