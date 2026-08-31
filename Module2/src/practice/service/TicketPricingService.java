package practice.service;

import java.math.BigDecimal;

public class TicketPricingService {
    public static final BigDecimal BASE_PRICE = BigDecimal.valueOf(100000);


    public BigDecimal calculatePrice(int age, String dayOfWeek, boolean isMember) {
       BigDecimal finalPrice;
       BigDecimal vipMember = BASE_PRICE.multiply(BigDecimal.valueOf(0.1));
       if(age< 0){
           throw new IllegalArgumentException("Age cannot be negative");
       }
        if(dayOfWeek == null || dayOfWeek.isBlank()){
            throw new IllegalArgumentException("Day of week cannot be null or blank");
        }
        if(age < 12){
            if(isMember){
                finalPrice = BASE_PRICE.multiply(BigDecimal.valueOf(0.7)).subtract(vipMember);
            }
            else{
                finalPrice = BASE_PRICE.multiply(BigDecimal.valueOf(0.7));
            }
        }
        else if(age>60){
            if(isMember){
                finalPrice = BASE_PRICE.multiply(BigDecimal.valueOf(0.6)).subtract(vipMember);
            }
            else{
                finalPrice = BASE_PRICE.multiply(BigDecimal.valueOf(0.6));
            }
        }
        else {
            if(isMember){
                finalPrice = BASE_PRICE.subtract(vipMember);
            }
            else {
                finalPrice = BASE_PRICE;
            }
        }
        return switch (dayOfWeek){
            case "Monday", "Wednesday", "Thursday","Friday" -> finalPrice;
            case "Tuesday"-> finalPrice.multiply(BigDecimal.valueOf(0.5));
            case "Saturday","Sunday"-> finalPrice.multiply(BigDecimal.valueOf(1.2));
            default -> BigDecimal.valueOf(-1);
        };
    }

    public static void main(String[] args) {
        TicketPricingService ticketPricingService = new TicketPricingService();
        try{
            BigDecimal price = ticketPricingService.calculatePrice(-80,"Sunday",false);
            System.out.println(price);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
