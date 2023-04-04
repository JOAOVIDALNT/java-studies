package services;

import entities.Contract;
import entities.Installment;

import java.util.Calendar;
import java.util.Date;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) { // define o OnlinePaymentService como argumento e o serviço especifico (paypalService) pode ser instanciado no lugar por que implementa
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {
        double basicQuota = contract.getTotalValue() / months;
        for (int i = 1; i <= months; i++) {
            Date date = addMonths(contract.getDate(), i);
            double updateQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
            double fullQuota = updateQuota + onlinePaymentService.paymentFee(updateQuota);
            contract.addInstallment(new Installment(date, fullQuota));
        }
    }

    private Date addMonths(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }
}
