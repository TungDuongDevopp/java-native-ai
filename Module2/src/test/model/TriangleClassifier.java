package test.model;

public class TriangleClassifier {
   private boolean isTriangle(int a,int b,int c){
       if(a<=0 || b<=0 || c<=0){
           throw new IllegalArgumentException("Edge must be greater than 0");
       }
       return  a+b > c &&
               b+c > a &&
               a+c > b;
   }
   private boolean isIsoscelesTriangle(int a,int b,int c){
       return isTriangle(a,b,c) &&
               (a == b || b == c || a == c);
   }

    private boolean isEquilateralTriangle(int a,int b,int c){
        return isTriangle(a,b,c) &&
                (a == b && b == c);
    }
    public String classifyTriangle(int a,int b,int c){
        if(isEquilateralTriangle(a,b,c)){
            return "Equilateral";
        }
       if(isIsoscelesTriangle(a,b,c)){
           return "Isosceles";
       }
       if(isTriangle(a,b,c)){
           return "Triangle";
       }
       return "Not a triangle";
    }
}


