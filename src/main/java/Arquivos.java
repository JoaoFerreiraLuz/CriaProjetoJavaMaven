import java.util.ArrayList;

public class Arquivos {

    private String caminhofront;
    private String caminhoback;
    private Boolean b;

    public static final String C = "Controller";
    public static final String F = "FrontEnd";
    public static final String E = "Entity";
    public static final String V = "Vo";
    public static final String A = "Api";
    public static final String M = "Mapper";

    public Arquivos(){}

    public String getCaminhofront() {return caminhofront;}

    public void setCaminhofront(String caminhofront) {this.caminhofront = caminhofront;}

    public String getCaminhoback() {return caminhoback;}

    public void setCaminhoback(String caminhoback) {this.caminhoback = caminhoback;}

    public Boolean getB() {return b;}

    public void setB(Boolean b) {this.b = b;}

}
