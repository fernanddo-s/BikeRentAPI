package com.aluguelbicicleta.aluguelbicicleta.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aluguelbicicleta.aluguelbicicleta.model.User;

@RestController
@RequestMapping("/user")
public class UserController {
    
    // public User 

}
/*
 * posso ter uma entidade aluguel que gurada os dados
 * tem um campo devolvel, depois de devolver muda a flag
 * dessa forma da pra ter um historico de alugueis, mostrando alugueis com a flad de devolução
 * verifica se o usuario tem algum aluguel com a flag de já ter alugado alguma coisa e tal.
 */