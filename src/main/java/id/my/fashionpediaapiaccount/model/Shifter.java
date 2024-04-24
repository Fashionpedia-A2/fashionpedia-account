package id.my.fashionpediaapiaccount.model;

public class Shifter implements ITransformer {
    private final int disposition;

    public Shifter(int disposition) {
        this.disposition = disposition;
    }

    public String transform(String str) {
        if (disposition > 0) {
            for (int i = 0; i < disposition; i++) {
                str = shiftRightByOne(str);
            }
        } else if (disposition < 0) {
            for (int i = 0; i < Math.abs(disposition); i++) {
                str = shiftLeftByOne(str);
            }
        }
        return str;
    }

    private String shiftRightByOne(String s) {
        return s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
    }

    private String shiftLeftByOne(String s) {
        return s.substring(1) + s.charAt(0);
    }
}
