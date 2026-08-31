package practice.service;

import practice.enums.CustomerType;

import java.math.BigDecimal;

public class CheckoutService {
    private static final BigDecimal SHIPPING_FEE_ITEM1 = BigDecimal.valueOf(50_000);
    private static final BigDecimal SHIPPING_FEE_ITEM2 = BigDecimal.valueOf(20_000);
    private static final BigDecimal TAX_ITEM1 = BigDecimal.valueOf(0.1);
    private static final BigDecimal TAX_ITEM2 = BigDecimal.valueOf(0.05);
    private static final BigDecimal VIP_DISCOUNT_THRESHOLD = BigDecimal.valueOf(5_000_000);

    public BigDecimal processOrder(CustomerType customerType, BigDecimal amount, int itemType) {
        BigDecimal finalPrice;
        BigDecimal discount = calculateDiscount(customerType,itemType,amount);

                if (itemType == 1) {
                    finalPrice = amount.subtract(discount)
                                       .multiply(TAX_ITEM1.add(BigDecimal.ONE))
                                       .add(SHIPPING_FEE_ITEM1);
                }
                else{
                    finalPrice = amount.subtract(discount)
                                       .multiply(TAX_ITEM2.add(BigDecimal.ONE))
                                       .add(SHIPPING_FEE_ITEM2);
                }

        return finalPrice.stripTrailingZeros();
    }

    private void validateOrder(CustomerType customerType, BigDecimal amount, int itemType) {
        if(customerType == null){
            throw new IllegalArgumentException("Customer Type cannot be null or empty");
        }
        if(itemType <=0){
            throw new IllegalArgumentException("itemType cannot be negative");
        }
        if (amount == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }
        if(amount.compareTo(BigDecimal.ZERO)<=0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }

   private BigDecimal calculateDiscount(CustomerType customerType, int itemType, BigDecimal amount) {
        BigDecimal discount;
        validateOrder(customerType, amount, itemType);
        switch (itemType) {
            case 1:
                if(customerType == CustomerType.VIP){
                    if(amount.compareTo(VIP_DISCOUNT_THRESHOLD)>0){
                        discount = amount.multiply(BigDecimal.valueOf(0.15));
                    }
                    else {
                        discount = amount.multiply(BigDecimal.valueOf(0.1));
                    }
                }
                else{
                    discount = amount.multiply(BigDecimal.valueOf(0.05));
                }
                break;

            case 2:
                if(customerType == CustomerType.VIP){
                    discount = amount.multiply(BigDecimal.valueOf(0.08));
                }
                else{
                    discount = BigDecimal.ZERO;
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid item type");
        }
    return discount;
   }


    public static void main(String[] args) {
        CheckoutService checkoutService = new CheckoutService();
        BigDecimal test1 = checkoutService.processOrder(CustomerType.VIP, BigDecimal.valueOf(6000000), 1);
        System.out.println("Kết quả test1:" + test1.toPlainString());
        BigDecimal test2 = checkoutService.processOrder(CustomerType.VIP, BigDecimal.valueOf(400000), 1);
        System.out.println("Kết quả test2:" + test2.toPlainString());
        BigDecimal test3 = checkoutService.processOrder(CustomerType.NORMAL, BigDecimal.valueOf(500000), 1);
        System.out.println("Kết quả test3:" + test3.toPlainString());
        BigDecimal test4 = checkoutService.processOrder(CustomerType.NORMAL, BigDecimal.valueOf(300000), 2);
        System.out.println("Kết quả test4:" + test4.toPlainString());
        BigDecimal test5 =  checkoutService.processOrder(CustomerType.VIP, BigDecimal.valueOf(700000), 2);
        System.out.println("Kết quả test5:" + test5.toPlainString());

    }
}
