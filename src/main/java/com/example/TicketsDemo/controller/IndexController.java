package com.example.TicketsDemo.controller;

import com.example.TicketsDemo.model.Cliente;
import com.example.TicketsDemo.model.Ticket;
import com.example.TicketsDemo.model.Usuario;
import com.example.TicketsDemo.service.UtilService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.security.Principal;


@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    UtilService utilService;


    @GetMapping("")
    public String index(Model model){
return "index";
    }
    @GetMapping("/pedirsoporte")
    public String pedirSoporte(Model model){
        Ticket ticket = new Ticket();
        model.addAttribute("Ticket",ticket);
        return "pedirsoporte";
    }

    @PostMapping("/registrarsoporte")
    public String registrarSoporte(@ModelAttribute("Ticket")Ticket ticket,Principal principal){
        boolean estado = utilService.registrarTicket(ticket,principal.getName().toString());
        if (estado){return "/index";}
        else{return "redirect:/index/pedirsoporte?error";}
    }
}
