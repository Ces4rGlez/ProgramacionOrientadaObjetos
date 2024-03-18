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
import mx.utng.session26.model.entity.Curso;
import mx.utng.session26.model.service.ICursoService;
@Controller
@SessionAttributes("curso")
public class CursoController {
    
    @Autowired
    private ICursoService service;

    @GetMapping({"/curso", "/curso/", "/curso/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Cursos Impartidos");
        model.addAttribute("cursos", service.list());
        return "curso-list";
    }

    @GetMapping("/curso/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Cursos");
        model.addAttribute("curso", new Curso());
        return "curso-form";
    }

    @PostMapping("/curso/form")
    public String save(@Valid Curso curso, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Cursos");
            return "curso-form";
        }
        service.save(curso);
        return "redirect:/curso/list";
    }

    @GetMapping("/curso/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Curso curso = null;
        if(id>0){
        curso = service.getById(id);
        }else{
            return "redirect:/curso/list";
        }
        model.addAttribute("title", "Editar Curso");
        model.addAttribute("curso", curso);
        return "curso-form";
    }

    @GetMapping("/curso/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/curso/list";
    }



}
