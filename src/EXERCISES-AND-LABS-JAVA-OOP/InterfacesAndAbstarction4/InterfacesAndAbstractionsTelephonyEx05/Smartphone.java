package InterfacesAndAbstractionsTelephonyEx05;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Browsable, Callable {
    //-	numbers: List<String>
//-	urls: List<String>
    private List<String> numbers;
    private List<String> urls;
//+	Smartphone(List<String>, List<String>)

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    //+	browse(): String
    @Override
    public String browse() {
        Pattern pattern = Pattern.compile("^[^0-9]+$");
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if (this.isValid(url, pattern)) {
                sb.append(String.format("Browsing: %s!", url)).append(System.lineSeparator());
            } else {
                sb.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    //+	call(): String
    @Override
    public String call() {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (this.isValid(number, pattern)) {
                sb.append(String.format("Calling... %s", number)).append(System.lineSeparator());
            } else {
                sb.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    private boolean isValid(String urlOrNumber, Pattern pattern) {
        Matcher matcher = pattern.matcher(urlOrNumber);
        return (matcher.find());
    }
}
