package Ex2;

public class TermFilter extends TextReaderDecorator{

    public String line;
    public String[] words;
    public int i = 0;
    
    public TermFilter(TextReaderInterface tr) {
        super(tr);
    }
    
    @Override
    public boolean hasNext() {

        if (words != null && i < words.length){
            return true;
        }
             
        else if (super.hasNext()){

            line = super.next();
            words = line.split(" ");
            i = 0;
            return true;

        }
        return false;
    }
    
    @Override
    public String next() {
        
        

        String word = words[i];
        i++;

        return word;
    }
}
