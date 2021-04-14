package main.functional.methods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PaymentServiceImplTest {
    @Test
    public void shouldRetrieveTheDefaultFees() throws Exception {
        PaymentService service = new PaymentServiceImpl();

        double fees = service.retrieveDefaultFees();

        Assertions.assertEquals(fees, 10.9);
    }

    @Test
    public void shouldInvokeTheDefaultMethodFromPaymentService() throws Exception {
        PaymentService paymentService = new PaymentServiceImpl();

        double valueSent = paymentService.send(20);

        Assertions.assertEquals(valueSent, 20);
    }

    @Test
    public void shouldInvokeStaticMethodPaymentService() {

        double DELTA = 1e-15;

        double withVat = PaymentService.getValueWithVAT(20);

        Assertions.assertEquals(withVat, 24, DELTA);
    }
  
}
