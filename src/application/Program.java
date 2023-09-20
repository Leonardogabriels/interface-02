package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PayPalService;






public class Program {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato: ");
        System.out.print("Numero: ");
        int number = scan.nextInt();
        scan.nextLine();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate dateContract = LocalDate.parse(scan.nextLine(), fmt);
        System.out.print("Valor do contrato: ");
        double totalValue = scan.nextDouble();

        Contract contract = new Contract(number, dateContract, totalValue);

        System.out.print("Entre com o numero de parcelas: ");
        int installments = scan.nextInt();

        ContractService contractService = new ContractService(new PayPalService());

        contractService.processContract(contract, installments);

        System.out.println();
        System.out.println("Parcelas: ");
            for (Installment installment : contract.getInstallments()) {
			System.out.println(installment);
		}
        scan.close();
    }
}
