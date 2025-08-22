 package com.aluguelbicicleta.aluguelbicicleta.controllers;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
 import org.springframework.security.authentication.AuthenticationManager;
 import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 import com.aluguelbicicleta.aluguelbicicleta.deserializer.AuthenticationDTO;
 import com.aluguelbicicleta.aluguelbicicleta.deserializer.LoginResponseDTO;
 import com.aluguelbicicleta.aluguelbicicleta.model.User;
 import com.aluguelbicicleta.aluguelbicicleta.repository.UserRepository;
 import com.aluguelbicicleta.aluguelbicicleta.services.TokenService;

 @RestController
 @RequestMapping("/auth")
 public class AuthenticationController {

     @Autowired
     AuthenticationManager authenticationManager;

     @Autowired
     UserRepository userRepository;

     @Autowired
     TokenService tokenService;

     @PostMapping("/login")
     public ResponseEntity login(@RequestBody AuthenticationDTO data){
         var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
         var auth = this.authenticationManager.authenticate(usernamePassword);

         var token = tokenService.generateToken((User) auth.getPrincipal());

         return ResponseEntity.ok(new LoginResponseDTO(token));
     }

     @PostMapping("/register")
     public ResponseEntity register(@RequestBody User u){
         if(this.userRepository.findByLogin(u.getLogin()) != null) return ResponseEntity.badRequest().build();

         String encryptedPassword = new BCryptPasswordEncoder().encode(u.getSenha());
         u.setSenha(encryptedPassword);
         this.userRepository.save(u);
         return ResponseEntity.ok().build();
     }
    
 }
