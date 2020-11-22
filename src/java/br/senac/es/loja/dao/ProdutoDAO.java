/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.es.loja.dao;

// Essa classe utiliza o padrao de projetos DAO (Data Access Object)

import br.senac.es.loja.model.Imagem;
import br.senac.es.loja.model.Produto;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;



public class ProdutoDAO {
    
    public void inserir(Produto p, InputStream i, long size) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  ps = null;
        ResultSet rs = null;
        String SQL = "";
        
        // Obtem conexao com BD
        conn = ConexaoFactory.getConnection();
        
        // Comando SQL 
        SQL = "INSERT INTO produtos (descricao, imagem) " +
                                     "VALUES (?, ?)";

        ps = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

        ps.setString(1, p.getDescricao());            
        
        ps.setBinaryStream(2, i, size);
        // Executa no BD        
        ps.executeUpdate();  

        ps.close();
        conn.close();       
    }
    
    public Imagem getImagem(int codigo)throws Exception{
        Connection conn = null;
        PreparedStatement  preparedStatement = null;
        ResultSet rs = null;
        String SQL = "";
        //ImageIcon imagem = null;       
        // Obtem conexao com BD
     
        Imagem img = null;
        
        conn = ConexaoFactory.getConnection();
        
        // Comando SQL 
        SQL = "SELECT * from produtos where codigo = ?";

        preparedStatement = conn.prepareStatement(SQL);
        preparedStatement.setInt(1, codigo);
        
        try{
        // Para buscar informações
        rs = preparedStatement.executeQuery();   
      
            
            if (rs.next()) {
                img = new Imagem();
                //img.setCodigo(rs.getInt("codigo"));
                img.setImagem(rs.getBytes("imagem"));
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return img;
    }
    public ArrayList listar() throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  ps = null;
        ResultSet rs = null;
        String SQL = "";
        ArrayList<Produto> lista = new ArrayList<>();
                
        // Obtem conexao com BD
        conn = ConexaoFactory.getConnection();
        
        // Comando SQL 
        SQL = "select codigo, descricao, imagem "
                + "from produtos ";
        

        ps = conn.prepareStatement(SQL);

        // Para buscar informações
        rs = ps.executeQuery();   

        // Verifica se possui dados
        while (rs.next()) {
            
            Produto p = new Produto();           
            
            p.setCodigo(rs.getInt("codigo"));
            p.setDescricao(rs.getString("descricao"));

            lista.add(p);
         } 
        
        ps.close();
        rs.close();
        conn.close();
        
        return lista;
        
    } 
    
    public void excluir2(int codigoProduto) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  ps = null;
        String SQL = "";
        
        // Obtem conexao com BD
        conn = ConexaoFactory.getConnection();
        
        // Comando SQL 
        SQL = "DELETE FROM produtos WHERE codigo = ?";

        ps = conn.prepareStatement(SQL);

        ps.setInt(1, codigoProduto);
        
        // Executa no BD        
        ps.executeUpdate();  

        ps.close();
        conn.close();       
    }
    
    
    public ArrayList listar2() throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  ps = null;
        ResultSet rs = null;
        String SQL = "";
        ArrayList<Produto> lista = new ArrayList<>();
                
        // Obtem conexao com BD
        conn = ConexaoFactory.getConnection();
        
        // Comando SQL 
        SQL = "select codigo, descricao, valor, dataCadastro "
                + "from produtos ";
        

        ps = conn.prepareStatement(SQL);

        // Para buscar informações
        rs = ps.executeQuery();   

        // Verifica se possui dados
        while (rs.next()) {
            
            Produto p = new Produto();           
            
            p.setCodigo(rs.getInt("codigo"));
            p.setDescricao(rs.getString("descricao"));
            p.setValor(rs.getFloat("valor"));            
            
            try{
                
                Calendar dataCadastro = Calendar.getInstance();
                dataCadastro.setTime(new Date(rs.getTimestamp("dataCadastro").getTime()));                
               
                p.setDataCadastro(dataCadastro);
            }catch (Exception ex){
            }
            
            lista.add(p);
         } 
        
        ps.close();
        rs.close();
        conn.close();
        
        return lista;
        
    } 
    
    public void excluir(int codigoProduto) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  ps = null;
        String SQL = "";
        
        // Obtem conexao com BD
        conn = ConexaoFactory.getConnection();
        
        // Comando SQL 
        SQL = "DELETE FROM produtos WHERE codigo = ?";

        ps = conn.prepareStatement(SQL);

        ps.setInt(1, codigoProduto);
        
        // Executa no BD        
        ps.executeUpdate();  

        ps.close();
        conn.close();       
    }
    
    
    public void alterar(Produto p)throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  ps = null;
        String SQL = "";
        
        // Obtem conexao com BD
        conn = ConexaoFactory.getConnection();
        
        // Comando SQL 
        SQL = "UPDATE produtos SET descricao = ?, valor = ? WHERE codigo = ?";

        ps = conn.prepareStatement(SQL);

        ps.setString(1, p.getDescricao());
        ps.setFloat(2, p.getValor());
        ps.setInt(3, p.getCodigo());
        
        // Executa no BD        
        ps.executeUpdate();  

        ps.close();
        conn.close();   
    }
    
    public Produto buscar(int codigoProduto) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  ps = null;
        ResultSet rs = null;
        String SQL = "";
        Produto produto = null;
                
        // Obtem conexao com BD
        conn = ConexaoFactory.getConnection();
        
        // Comando SQL 
        SQL = "SELECT codigo, descricao, valor "
                + "FROM produtos WHERE codigo = ?";        

        ps = conn.prepareStatement(SQL);
        
        ps.setInt(1, codigoProduto);

        // Para buscar informações
        rs = ps.executeQuery();   

        // Verifica se possui dados
        if (rs.next()) {
            
            produto = new Produto();           
            
            produto.setCodigo(rs.getInt("codigo"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setValor(rs.getFloat("valor"));
         } 
        
        ps.close();
        rs.close();
        conn.close();
        
        return produto;
    }
    
}
     
