/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Modelo.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class ContatoDAO {
    private Connection con;

    public void inserir(Contato c) {
        try {
            Connection con = Conexao.getConnection();

            String sql = "insert into contato " + "(nome,endereço,telefone,email)" + " values (?,?,?,?)";
            PreparedStatement stam = con.prepareStatement(sql);
            stam.setString(1, c.getNome());
            stam.setString(2, c.getEndereco());
            stam.setString(3, c.getTelefone());
            stam.setString(4, c.getEmail());
            stam.execute();
            stam.close();
            stam.close();
            con.close();

            new JOptionPane().showMessageDialog(null, "Cadastro Realizado com Sucesso.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<List<String>> tabList(String tname) {
        List<List<String>> listr = new ArrayList<List<String>>();
 		List<String> listc = new ArrayList<String>();
 		int numCol;
		try {
			con = Conexao.getConnection();

			Statement stam = con.createStatement();
			ResultSet res = stam.executeQuery("SELECT * FROM "+ tname);
                        ResultSetMetaData rsmd = res.getMetaData();
                        numCol = rsmd.getColumnCount();
			
			while(res.next()){
				listc = new ArrayList<String>();
				for(int i = 2; i <= numCol; i++){
					listc.add(res.getString(i));
				}
				listr.add(listc);
			}
			
			stam.close();
			res.close();
			con.close();
		

		} catch (Exception e) {
			e.printStackTrace();                        
		}
		return listr;
    }
    
    public List<List<String>> delList(String tname) {
        List<List<String>> listr = new ArrayList<List<String>>();
 		List<String> listc = new ArrayList<String>();
 		int numCol;
		try {
			con = Conexao.getConnection();

			Statement stam = con.createStatement();
			ResultSet res = stam.executeQuery("SELECT * FROM "+ tname);
			 ResultSetMetaData rsmd = res.getMetaData();
                        numCol = rsmd.getColumnCount();
                        
			while(res.next()){
				listc = new ArrayList<String>();
				for(int i = 1; i <= numCol; i++){
					listc.add(res.getString(i));
				}
				listr.add(listc);
			}
			
			stam.close();
			res.close();
			con.close();
		

		} catch (Exception e) {
			e.printStackTrace();                        
		}
		return listr;
    }
    
    public List<List<String>> busca(String tname, String bname) {
        List<List<String>> listr = new ArrayList<List<String>>();
 		List<String> listc = new ArrayList<String>();
 		int numCol;
		try {
			con = Conexao.getConnection();

			Statement stam = con.createStatement();
			ResultSet res = stam.executeQuery("SELECT * FROM "+ tname +" WHERE nome LIKE '%"+bname+"%'");
                        ResultSetMetaData rsmd = res.getMetaData();
                        numCol = rsmd.getColumnCount();
			
			while(res.next()){
				listc = new ArrayList<String>();
				for(int i = 2; i <= numCol; i++){
					listc.add(res.getString(i));
				}
				listr.add(listc);
			}
			
			stam.close();
			res.close();
			con.close();
		

		} catch (Exception e) {
			e.printStackTrace();                        
		}
		return listr;
    }
    
    public List<List<String>> editList(String tname, int id) {
        List<List<String>> listr = new ArrayList<List<String>>();
 		List<String> listc = new ArrayList<String>();
 		int numCol;
		try {
			con = Conexao.getConnection();

			Statement stam = con.createStatement();
			ResultSet res = stam.executeQuery("SELECT * FROM "+ tname +" WHERE id = "+id);
                        ResultSetMetaData rsmd = res.getMetaData();
                        numCol = rsmd.getColumnCount();
			
			while(res.next()){
				listc = new ArrayList<String>();
				for(int i = 1; i <= numCol; i++){
					listc.add(res.getString(i));
				}
				listr.add(listc);
			}
			
			stam.close();
			res.close();
			con.close();
		

		} catch (Exception e) {
			e.printStackTrace();                        
		}
		return listr;
    }

    public void delete(int cod) {
        con = Conexao.getConnection();

        try {
            String sql = "DELETE FROM contato WHERE id = " + cod;
            Statement stm = con.createStatement();
            stm.execute(sql);

            stm.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "erro");
        }
    }
    
    public void update(Contato c, int cod) {
        try {
            con = Conexao.getConnection();
            String sql = "UPDATE contato SET nome = '" + c.getNome()
                    + "', endereço = '" + c.getEndereco()
                    + "', telefone = '" + c.getTelefone()
                    + "', email = '" + c.getEmail()
                    + "' WHERE id = " + cod;
            Statement stm = con.createStatement();
            stm.execute(sql);

            stm.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "erro");
        }
    }
    
}
