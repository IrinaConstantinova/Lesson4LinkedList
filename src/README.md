## Задание к семинару 4:
Реализовать свой GBLinkedList на основе интерфейса GBList 
(можете выбрать список однонаправленный или двунаправленный, по желанию)

## Вопросы и проблемы во время выполнения ДЗ:

В коде программы я решила реализовать односвязный список.

Самой большой головной болью оказалось реализовать public class ArrayIterator<E> implements Iterator<E>
так, чтобы он был универсальным как для GbArrayList<T>, так и для GbLinkedList<E>. Я понимаю то, чтоб Iterator
мог проходить по связному списку ему нужен доступ к узлам, т.е. к Node<E> и иметь в конструкторе массив, чтоб 
проходиться по ArrayList. 
Но так как у меня класс Node<E> приватный, не получалось получить к нему доступ. Я даже делала этот класс отдельным, 
публичным, но опять же выходили какие-то костыли. 
В итоге я создала отдельный приватный класс LinkedListIterator<E> implements Iterator<E> и там реализовала логику 
итератора, сработало, список итерируется через цикл for each. 
Думаю это не совсем то что нужно было сделать по заданию, но я попыталась.