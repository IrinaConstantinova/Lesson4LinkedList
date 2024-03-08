import gbCollections.GbList;
import gbCollections.lists.GbArrayList;
import gbCollections.lists.GbLinkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {


        System.out.println("Добавление в односвязный список элементов:");
        GbLinkedList<Integer> linkedList = new GbLinkedList<>();

        linkedList.add(4);
        linkedList.add(55);
        linkedList.add(47);
        linkedList.add(14);
        linkedList.add(35);
        linkedList.add(13);
        linkedList.add(3);
        linkedList.add(9);

        System.out.println(linkedList);
        System.out.println("Получение элемента по индексу:");
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(3));

        System.out.println("Удаление элемента по индексу:");
        linkedList.removeByIndex(1);
        System.out.println(linkedList);

        System.out.println("Возврат количества элементов списка:");
        System.out.println(linkedList.size());

        System.out.println("Итерация по элементам списка:");
        for (Integer elem : linkedList){
            System.out.println(elem * 2);
        }


    }
}