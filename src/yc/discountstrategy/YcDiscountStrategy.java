/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yc.discountstrategy;

/**
 *
 * @author ycheema
 */
public class YcDiscountStrategy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //KLUDGE: do configuration here
        DatabaseStrategy db = new FakeDatabase();
        
        
        
        
        //Start talking to objects
        Register register = new Register();
        register.startNewSale("100", db);
        
        //test so far
        Customer customer = register.getReceipt().getCustomer();
        System.out.println("Customer " + customer.getCustName() 
                            + " found and added to receipt");
        register.addItemToSale("11", 2);
        register.addItemToSale("22", 1);
        register.addItemToSale("33", 3);
        //test
        LineItem[] items = register.getReceipt().getLineItem();
        for(LineItem item : items){
            System.out.println(item.getProduct().getProdName());
        }
    }
    
}
