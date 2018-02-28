package playground.underthehood;

public class StaticNestedClassExample {

    public interface WidgetParser {
        String getMeMyWidget();
    }

    public static WidgetParser create(String config) {
        return new WidgetParserImpl(config);
    }

    private static class WidgetParserImpl implements WidgetParser {
        String config;

        private WidgetParserImpl(String config) {
            this.config = config;
        }

        @Override
        public String getMeMyWidget() {
            return "This is the innerClass Senior for confif: " + this.config;
        }
    }

    public static void main(String[] args) {
        WidgetParser widgetParser =  StaticNestedClassExample.create("hello there");
        System.out.println(widgetParser.getMeMyWidget());
    }
}
