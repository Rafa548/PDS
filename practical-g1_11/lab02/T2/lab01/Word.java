package lab01;

public class Word {
    private String w;
    private int x;
    private int y;
    private Directions direction;

    public Word(String w, int x, int y, Directions direction) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    
    public Word(String w, int x, int y){
        this.w = w;
        this.x = x;
        this.y = y;
        this.direction = getRandomDirection();
    }

    //get random direction 
    public Directions getRandomDirection() {
        int random = (int) (Math.random() * 8);
        switch (random) {
        case 0:
            return Directions.LEFT;
        case 1:
            return Directions.RIGHT;
        case 2:
            return Directions.UP;
        case 3:
            return Directions.DOWN;
        case 4:
            return Directions.UPLEFT;
        case 5:
            return Directions.UPRIGHT;
        case 6:
            return Directions.DOWNLEFT;
        case 7:
            return Directions.DOWNRIGHT;
        default:
            return null;
        }
        


    }

    public String getWord() {
        return w;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setWord(String w) {
        this.w = w;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }



    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    public int coordenatesX(int x){
        return x+1;
    }
    public int coordenatesY(int y){
        return y+1;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((w == null) ? 0 : w.hashCode());
        result = prime * result + x;
        result = prime * result + y;
        result = prime * result + ((direction == null) ? 0 : direction.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Word other = (Word) obj;
        if (w == null) {
            if (other.w != null)
                return false;
        } else if (!w.equals(other.w))
            return false;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        if (direction == null) {
            if (other.direction != null)
                return false;
        } else if (!direction.equals(other.direction))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-5d %-8s %-10s \n", w, w.length(), coordenatesX(x) + "," + coordenatesY(y), direction.toString());
    }
    
}
