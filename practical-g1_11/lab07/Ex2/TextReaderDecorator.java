package Ex2;

public abstract class TextReaderDecorator implements TextReaderInterface {
    private TextReaderInterface tr;
    
    public TextReaderDecorator(TextReaderInterface tr){
        this.tr = tr;
    }
    
    public boolean hasNext(){
        return tr.hasNext();
    }
    
    public String next(){
        return tr.next();
    }
}
