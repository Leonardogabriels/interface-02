package model.services;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.onlinePaymentService = paymentService;
    }

    public void processContract(Contract contract, Integer months){

        double valorParcela = (contract.getTotalValue() / months );

        for(int i = 1; i <=months; i++){
           
           double interest= onlinePaymentService.interest(valorParcela, i);
           double free = onlinePaymentService.paymentFee(valorParcela + interest);
           double totalValue = valorParcela + interest + free;

          contract.getInstallments().add(new Installment(contract.getDate().plusMonths(i), totalValue));
        }
    }   
}
