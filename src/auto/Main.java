package auto;

import auto.menu.Menu;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

public class Main {

    public static void main(String[] args) {

        System.out.println(StringUtils.capitalize("dfsjd"));

        List<Integer> list = new ArrayList<>();
        isEmpty(list);

        Menu menu = new Menu();
        menu.start(); //запустить программу
    }

}
