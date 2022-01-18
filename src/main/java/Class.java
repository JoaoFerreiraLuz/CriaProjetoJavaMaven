import java.util.ArrayList;

public class Class {

    private String titulo;
    private String[] atributos;
    private Boolean metDef;
    private Boolean entitie;
    private Boolean vo;
    private Boolean controller;

    public Class(){}

    public String getTitulo() {return titulo;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String[] getAtributos() {return atributos;}

    public void setAtributos(String[] atributos) { this.atributos = atributos;}

    public Boolean getMetDef() {return metDef;}

    public void setMetDef(Boolean metDef) {this.metDef = metDef;}

    public Boolean getEntitie() {return entitie;}

    public void setEntitie(Boolean entitie) {this.entitie = entitie;}

    public Boolean getVo() {return vo;}

    public void setVo(Boolean vo) {this.vo = vo;}

    public Boolean getController() {return controller;}

    public void setController(Boolean controller) {this.controller = controller;}
}
