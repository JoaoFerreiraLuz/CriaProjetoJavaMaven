import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Path {

    public Arquivos CreatePath(){

        Arquivos a = new Arquivos();
        Scanner sc = new Scanner(System.in);
        boolean result = false;
        try{
            System.out.println("\nInforme o Caminho do Front-end:");
            a.setCaminhofront(sc.nextLine());
            System.out.println("\nInforme o Caminho do Back-end:");
            a.setCaminhoback(sc.nextLine());

            boolean p1 = new File(a.getCaminhofront() + "\\FrontEnd" ).mkdir();
            boolean p2 = new File(a.getCaminhoback() + "\\"+a.C).mkdir();
            boolean p3 = new File(a.getCaminhoback() + "\\"+a.E).mkdir();
            boolean p4 = new File(a.getCaminhoback() + "\\"+a.V).mkdir();
            boolean p5 = new File(a.getCaminhoback() + "\\"+a.A).mkdir();
            boolean p6 = new File(a.getCaminhoback() + "\\"+a.M).mkdir();
            if(p1 && p2 && p3 && p4 && p5 && p6){
                System.out.println("\n pastas criadas! \n");
                result = true;
            }else{
                System.out.println("\n Erro ao criar alguma pasta! \n");
            }
        }
        catch (Exception e){
            System.out.println("\n Erro ao criar os arquivos!\n ");
            e.printStackTrace();
        }
        a.setB(result);
        return a;
    }
}
