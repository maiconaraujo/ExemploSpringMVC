/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.es.loja.controller;

import br.senac.es.loja.dao.JpaTarefaDAO;
import br.senac.es.loja.model.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author MAICON
 */

@Controller
public class TarefasController {
    private final JpaTarefaDAO dao; 

    @Autowired
    public TarefasController(JpaTarefaDAO dao) {
        this.dao = dao; 
    }
    
    
    @RequestMapping("/cadastrar")
    public String cadastra(Tarefa tarefa) {
        dao.adiciona(tarefa);
        return "ok";
    }

    @RequestMapping("mostraTarefa")
    public String mostra(Long id, Model model) {
        model.addAttribute("tarefa", dao.buscaPorId(id));
        return "tarefa/mostra";
    }
}
