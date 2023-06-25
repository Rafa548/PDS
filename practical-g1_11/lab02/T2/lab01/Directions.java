package lab01;

public enum Directions{
    //LEFT, RIGHT, UP, DOWN, UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT
    
    LEFT{
        @Override
        public int[][] getVector() {
            return new int[][]{{0, -1}};
        }
        public String toString(){
            return "Left";
        }
        
    },
    RIGHT{
        @Override
        public int[][] getVector() {
            return new int[][]{{0, 1}};
        }
        public String toString(){
            return "Right";
        }
    },
    UP{
        @Override
        public int[][] getVector() {
            return new int[][]{{-1, 0}};
        }
        public String toString(){
            return "Up";
        }
    },
    DOWN{
        @Override
        public int[][] getVector() {
            return new int[][]{{1, 0}};
        }
        public String toString(){
            return "Down";
        }
    },
    UPLEFT{
        @Override
        public int[][] getVector() {
            return new int[][]{{-1, -1}};
        }
        public String toString(){
            return "UpLeft";
        }
    },
    UPRIGHT{
        @Override
        public int[][] getVector() {
            return new int[][]{{-1, 1}};
        }
        public String toString(){
            return "UpRight";
        }
    },
    DOWNLEFT{
        @Override
        public int[][] getVector() {
            return new int[][]{{1, -1}};
        }
        public String toString(){
            return "DownLeft";
        }
    },
    DOWNRIGHT{
        @Override
        public int[][] getVector() {
            return new int[][]{{1, 1}};
        }
        public String toString(){
            return "DownRight";
        }
    };

    public abstract int[][] getVector();    
    public abstract String toString();
}
