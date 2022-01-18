package Form;

import java.util.ArrayList;

public class Formt {

    public static ArrayList<String> converGetESet(String s) {
        String[] aux = s.split("/");
        ArrayList<String> getEset = new ArrayList<>();

        if(aux[0].length() < 3) {
            aux[0] = verTip(aux[0]);
        }
        String tAtri = formTit(aux[1]);
        String get = aux[0] +" get"+ tAtri +"() {return "+ aux[1] +";}";
        String set = "void set"+ tAtri +"("+ aux[0] +" "+ aux[1] + ") {this." +aux[1]+ " = " +aux[1]+ ";}";
        getEset.add(get);
        getEset.add(set);
        return getEset;
    }

    public static String converEntVo(String s) {
        String[] aux = s.split("/");
        ArrayList<String> getEset = new ArrayList<>();
        String tAtri = formTit(aux[1]);
        return "vo.set"+ tAtri +"(entity.get"+tAtri+"());";
    }

    public static String converVoEnt(String s) {
        String[] aux = s.split("/");
        ArrayList<String> getEset = new ArrayList<>();
        String tAtri = formTit(aux[1]);
        return "entity.set"+ tAtri +"(vo.get"+tAtri+"());";
    }

    public static String formTit(String s) {
        String aux = s.toLowerCase();
        return aux.substring(0,1).toUpperCase().concat(aux.substring(1));
    }

    public static String[] forAtri(String sa) {
        String s = sa.replaceAll(" ", "");
        if(s.contains(",")) {
            String aux = s.toLowerCase();
            return aux.split(",");
        }else {
            if(s.contains(" ")){
                String aux = s.toLowerCase();
                return aux.split(" ");
            }
        }
        String[] aux = new String[0];
        aux[0] = "--erro";
        return aux;
    }

    public static String convertEnti(String s) {
        String[] aux = s.split("/");
        if(aux[0].length() < 3) {
            aux[0] = "String";
        }
        String auxII = aux[1].toUpperCase();
        return aux[0] +" "+ auxII +" = \""+ aux[1] + "\"";
    }

    public static String convertAtr(String s) {
        String[] aux = s.split("/");
        if(aux[0].length() < 3) {
            aux[0] = verTip(aux[0]);
        }
        return aux[0] +" "+ aux[1];
    }
    public static String convertEntiII(String s){
        String[] aux = s.split("/");
        if(aux[0].length() < 3) {
            aux[0] = "String";
        }
        String auxII = aux[1].toUpperCase();
        String x = aux[0] +" "+ auxII +" = \""+ aux[1] + "\"";

        return "\n    @Column(name = \""+auxII+"\", nullable = false,length = 200)\n" +
                "    private "+aux[0]+" "+aux[1]+";";
    }

    public static String verTip(String s){
        String aux = null;

        if(s.equals("s")){
            aux = "String";
        }
        if(s.equals("l")){
            aux = "Long";
        }
        if(s.equals("b")){
            aux = "Boolean";
        }
        if(s.equals("i")){
            aux = "Integer";
        }
        if(s.equals("f")){
            aux = "Float";
        }
        if(s.equals("d")){
            aux = "Double";
        }
        //todo Implementar Arrey e ArreyList
        return aux;
    }
}
