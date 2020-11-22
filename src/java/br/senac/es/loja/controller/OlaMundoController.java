/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.es.loja.controller;

import br.senac.es.loja.dao.ProdutoDAO;
import br.senac.es.loja.model.Imagem;
import br.senac.es.loja.model.Produto;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MAICON
 */
@Controller
public class OlaMundoController {

    @RequestMapping("/olaMundoSpring")
    public String exibir() {
        System.out.println("Executando a lógica com Spring MVC");
        return "ok";
    }

    @RequestMapping("/")
    public String iniciar() {
        return "cadastrar-tarefa";
    }

    @RequestMapping("/adicionaProduto")
    public String adiciona(Produto produto) {
        System.out.println("produto: " + produto);
        return "ok";
    }

    @RequestMapping("/form")
    public String form() {
        return "form";
    }

    @RequestMapping(value = "/inserir")
    @ResponseBody
    public Produto inserir(Produto produto) {
        produto.setCodigo(10);
        produto.setDescricao("Teste Ajax");

        return produto;
    }

    @RequestMapping(value = "/cadastrar")
    public String cadastrar(MultipartFile imagem) {
        try {
            InputStream inputStream = imagem.getInputStream();

            ProdutoDAO dao = new ProdutoDAO();
            Produto produto = new Produto();
            produto.setDescricao("produto com imagem");
            dao.inserir(produto, inputStream, imagem.getSize());
            
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(OlaMundoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "listar";
    }

    @RequestMapping("/carregarImagem")
    @ResponseBody
    public void carregarImagem(int codigo, HttpServletResponse response) {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            Imagem img = dao.getImagem(codigo);
            
            response.getOutputStream().write(img.getImagem());
        } catch (Exception ex) {
            Logger.getLogger(OlaMundoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
}
