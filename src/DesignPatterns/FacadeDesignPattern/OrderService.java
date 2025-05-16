package DesignPatterns.FacadeDesignPattern;

public class OrderService {

    private InvoiceService invoiceService;
    private PaymentService paymentService;
    private WarehouseService warehouseService;


    public OrderService(){
        this.invoiceService = new InvoiceService();
        this.paymentService = new PaymentService();
        this.warehouseService = new WarehouseService();
    }


    public void processOrder(){
       invoiceService.processInvoiceForOrder();
       paymentService.processPaymentForOrder();
       warehouseService.processWareHouseForOrder();
    }
}
