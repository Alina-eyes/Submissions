public enum BinaryOperation {
    PLUS("+") {
        public Integer calculate(int a, int b) {
            return a + b;
        }
    },
    MINUS("-") {
        public Integer calculate(int a, int b) {
            return a - b;
        }
    },
    DIVISION("/") {
        public Integer calculate(int a, int b) {
            try {
                return a / b;
            } catch (Exception e) {
                System.out.println("You cannot do it: " + e.toString());
                return null;
            }
        }
    },
    MULT("*") {
        public Integer calculate(int a, int b) {
            return a * b;
        }
    };

    private String operation;

    public String getOperation() {
        return this.operation;
    }

    public abstract Integer calculate(int a, int b);

    BinaryOperation(String operation) {
        this.operation = operation;
    }
}
