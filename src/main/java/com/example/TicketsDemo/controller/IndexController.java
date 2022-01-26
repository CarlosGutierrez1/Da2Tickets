package com.example.TicketsDemo.controller;

import com.example.TicketsDemo.model.Ticket;
import com.example.TicketsDemo.model.Usuario;
import com.example.TicketsDemo.service.UtilService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
@RequestMapping("")
public class IndexController {

    @Autowired
    UtilService utilService;


    @GetMapping("")
public String index(Model model){
return "index";
    }
    @GetMapping("/pedirsoporte")
    public String pedirSoporte(){return "pedirsoporte";}
    @PostMapping("/registrarsoporte")
    public @ResponseBody String registrarSoporte(@RequestParam String  json){
        Ticket ticket = (new Gson()).fromJson(json, Ticket.class);
        String estado = utilService.registrarTicket(ticket);
        System.out.println(estado);
        return estado;
    }
}
