package net.kieroth.javaee.cardapio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PratoDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public PratoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean insertPrato(Prato prato) throws SQLException {
        String sql = "INSERT INTO pratos (nome, ingredientes, preco) VALUES (?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, prato.getNome());
        statement.setString(2, prato.getIngredientes());
        statement.setFloat(3, prato.getPreco());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<Prato> listAllPratos() throws SQLException {
        List<Prato> listPrato = new ArrayList<>();
         
        String sql = "SELECT * FROM pratos";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String ingredientes = resultSet.getString("ingredientes");
            float preco = resultSet.getFloat("preco");
             
            Prato prato = new Prato(id, nome, ingredientes, preco);
            listPrato.add(prato);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listPrato;
    }
     
    public boolean deletePrato(Prato prato) throws SQLException {
        String sql = "DELETE FROM pratos where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, prato.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updatePrato(Prato prato) throws SQLException {
        String sql = "UPDATE pratos SET nome = ?, ingredientes = ?, preco = ?";
        sql += " WHERE id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, prato.getNome());
        statement.setString(2, prato.getIngredientes());
        statement.setFloat(3, prato.getPreco());
        statement.setInt(4, prato.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Prato getPrato(int id) throws SQLException {
        Prato prato = null;
        String sql = "SELECT * FROM pratos WHERE id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String nome = resultSet.getString("nome");
            String ingredientes = resultSet.getString("ingredientes");
            float preco = resultSet.getFloat("preco");
             
            prato = new Prato(id, nome, ingredientes, preco);
        }
         
        resultSet.close();
        statement.close();
         
        return prato;
    }
}
