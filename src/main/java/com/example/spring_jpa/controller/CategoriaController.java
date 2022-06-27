/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.spring_jpa.controller;


import com.example.spring_jpa.entity.Categoria;
import com.example.spring_jpa.servicios.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping("/cate")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping("/all")
    public String listarCate(Model model){
        model.addAttribute("categorias", categoriaService.readAll());
        return "cate/listarCat";
    }
    @GetMapping("/form")
    public String createCate(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("cate", new Categoria());
        return "formAdd";
    }
    @PostMapping("/add")
    public String saveCate(Model model, Categoria cat){
        model.addAttribute("categorias", categoriaService.readAll());
        return "listarCat";
    }
    @PostMapping("/del/{id}")
    public String deleteCate(Model model, @PathVariable("id") Integer idcat ){
        categoriaService.delete(idcat);
        return "redirect:/cate";
    }
    @PostMapping("/{id}")
    public String readCate(Model model, @PathVariable("id") Integer idcat ){
        model.addAttribute("cate", categoriaService.read(idcat));

        return "redirect:/cate";
    }
    
}
