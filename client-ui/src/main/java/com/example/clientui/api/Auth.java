package com.example.clientui.api;

import com.example.clientui.output.ApiResponse;
import com.example.clientui.output.JwtAuthenticationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.java.main.springstarter.v1.dtos.SignInDTO;
import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping("/auth")
public class Auth {


    @PostMapping("/signin")
    String login(@ModelAttribute SignInDTO signIn, Model model){

        RestTemplate restTemplate = new RestTemplate();

        SignInDTO requestBody = signIn;

        System.out.println("=======================");
        System.out.println("=========RECEIVED DTO========");
        System.out.println(signIn.getEmail());
        System.out.println(signIn.getPassword());
        System.out.println("=======================");

        ResponseEntity<JwtAuthenticationResponse> res = restTemplate.postForEntity("http://localhost:4000/api/v1/auth/signin", requestBody, JwtAuthenticationResponse.class);


        System.out.println("=======================");
        System.out.println("=========ANSWER========");
        System.out.println(res.getBody());
        System.out.println("=======================");

        return "login";
    }
}
