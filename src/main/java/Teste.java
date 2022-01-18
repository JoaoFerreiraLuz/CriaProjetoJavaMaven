import java.util.*;

public class Teste {

    public static void main(String[] args) {

        Path pt = new Path();
        NewProject np = new NewProject();

        Scanner sc = new Scanner(System.in);
        System.out.println("\n O que deseja fazer:" +
                "\n 1- criar novo projeto." +
                "\n 2- incluir pasta em projeto." +
                "\n 3- criar Classe em prjote" +
                "\n 4- adicionar metodo a projeto");
        int opcao = sc.nextInt();

        switch (opcao){
            case 1:
                boolean x1 = np.CreateProject();
                if(x1){
                    System.out.println("\n Projeto criado! \n");
                }else {
                    System.out.println("\n Deu Ruim! \n");
                }
                break;
            case 2:
                pt.CreatePath();
                break;
            case 3:

                break;
            case 4:

                break;
        }
    }
}
