package ss22_Structural_Design_Pattern.Thuc_hanh.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        MathCalculatorProxy mathCalculatorProxy = new MathCalculatorProxy();
        double result = mathCalculatorProxy.add(1,2);
        System.out.println("1 + 2 =" + result);
        result = mathCalculatorProxy.add(2,Double.MAX_VALUE);
        System.out.println("2 + Double.MAX_VALUE = " + result);
    }
}
