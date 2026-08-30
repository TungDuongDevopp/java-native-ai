package test.model;

public class NextDayCalculator {
    private static final int MAX_MONTH = 12;
    public String nextDay(int year, int month, int day) {
        validate(year, month, day);
        int maxDay = getDay(month, year);
      if(day < maxDay){
          day ++;
      }
     else if(day == maxDay && month == MAX_MONTH){
          day = 1;
          month = 1;
          year++;
     }
     else if(day == maxDay){
          day = 1;
          month++;
     }
     return String.format("%04d-%02d-%02d", year,month,day);
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
    private int getDay(int month,int year) {
     return switch (month){
        case 1,3,5,7,8,10,12 -> 31;
        case 2 -> isLeapYear(year) ? 29 : 28;
        case 4,6,9,11 -> 30;
         default -> throw new IllegalArgumentException("Unexpected value: " + month);
     } ;
    }
    private void validate(int year, int month, int day) {
        if(year <0 ){
            throw new IllegalArgumentException("Invalid year");
        }
        if(month<1 || month>12){
            throw new IllegalArgumentException("Invalid month");
        }
        if(day<1 || day>31) {
            throw new IllegalArgumentException("Invalid day");
        }
        int maxDay = getDay(month,year);
        if(day > maxDay){
            throw new IllegalArgumentException("Invalid day");
        }
    }
}
