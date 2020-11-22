/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.es.loja.dao;

import br.senac.es.loja.model.Tarefa;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MAICON
 */

@Repository
public class JpaTarefaDAO {
    @PersistenceContext
    private EntityManager manager;
    
public void adiciona(Tarefa tarefa) {
        manager.persist(tarefa);
    }

    public void altera(Tarefa tarefa) {
        manager.merge(tarefa);
    }

    public List<Tarefa> lista() {
        return manager.createQuery("select t from Tarefa t").getResultList();
    }

    public Tarefa buscaPorId(Long id) {
        return manager.find(Tarefa.class, id);
    }

    public void remove(Tarefa tarefa) {
        Tarefa tarefaARemover = buscaPorId(tarefa.getId());
        manager.remove(tarefaARemover);
    }

    public void finaliza(Long id) {
        Tarefa tarefa = buscaPorId(id);
        tarefa.setFinalizado(true);
        tarefa.setDataFinalizacao(Calendar.getInstance());
        manager.merge(tarefa);
    }    
    
}
