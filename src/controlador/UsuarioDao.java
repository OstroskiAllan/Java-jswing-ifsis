package controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author Marcelo Rafael Borth
 */
public class UsuarioDao {

    public int inserir(Usuario u) throws Exception {
        int retorno;

        String sql = "insert into usuario (nome, email, senha, status)"
                + "values (?, ?, ?, ?)";

        Connection conexao = Conexao.getConexao();
        try ( PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getSenha());
            ps.setString(4, u.getStatus().toString());

            retorno = ps.executeUpdate();
        }

        return retorno;
    }
    
    
    
    public List<Usuario>buscar(String nome)throws Exception{
        Connection conexao = Conexao.getConexao();
        String sql = "select * from usuario";
        
        if(!nome.equals("")){
            sql += " where nome like ?";
        }
        
        sql += " order by nome";
        
        List<Usuario> lista = new ArrayList<>();
        
        try(PreparedStatement ps = conexao.prepareStatement(sql)){
            if(!nome.equals("")){
                ps.setString(1, "%" + nome + "%");
            }
            
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Usuario u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setNome(rs.getString("nome"));
                    u.setEmail(rs.getString("email"));
                    u.setStatus(rs.getInt("status"));
                    
                    
                    lista.add(u);
                }
            }
            
        }catch (Exception e){
            throw e;
        }
        
        return lista;
    }
    public Usuario getUsuario(int id) throws Exception {
        Connection conexao = Conexao.getConexao();
        String sql = "select * from usuario where id = ?";
        
        Usuario obj = null;
        
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            //Parâmetros da SQL (pode ser mais de 1 param)
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    obj = new Usuario();
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setEmail(rs.getString("email"));
                    obj.setStatus(rs.getInt("status"));
                }
            }
        } catch (Exception e) {
            throw e;
        }
        
        return obj;
    }

    public int atualizar(Usuario u) throws Exception {
        int retorno;

        String sql = "update usuario"
                + "      set nome  = ?,"
                + "          email = ?,"
                + "          status = ?"
                + "    where id    = ?";

        Connection conexao = Conexao.getConexao();
        try ( PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getStatus().toString());
            ps.setInt(4, u.getId());

            retorno = ps.executeUpdate();
        }

        return retorno;
    }

    public void excluir(Integer id) throws Exception{
        String sql = "delete from usuario where id = ?";
        
        Connection conexao = Conexao.getConexao();
        try (PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setInt(1, id);
            
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }
        
    }

}

