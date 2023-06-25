package Ex2;

public class VowelFilter extends TextReaderDecorator{

    String line;
    String[] words;
    static int i = 0;

    
    public VowelFilter(TextReaderInterface tr) {
        super(tr);
    }
    
    @Override
    public boolean hasNext() {
        if (words != null && i < words.length){
            return true;
        }
        
        else if (super.hasNext()){
            i = 0;
            line = super.next();
            words = line.split(" ");
            return true;
        }
        return false;
    }
    
    @Override
    public String next() {
        
        String word = words[i];
        word = word.toLowerCase();
        word = word.replaceAll("[aeiou]", "");
        i++;

        return word;
    }
}
