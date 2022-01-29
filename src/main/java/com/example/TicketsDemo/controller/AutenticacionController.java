package com.example.TicketsDemo.controller;

import com.example.TicketsDemo.model.Cliente;
import com.example.TicketsDemo.model.Usuario;
import com.example.TicketsDemo.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/auth")
public class AutenticacionController {
    @Autowired
    UtilService utilService;

    @GetMapping("/login")
    public String loginTemplate(){return "login";}
    @GetMapping("/registro")
    public String registrarTemplate(Model model){
        Cliente cliente = new Cliente();
        model.addAttribute("Cliente",cliente);
        return  "registro";
    }

    @PostMapping("/registrausuario")
    public String registrarUsuario(@ModelAttribute("Cliente")Cliente cliente){
        if(utilService.registrarCliente(cliente)){
            return "redirect:/auth/login?success";
        }else{
            return "redirect:/auth/registro?error";
        }


    }
}
