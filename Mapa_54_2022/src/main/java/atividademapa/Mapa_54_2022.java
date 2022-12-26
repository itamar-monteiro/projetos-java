package atividademapa;

import classes.Cidadao;
import classes.Enfermeira;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Mapa_54_2022 {
    
    static Cidadao cidadao;
    static List<Cidadao> lista;
    
    public static void main(String[] args) throws ParseException {
        Enfermeira enfermeira = new Enfermeira();
        lista = new ArrayList<>();
        
        Scanner input = new Scanner(System.in);
        System.out.print("Informe o CPF da enfermeira: ");
        enfermeira.setCpf(input.nextLine());
        
        System.out.print("Informe o nome da enfermeira: ");
        enfermeira.setNome(input.nextLine());   
        
        System.out.printf("%nOlá %s seja bem vinda ao Sistema%n", enfermeira.getNome());
        System.out.printf("Escolha uma opção abaixo para continuar.%n%n");
        mostrarMenu();
        
        int opcao = 1;
        while (opcao != 3){
            Scanner sc = new Scanner(System.in);
            opcao = sc.nextInt();
            
            if (opcao == 1){
                cadastrarCidadao();
                mostrarMenu();
                
            } else if (opcao == 2){
                listarCidadaos();
                mostrarMenu();
            }
        }
    }
    
    public static void mostrarMenu(){
        System.out.println("\t1 - Vacinar cidadão");
        System.out.println("\t2 - Listar cidadãos vacinados");
        System.out.println("\t3 - Sair");
    }
    
    public static void cadastrarCidadao() throws ParseException{
        cidadao = new Cidadao();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        Scanner input = new Scanner(System.in);
        System.out.print("Informe o CPF do Cidadão: ");
        cidadao.setCpf(input.nextLine());
        
        System.out.print("Informe o nome do Cidadão: ");
        cidadao.setNome(input.nextLine()); 
        
        System.out.print("Informe a data da primeira dose: Formato (dd/mm/aaaa) ");
        Date primeiraDose = sdf.parse(input.next());
        cidadao.setDataPrimeiraDose(primeiraDose);
        
        System.out.print("Informe a data da segunda dose: Formato (dd/mm/aaaa) ");
        Date segundaDose = sdf.parse(input.next());
        
        calendar.setTime(primeiraDose);
        int m1 = 12*calendar.get(Calendar.YEAR)+ calendar.get(Calendar.MONTH);
        
        calendar.setTime(segundaDose);
        int m2 = 12*calendar.get(Calendar.YEAR)+ calendar.get(Calendar.MONTH);
        
        if (m2-m1 < 4){
            System.out.println("2ª dose deve ser aplicada 4 meses após a 1ª dose");
            return;        
        }
        cidadao.setDataSegundaDose(segundaDose);    
        
        System.out.print("Informe a data da terceira dose: Formato (dd/mm/aaaa) ");
        Date terceiraDose = sdf.parse(input.next());
        
        calendar.setTime(segundaDose);
        int m3 = 12*calendar.get(Calendar.YEAR)+ calendar.get(Calendar.MONTH);
        
        calendar.setTime(terceiraDose);
        int m4 = 12*calendar.get(Calendar.YEAR)+ calendar.get(Calendar.MONTH);
        
        if (m4-m3 < 4){
            System.out.println("3ª dose deve ser aplicada 4 meses após a 2ª dose");
            return;        
        }
        cidadao.setDataTerceiraDose(terceiraDose);      
        
        System.out.print("Informe a data da quarta dose: Formato (dd/mm/aaaa) ");
        Date quartaDose = sdf.parse(input.next());
        
        calendar.setTime(terceiraDose);
        int m5 = 12*calendar.get(Calendar.YEAR)+ calendar.get(Calendar.MONTH);
        
        calendar.setTime(quartaDose);
        int m6 = 12*calendar.get(Calendar.YEAR)+ calendar.get(Calendar.MONTH);
        
        if (m6-m5 < 4){
            System.out.println("4ª dose deve ser aplicada 4 meses após a 3ª dose");
            return;        
        }      
        cidadao.setDataQuartaDose(quartaDose);    
        lista.add(cidadao);
    }
    
    public static void listarCidadaos(){
        if (lista.size() == 0){
            System.out.println("*********************************");
            System.out.println("Não há nenhum cidadão cadastrado!");
            System.out.println("*********************************");
            System.out.println("\n");
            return;
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Cidadao c : lista) {
            System.out.printf("CPF....: %s%n", c.getCpf());
            System.out.printf("NOME...: %s%n", c.getNome());
            System.out.printf("1ª Dose: %s%n", sdf.format(c.getDataPrimeiraDose()));
            System.out.printf("2ª Dose: %s%n", sdf.format(c.getDataSegundaDose()));
            System.out.printf("3ª Dose: %s%n", sdf.format(c.getDataTerceiraDose()));
            System.out.printf("4ª Dose: %s%n", sdf.format(c.getDataQuartaDose()));
            System.out.println("\n");
        }
    }
}
