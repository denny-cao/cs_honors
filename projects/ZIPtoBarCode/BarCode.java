import java.util.Map;

public class BarCode {
    private String barCode;

    public BarCode(String barCode) {
        if (!isValidBarCode(barCode)) {
            throw new IllegalArgumentException("Invalid bar code");
        }
        this.barCode = barCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public Zip toZip() {
        /* Convert bar code to zip code using DIGITWEIGHTS */
        StringBuilder zip = new StringBuilder();
        for (int i = 1; i < barCode.length() - 1; i += 5) {
            String digit = barCode.substring(i, i + 5);
            for (Map.Entry<Integer, String> entry : DIGITWEIGHTS.entrySet()) {
                if (entry.getValue().equals(digit)) {
                    zip.append(entry.getKey());
                }
            }
        }
        return new Zip(zip.toString());
    }

    public boolean isValidBarCode(String barCode) {
        /* Check if bar code is valid */
        if (barCode.length() != 32) {
            return false;
        }
        if (!barCode.startsWith("|") || !barCode.endsWith("|")) {
            return false;
        }
        for (int i = 1; i < barCode.length() - 1; i++) {
            if (barCode.charAt(i) != ':' && barCode.charAt(i) != '|') {
                return false;
            }
        }
        return true;
    }
}
