import Form.Formt;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;
import java.io.FileWriter;
import java.io.PrintWriter;

public class NewClass {

    public boolean CreateClassManual(Arquivos a){

        boolean resultado = false;
        ArrayList<Class> cl = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=======================================================================");
        int qtd = 1;
        for (int i = 0; i < qtd; ) {
            Class cla = new Class();
            System.out.println("\n Informe a Class");
            String titulo = sc.nextLine();
            cla.setTitulo(Formt.formTit(titulo));

            System.out.println("\n Informe os atributos *Separados por virgula',' ou espaço' '*");
            System.out.println(" Informe o Tipo com a primeira letra e '.', exemplo:( s/nome, l/cpf) ou o nome da class. campo, exemplo: (Pessoa/carro, ...) ");
            String atributos = sc.nextLine();
            cla.setAtributos(Formt.forAtri(atributos));
            if(cla.getAtributos()[0].equals("--erro")){
                System.out.println("\n Não encontrei ',' ou 'espaço' " + "\n Será necessario criar esta classe novamente\n" + " refazer?" + "\n s = sim  && n = nao");
                String res = sc.nextLine();
                String aux = res.toLowerCase();
                if(aux.equals("s")){
                    qtd = 2;
                }else{
                    qtd = 0;
                }
            }else{
                cl.add(cla);
                System.out.println("\n Criar nova Classe?" + "\n s = sim  && n = nao");
                String res = sc.nextLine();
                String aux = res.toLowerCase();
                if(aux.equals("s")){
                    qtd = 2;
                }else{
                    qtd = 0;
                }
            }
        }

        if(cl.size() > 0){
            boolean infStart = CriarFileStart(cl, a);
            boolean infVo = CriarFilesVo(cl, a);
            boolean infEntitie = CriarFileEntity(cl, a);
            boolean infController = CriarFileController(cl, a);
            boolean infMapper = CriarFileMapper(cl, a);

            if(infStart && infVo && infEntitie && infController && infMapper){
                System.out.println("\n Deu boa as Classes");
                boolean inf = true;
                return inf;
            }
        }else {
            System.out.println("\n Não há class's para criar");
        }
        return resultado;
    }

    public boolean CriarFileStart(ArrayList<Class> cl, Arquivos a){
        boolean retorno = false;
        try {
            // cria as classes star

                FileWriter arq = new FileWriter( a.getCaminhoback() +"\\" + "Starting.java" );
                PrintWriter gravarArq = new PrintWriter(arq);

                // definição da class
                gravarArq.printf("public class Starting {\n");
                    gravarArq.printf("\n  public static void main(String[] args) {\n");
                    gravarArq.printf("\n    }");
                gravarArq.printf("\n}");
                arq.close();
                retorno = true;

        }catch (Exception e){
            System.out.println("\nDeu ruim em algo aqui!");
        }
        return retorno;
    }

    public boolean CriarFilesVo(ArrayList<Class> cl, Arquivos a){
        boolean retorno = false;
        try {
            // cria as classes VO
            for (Class cla : cl) {
                FileWriter arq = new FileWriter( a.getCaminhoback() +"\\" + a.V +"\\"+ cla.getTitulo() + a.V + ".java");
                PrintWriter gravarArq = new PrintWriter(arq);

                gravarArq.println("package "+a.V +";");
                // definição da class
                gravarArq.printf("public class " + cla.getTitulo() +a.V+" {\n");
                    // monta atributos
                    for (String atributo: cla.getAtributos()) {
                        String at = Formt.convertAtr(atributo);
                        gravarArq.printf("\n    private " + at + ";");
                    }
                    // monta Construtor
                    gravarArq.printf("\n\n    public " + cla.getTitulo()+a.V+"(){}\n\n");
                    // get and set
                    for (String atributo: cla.getAtributos()) {
                        ArrayList<String> getEset = Formt.converGetESet(atributo);
                        gravarArq.printf("\n    public " + getEset.get(0));
                        gravarArq.printf("\n    public " + getEset.get(1));
                    }

                gravarArq.printf("\n}");
                arq.close();
                retorno = true;
            }
        }catch (Exception e){
            System.out.println("\nDeu ruim em algo aqui!");
        }
        return retorno;
    }

    public boolean CriarFileEntity(ArrayList<Class> cl, Arquivos a)  {
        boolean retorno = false;
        try {
            // cria as classes Entity
            for (Class cla : cl) {
                FileWriter arq = new FileWriter( a.getCaminhoback() +"\\" + a.E +"\\"+ cla.getTitulo() +".java");
                PrintWriter gravarArq = new PrintWriter(arq);

                gravarArq.println("package " +a.E +";\n");
                gravarArq.println("\nimport java.io.Serializable;");
                gravarArq.println("\nimport javax.persistence.*;");
                gravarArq.printf("\n@Entity");
                gravarArq.printf("\n@Table(name = "+ cla.getTitulo() + ")");
                gravarArq.printf("\npublic class " + cla.getTitulo()+" implements Serializable {\n");
                    gravarArq.printf("  public static final Log serialVersionUID = 1L;");
                    for(String clAux: cla.getAtributos()){
                        String at = Formt.convertEnti(clAux);
                        gravarArq.printf("\n    public static final " + at + ";");
                    }
                    gravarArq.printf("\n");
                    gravarArq.printf("\n    @Id\n" +
                        "    @Column(name = \"ID\")\n" +
                        "    @GeneratedValue(strategy = GenerationType.IDENTITY)\n" +
                        "    //@SequenceGenerator(name = \"SEQ\", sequenceName = \"GEN_ANIMAL_ID\", allocationSize = 1)\n" +
                        "    private Integer id;\n");
                    gravarArq.printf("\n");
                    for(String clAux: cla.getAtributos()){
                        String at = Formt.convertEntiII(clAux);
                        gravarArq.printf(at);
                    }
                    gravarArq.printf("\n");
                    for (String atributo: cla.getAtributos()) {
                        ArrayList<String> getEset = Formt.converGetESet(atributo);
                        gravarArq.printf("\n    public " + getEset.get(0));
                        gravarArq.printf("\n    public " + getEset.get(1));
                    }

                gravarArq.printf("\n}");
                arq.close();
                retorno = true;
            }
        }catch (Exception e){
            System.out.println("\nDeu ruim em algo aqui!");
        }
        return retorno;
    }

    public boolean CriarFileController(ArrayList<Class> cl, Arquivos a){
        boolean retorno = false;
        try {
            // cria as classes Controller
            for (Class cla : cl) {
                FileWriter arq = new FileWriter( a.getCaminhoback() +"\\" + a.C +"\\"+ cla.getTitulo()+a.C+".java");
                PrintWriter gravarArq = new PrintWriter(arq);

                gravarArq.println("package " +a.C +";");
                gravarArq.printf("public class " + cla.getTitulo()+a.C +" {\n");
                gravarArq.printf(" //todo salvar e listar ");
                gravarArq.printf("\n}");
                arq.close();
                retorno = true;
            }
        }catch (Exception e){
            System.out.println("\nDeu ruim em algo aqui!");
        }
        return retorno;
    }

    public boolean CriarFileMapper(ArrayList<Class> cl, Arquivos a){
        boolean retorno = false;
        try {
            // cria as classes Mapper
            for (Class cla : cl) {
                FileWriter arq = new FileWriter( a.getCaminhoback() +"\\" + a.M +"\\"+ cla.getTitulo()+a.M+".java");
                PrintWriter gravarArq = new PrintWriter(arq);

                gravarArq.println("package " +a.M +";");
                gravarArq.println("\nimport " +a.V+"."+ cla.getTitulo()+a.V +";");
                gravarArq.println("\nimport " +a.E +"."+ cla.getTitulo()+";");
                gravarArq.println("\nimport java.util.ArrayList;");
                gravarArq.println("\nimport java.util.List;");
                gravarArq.printf("\n");
                gravarArq.printf("\npublic class " + cla.getTitulo()+a.M +" {\n");

                // converte entity para VO
                    gravarArq.printf("\n    public static "+cla.getTitulo()+a.V+" convertToVo("+cla.getTitulo()+" entity) {");
                        gravarArq.printf("\n    "+cla.getTitulo()+a.V+ " vo = null;");
                        gravarArq.printf("\n    if (entity != null) {");

                            for (String atributo: cla.getAtributos()) {
                                String getEset = Formt.converEntVo(atributo);
                                gravarArq.printf("\n        "+getEset);
                            }
                        gravarArq.printf("\n    }");
                    gravarArq.printf("\n    return vo;");
                    gravarArq.printf("\n    }");
                    gravarArq.printf("\n");

                // converte vo para entity
                    gravarArq.printf("\n    public static "+cla.getTitulo()+" convertToEntity("+cla.getTitulo()+a.V+" vo) {");
                        gravarArq.printf("\n    "+cla.getTitulo()+" entity = null;");
                        gravarArq.printf("\n    if (vo != null) {");

                            for (String atributo: cla.getAtributos()) {
                                String getEset = Formt.converVoEnt(atributo);
                                gravarArq.printf("\n        "+getEset);
                            }
                        gravarArq.printf("\n    }");
                        gravarArq.printf("\n    return entity;");
                    gravarArq.printf("\n    }");
                    gravarArq.printf("\n");

                // converte vo para entity
                gravarArq.printf("\n    public static List<"+cla.getTitulo()+a.V+"> convertToListVo(List<"+cla.getTitulo()+"> listEntity) {");
                    gravarArq.printf("\n    List<"+cla.getTitulo()+a.V+"> listVo = null;");
                    gravarArq.printf("\n    if (listEntity != null) {");
                        gravarArq.printf("\n        listVo = new ArrayList<>();\n" +
                                "            for ("+cla.getTitulo()+" entity : listEntity) {\n" +
                                "                listVo.add(convertToVo(entity));\n" +
                                "            }\n");
                    gravarArq.printf("\n    }");
                gravarArq.printf("\n    return listVo;");
                gravarArq.printf("\n    }");
                gravarArq.printf("\n");

                // converte entity para vo
                    gravarArq.printf("\n    public static List<"+cla.getTitulo()+"> convertToListEntity(List<"+cla.getTitulo()+a.V+"> listVo) {");
                    gravarArq.printf("\n    List<"+cla.getTitulo()+"> listEntity = null;");
                    gravarArq.printf("\n    if (listVo != null) {");
                        gravarArq.printf("\n        listEntity = new ArrayList<>();\n" +
                                "            for ("+cla.getTitulo()+a.V+" vo : listVo) {\n" +
                                "                listEntity.add(convertToEntity(vo));\n" +
                                "            }\n");
                        gravarArq.printf("\n    }");
                    gravarArq.printf("\n    return listEntity;");
                    gravarArq.printf("\n    }");

                gravarArq.printf("\n}");
                arq.close();
                retorno = true;
            }
        }catch (Exception e){
            System.out.println("\nDeu ruim em algo aqui!");
        }
        return retorno;
    }

}
