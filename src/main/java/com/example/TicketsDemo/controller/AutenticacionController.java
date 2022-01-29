package com.example.TicketsDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AutenticacionController {
    @GetMapping("/login")
    public String loginTemplate(){return "login";}
    @GetMapping("/registro")
    public String registrarTemplate(){return  "registro";}
    @PostMapping("")
    public String registrarUsuario(@RequestParam("user")String usuario, @RequestParam("pass")String contrasena,
                                   @RequestParam("nombre")String nombre, @RequestParam("tipoDoc")String tipoDoc,
                                   @RequestParam("numDoc")int numDoc, @RequestParam("empresa")String empresa,
                                   @RequestParam("cargo")String cargo, @RequestParam("email")String correo){

        return "";
    }
}
