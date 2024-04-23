/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import factory.ConnectionFactory;
import modelo.Aluno;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author vinia
 */
public class AlunoDao {
    private Connection connection;
    
    public AlunoDao() {
        this.connection = new ConnectionFactory().getConnection();
}
    public void adiciona(Aluno aluno){ 
        String sql = "INSERT INTO aluno(cpf, nome, data_nascimento, peso, altura) VALUES(?, ?, ?, ?, ?)";
            try { 
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, aluno.getCpf()); // Define o CPF
                stmt.setString(2, aluno.getNome()); // Define o nome
                stmt.setString(3, aluno.getData()); // Define a data de nascimento
                stmt.setFloat(4, aluno.getPeso()); // Define o peso
                stmt.setFloat(5, aluno.getAltura()); // Define a altura
                stmt.execute();
                stmt.close();
            } 
            catch (SQLException u) { 
                throw new RuntimeException(u);
            } 

        } 
    public void remove(String cpf){
        String sql = "delete from aluno where cpf = ?;";
        
    }
    public void atualiza(String cpf){
    
    }
    public void consultar(Aluno aluno, JLabel jLabelnome, JLabel jLabelcpf, JLabel jLabeldata, JLabel jLabelaltura, JLabel jLabelpeso){
         String cpf = aluno.getCpf(); // Obtém o CPF do aluno
         String sql = "SELECT * FROM aluno WHERE cpf = ?";
         
         try {
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, cpf);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            // Se o aluno for encontrado, preencha os JLabels com os dados retornados
            jLabelnome.setText(rs.getString("nome"));
            jLabelcpf.setText(rs.getString("cpf"));
            jLabeldata.setText(rs.getString("data_nascimento"));
            jLabelaltura.setText(rs.getString("altura"));
            jLabelpeso.setText(rs.getString("peso"));
        } else {
            // Se nenhum aluno for encontrado com o CPF fornecido, exiba uma mensagem de erro
            JOptionPane.showMessageDialog(null, "Aluno não encontrado");
        }

        rs.close();
        stmt.close();
    } catch (SQLException u) {
        throw new RuntimeException(u);
    }
        
    }
}
