/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.senac.es.loja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sala305b
 */
public class ConexaoFactory {
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        
        String drive = "com.mysql.jdbc.Driver";
        String banco = "jdbc:mysql://localhost:3306/bd_produto";
        String usuarioBD = "root";
        String senha = "";
        
        try { 
            Class.forName(drive);
            conn = DriverManager.getConnection(banco, usuarioBD, senha);
        } catch (SQLException e) { 
    		throw e; 
        } 
        return conn;
    } 
}
