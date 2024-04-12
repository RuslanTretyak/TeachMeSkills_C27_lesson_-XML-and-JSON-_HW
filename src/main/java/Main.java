import parser.dom_parser.DOM;
import parser.sax_parser.SAX;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuPoint = -1;
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            System.out.println("введите '1' для использования SAX-парсера или '2' для использования DOM-парсера");
            try {
                menuPoint = Integer.parseInt(scanner.next());
                if (menuPoint == 1) {
                    SAX.parseFile("input.xml");
                    isInputCorrect = true;
                } else if (menuPoint == 2) {
                    DOM.parseFile("input.xml");
                    isInputCorrect = true;
                } else {
                    System.out.println("некорректный ввод");
                }
            } catch (NumberFormatException e) {
                System.out.println("некорректный ввод");
            }
        }
    }
}
