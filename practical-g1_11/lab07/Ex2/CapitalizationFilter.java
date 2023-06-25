package Ex2;

public class CapitalizationFilter extends TextReaderDecorator{
    
        public String line;
        public String[] words;
        public int i = 0;
        public boolean first = true;
        
        public CapitalizationFilter(TextReaderInterface tr) {
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
            //replace first and last character of the text with uppercase
            if (first) {
                word = word.substring(0, 1).toUpperCase() + word.substring(1);
                first = false;
            }
            if (i == words.length - 1 && !super.hasNext() ) {
                //replace last character of the text with uppercase
                word = word.substring(0, word.length() - 1) + word.substring(word.length() - 1).toUpperCase();
            }
            
            

            i++;
    
            return word;
        }
    
}
