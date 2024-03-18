package mx.utng.session26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.session26.model.entity.Calificacion;
import mx.utng.session26.model.service.ICalificacionService;


@Controller
@SessionAttributes("calificacion")
public class CalificacionController {
    
    @Autowired
    private ICalificacionService service;

    @GetMapping({"/calificacion", "/calificacion/", "/calificacion/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Calificaciones");
        model.addAttribute("calificaciones", service.list());
        return "calificacion-list";
    }

    @GetMapping("/calificacion/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario para Calificaciones");
        model.addAttribute("calificacion", new Calificacion());
        return "calificacion-form";
    }

    @PostMapping("/calificacion/form")
    public String save(@Valid Calificacion calificacion, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario para Calificaciones");
            return "calificacion-form";
        }
        service.save(calificacion);
        return "redirect:/calificacion/list";
    }

    @GetMapping("/calificacion/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Calificacion calificacion = null;
        if(id>0){
            calificacion = service.getById(id);
        }else{
            return "redirect:/calificacion/list";
        }
        model.addAttribute("title", "Editar Calificaciones");
        model.addAttribute("calificacion", calificacion);
        return "calificacion-form";
    }

    @GetMapping("/calificacion/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/calificacion/list";
    }



}
