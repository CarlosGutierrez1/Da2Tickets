package com.example.TicketsDemo.controller;

//import org.springframework.security.core.Authentication;
import com.example.TicketsDemo.model.Usuario;
import com.example.TicketsDemo.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    UtilService utilService;
@GetMapping("/login")
public String log() {
    return "login";
}

    @GetMapping("/noAuth")
    public String noAuthentication() {
        return "noautorizado";
    }

    @PostMapping("/validlogin")
    public @ResponseBody String validateLogin(@RequestParam String  json, Model model){
        Usuario user = (new Gson()).fromJson(json, Usuario.class);
        List<Usuario> users = utilService.obtenerUsuarioConCredenciales(user);
        if(users.size()!=0){
            return users.get(0).getIdUsuario().toString();
        }else{
            return "Not found";
        }
    }

}
