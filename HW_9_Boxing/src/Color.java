public enum Color {
    GREEN {
        @Override
        public String getHexCode() {
            return "#3cff00";
        }
        @Override
        public String toString() {
            return "GREEN";
        }
    },
    BLUE {
        @Override
        public String getHexCode() {
            return "#0d00ff";
        }

        @Override
        public String toString() {
            return "BLUE";
        }
    },
    RED {
        @Override
        public String getHexCode() {
            return "#ff0000";
        }

        @Override
        public String toString() {
            return "RED";
        }
    };

    abstract public String getHexCode();

}
