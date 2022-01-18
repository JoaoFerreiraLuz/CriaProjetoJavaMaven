import java.util.Scanner;

public class NewProject {

    public boolean CreateProject(){


        boolean result = false;
        Scanner sc = new Scanner(System.in);
        Path pt = new Path();
        NewClass nc = new NewClass();

        System.out.println("\n=======================================================================" +
                "\n Será necessario:" +
                "\n 1- Criar um workSpace do projeto desejado." +
                "\n 2- Informar o diretorio para criação dos arquivos" +
                "\n 3- Escolher a maneira que serão informadas as classes.");

        System.out.println(" Depois de criar o WorkSpace:");
        Arquivos a =  pt.CreatePath();
        if(a.getB()){
            System.out.println("\n=======================================================================" +
                    "\n As pastas foram criadas." +
                    "\n Como deseja informar as Classes e atributos?" +
                    "\n 1- Arquivo .Txt." +
                    "\n 2- Chamando API." +
                    "\n 3- Digitação manual." );
            int opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    break;
                case 2:
                    pt.CreatePath();
                    break;
                case 3:
                    boolean info = nc.CreateClassManual(a);
                    System.out.println(info ? "\n Deu boa":"\n Deu ruim");
                    return info ? true:false;
            }
        }else{
            System.out.println("\n Não deu para criar as pastas!");
        }
        return result;
    }
}
