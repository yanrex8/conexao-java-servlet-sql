package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.AtividadeModel;

/**
 *
 * @author Yan Ribon
 */
public class AtividadeData extends Conexao
{

    public AtividadeData() throws Exception
    {

    }

    public boolean incluir(AtividadeModel obj) throws SQLException
    {
        String sql = "insert into YanGuilhermeRibon (yan, ribon, nota) values (?, ?, ?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);

        ps.setString(1, obj.getYan());
        ps.setString(2, obj.getRibon());
        ps.setFloat(3, obj.getNota());

        int linhas = ps.executeUpdate();

        if (linhas > 0)
        {
            System.out.println(linhas + "linha(s) alterada(s).");
            return true;
        }
        else
        {
            return false;
        }

    }

    public boolean excluir(int id) throws SQLException
    {
        String sql = "delete from YanGuilhermeRibon where id = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);

        ps.setInt(1, id);

        int linhas = ps.executeUpdate();

        if (linhas > 0)
        {
            System.out.println(linhas + "linha(s) alterada(s).");
            return true;
        }
        else
        {
            return false;
        }

    }

    public boolean atualizar(AtividadeModel obj) throws SQLException
    {
        String sql = "update YanGuilhermeRibon set yan = ?, ribon = ?, nota = ? where id = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);

        ps.setString(1, obj.getYan());
        ps.setString(2, obj.getRibon());
        ps.setFloat(3, obj.getNota());
        ps.setInt(4, obj.getId());

        int linhas = ps.executeUpdate();

        if (linhas > 0)
        {
            System.out.println(linhas + "linha(s) alterada(s).");
            return true;
        }
        else
        {
            return false;
        }

    }

    public ArrayList<AtividadeModel> listar() throws SQLException
    {
        ArrayList<AtividadeModel> listaDados = new ArrayList<>();
        AtividadeModel obj = new AtividadeModel();
        String sql = "select * from YanGuilhermeRibon";
        PreparedStatement ps = getConexao().prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            obj = new AtividadeModel(rs.getInt("id"), rs.getString("yan"), rs.getString("ribon"), rs.getFloat("nota"));
            listaDados.add(obj);
        }

        return listaDados;

    }

    public AtividadeModel obter(int id) throws SQLException
    {
        AtividadeModel obj = new AtividadeModel();
        String sql = "select * from YanGuilhermeRibon where id = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            obj = new AtividadeModel(rs.getInt("id"), rs.getString("yan"), rs.getString("ribon"), rs.getFloat("nota"));
        }

        return obj;
    }

    public ArrayList<AtividadeModel> pesquisar(String pesquisa) throws SQLException
    {
        ArrayList<AtividadeModel> listaDados = new ArrayList<>();
        AtividadeModel obj = new AtividadeModel();
        String sql = "select * from YanGuilhermeRibon where yan = '%?%' or ribon = '%?%'";
        PreparedStatement ps = getConexao().prepareStatement(sql);

        ps.setString(1, pesquisa);
        ps.setString(2, pesquisa);

        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            obj = new AtividadeModel(rs.getInt("id"), rs.getString("yan"), rs.getString("ribon"), rs.getFloat("nota"));
            listaDados.add(obj);
        }

        return listaDados;

    }

}
