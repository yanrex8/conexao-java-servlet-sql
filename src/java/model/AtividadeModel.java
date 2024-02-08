package model;

/**
 *
 * @author Yan Ribon
 */
public class AtividadeModel
{

    private int id;
    private String yan;
    private String ribon;
    private float nota;

    public AtividadeModel(int id, String yan, String ribon, float nota)
    {
        this.id = id;
        this.yan = yan;
        this.ribon = ribon;
        this.nota = nota;
    }

    public AtividadeModel()
    {
        this(0, "", "", 0);
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getYan()
    {
        return yan;
    }

    public void setYan(String yan)
    {
        this.yan = yan;
    }

    public String getRibon()
    {
        return ribon;
    }

    public void setRibon(String ribon)
    {
        this.ribon = ribon;
    }

    public float getNota()
    {
        return nota;
    }

    public void setNota(float nota)
    {
        this.nota = nota;
    }

}
