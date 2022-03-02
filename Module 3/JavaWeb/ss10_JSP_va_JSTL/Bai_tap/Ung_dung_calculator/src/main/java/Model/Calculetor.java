package Model;

public class Calculetor {
    public static Double calculate(Double firstOperand , String operator , Double secondOperand) {
        if (operator.equals("cong")){
            return firstOperand + secondOperand;
        }else if (operator.equals("tru")){
            return firstOperand - secondOperand;
        }else if (operator.equals("nhan")){
            return firstOperand * secondOperand;
        }else if(operator.equals("chia")){
            try {
               Double result = firstOperand /secondOperand;
               return result;
            }catch (Exception e){

            }
        }
        return null;

    }
}
