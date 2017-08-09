package eg.edu.alexu.csd.filestructure.avl;

/**
 * Created by ahmed on 3/24/17.
 * avl trees.
 */
public class DictionaryKey implements Comparable<DictionaryKey> {
    /**
     * value is the actual value inside the comparator.
     **/
    private Object value;

    /**
     * The constructor.
     *
     * @param o ;
     **/
    public DictionaryKey(final Object o) {
        this.value = o;
    }

    /**
     * to retrieve the stored value.
     *
     * @return value
     **/
    public Object getValue() {
        return value;
    }

    /**
     * Class to implement words as Comparables in
     * a dictionary .
     **/
    @Override
    public int compareTo(final DictionaryKey o) {
        if (o.getValue() instanceof String) {
            int i = 0;
            String valueThis = (String) this.value;
            String valueNext = (String) o.getValue();
            while (i < valueThis.length() && i < valueNext.length()) {
                if (valueThis.charAt(i) < valueNext.charAt(i)) {
                    return -1;
                } else if (valueThis.charAt(i) > valueNext.charAt(i)) {
                    return 1;
                }
            }
            if (valueThis.length() < valueNext.length()) {
                return -1;
            } else if (valueThis.length() > valueNext.length()) {
                return 1;
            }
        } else if (o.getValue() instanceof Float) {
            Float valueThis = (Float) this.value;
            Float valueNext = (Float) o.getValue();
            if (valueThis < valueNext) {
                return -1;
            } else if (valueThis > valueNext) {
                return 1;
            }
        }
        return 0;
    }
}
