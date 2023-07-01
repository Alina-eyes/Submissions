public class Main {
    public static void main(String[] args) {
        double value = 0.345;
        Double boxedValue = Double.valueOf(value);
        Double goldenRatioValue = Double.parseDouble("1.61803398875");

        System.out.println("Golden ratio as int " + goldenRatioValue.intValue());
        System.out.println("Golden ratio as float " + goldenRatioValue.floatValue());
        System.out.println("Golden ratio as byte " + goldenRatioValue.byteValue());
        System.out.println("Golden ratio as long " + goldenRatioValue.longValue());
        System.out.println("Golden ratio as short " + goldenRatioValue.shortValue());

        String d = Double.toString(3.14);
        System.out.println("Double converted to string: " + d);

        System.out.println("Green hex code is: \033[0;32m" + Color.GREEN.getHexCode() + "\033[0m");
        System.out.println("RED hex code is: \033[0;31m" + Color.RED.getHexCode() + "\033[0m");
        System.out.println("BLUE hex code is: \033[0;34m" + Color.BLUE.getHexCode() + "\033[0m");

        int x = 12;
        int y = 6;
        for (BinaryOperation op: BinaryOperation.values()) {
            System.out.println(x + " " + op.getOperation() + " " + y + " = " + op.calculate(x,y));
        }


        System.out.println("Broken calculation: (5/0): " + BinaryOperation.DIVISION.calculate(5,0));
    }
}