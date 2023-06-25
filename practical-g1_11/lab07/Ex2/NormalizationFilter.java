package Ex2;
import java.text.Normalizer;

public class NormalizationFilter extends TextReaderDecorator{

    String line;
    String[] words;
    static int i = 0;

    
    public NormalizationFilter(TextReaderInterface tr) {
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
        
        word = Normalizer.normalize(word, Normalizer.Form.NFD);
        word = word.replaceAll("[^\\p{ASCII}]", "");
        word = word.replaceAll("[^a-z]", "");

        i++;

        return word;
    }
    
}
