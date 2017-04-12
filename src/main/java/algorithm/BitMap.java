package algorithm;

/**
 * Created by mjrt on 4/12/2017.
 */
public class BitMap {
    private static final long ADDRESS_PER_WORD = 6;
    private long[] words;
    private int wordsInUse = 0;

    public BitMap(int n) {
        words = new long[wordsInUse = wordIndex(n)+1];
    }

    private int wordIndex(int bits){
        return bits >> ADDRESS_PER_WORD;
    }

    public void put(int index){
        int wordIndex = wordIndex(index);
        words[wordIndex] |= (1L << index);
    }

    public void clear(int index){
        int wordIndex = wordIndex(index);
        words[wordIndex] &= ~(1L << index);
    }

    public boolean get(int index){
        int wordIndex = wordIndex(index);
        return (wordIndex < wordsInUse) && ( (words[wordIndex] & (1L << index)) != 0 );
    }
}
