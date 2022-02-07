package com.example.TicketsDemo.controller;

import com.example.TicketsDemo.model.*;
import com.example.TicketsDemo.service.UtilService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Collections;
import java.util.List;


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
    public String registrarSoporte(@ModelAttribute("Ticket")Ticket ticket,Principal principal, Model model){
        boolean estado = utilService.registrarTicket(ticket,principal.getName().toString());
        if (estado){
            ticket.setPrioridad(utilService.obtenerTipoPrioridadPorId(ticket.getIdPrioridad()));
            model.addAttribute("ticket",ticket);
            return  "detalleticket";
        }
        else{return  "redirect:/index/pedirsoporte?error";}
    }
    @GetMapping("/tickets")
    public String ticketsTemplate(Model model,Principal principal, Authentication authentication){
        List<Ticket> tickets;
        String rol = utilService.obtenerRolUsuarioPorCorreo(principal.getName());
        if(rol.equals("ROL_C")){
            tickets = utilService.obtenerTicketsHechosPorUnUsuario(principal.getName().toString());
        }else if (rol.equals("ROL_S")){
            tickets = utilService.obtenerTodosLosTiketsConEstadoDisponible();
        }else{
            tickets = utilService.obtenerTicketsAsignadosATecnico(principal.getName().toString());

        }
        model.addAttribute("tickets",tickets);
        return "tickets";
    }
    @PostMapping("/detalleticket")
    public String detalleTicket(@RequestParam("idTicket")Long idTicket, Model model, Principal principal){
        String rol = utilService.obtenerRolUsuarioPorCorreo(principal.getName());

        if(rol.equals("ROL_S")){
            model.addAttribute("tecnicos",utilService.obtenerTodosLosTecnicos());
        }
        model.addAttribute("ticket",utilService.obtenerTicketPorIdTicket(idTicket));
        return "/detalleticket";
    }

    @GetMapping("/buscarticket")
    public String buscarTicket(){
        return "/buscarticket";
    }

    @PostMapping("/detalleticketbuscado")
    public String detalleTicketBuscado(@RequestParam("numTicket")String numTicket, Model model){
        model.addAttribute("ticket",utilService.obtenerTicketPorNumTicket(numTicket));
        return "/detalleticket";
    }
    @PostMapping("/asignartecnico")
    public String asignarTecnicoATicket(@RequestParam("idTecnico")Long idTecnico, @RequestParam("idTicket")Long idTicket, Model model){
        if (utilService.asignarTecnicoATicket(idTecnico,idTicket)){
            return "redirect:/index/tickets?success";
        }else{
            return "redirect:/index/tickets?error";
        }
    }
    @PostMapping("/marcarresuleto")
    public String marcarTicketComoResuelto(@RequestParam("idTicket1")Long idTicket, Model model){
        if (utilService.marcarTicketComoResuelto(idTicket)){
            return "redirect:/index/tickets?success";
        }else{
            return "redirect:/index/tickets?error2";
        }
    }
}
