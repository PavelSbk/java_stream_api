package org.stream_api.theory.streams;

/**
 * Пакет java.util.stream содержит классы для поддержки операций с потоками элементов в функциональном стиле.
 * Ключевой абстракцией, введенной в этом пакете, является Поток.
 *
 * Stream API – по сути это поток данных и последовательные операции над ними.
 *
 * Интерфейсы Stream, IntStream, LongStream и DoubleStream –
 * это потоки объектов и примитивных типов int, long и double.
 *
 * Методы streams позволяют писать быстрый код для работы с коллекциями, в чём
 * сильно помогает использование лямбд
 *
 * В Java 8 Stream API доступны методы двух видов — конвейерные и терминальные.
 * Кроме них можно выделить ряд спецметодов для работы с числовыми стримами
 * и несколько методов для проверки параллельности/последовательности. Но это формальное разделение.
 *
 * Конвейерных методов в стриме может быть много.
 * Терминальный метод — только один. После его выполнения стрим завершается.
 *
 * Пока вы не вызвали терминальный метод, ничего не происходит.
 * Все потому, что конвейерные методы ленятся. Это значит, что они обрабатывают данные и ждут команды,
 * чтобы передать их терминальному методу.
 *
 * Конвейерные методы:
 *
 * filter -	отработает как фильтр, вернет значения, которые подходят под заданное условие
 * >>> collection.stream().filter(«e22»::equals).count()
 *
 * sorted - отсортирует элементы в естественном порядке; можно использовать Comparator
 * >>> collection.stream().sorted().collect(Collectors.toList())
 *
 * limit - лимитирует вывод по тому, количеству, которое вы укажете
 * >>> collection.stream().limit(10).collect(Collectors.toList())
 *
 * skip	- пропустит указанное вами количество элементов
 * >>> collection.stream().skip(3).findFirst().orElse("4")
 *
 * distinct	- найдет и уберет элементы, которые повторяются; вернет элементы без повторов
 * >>> collection.stream().distinct().collect(Collectors.toList())
 *
 * peek	- выполнить действие над каждым элементом элементов, вернет стрим с исходными элементами
 * >>> collection.stream().map(String::toLowerCase).peek((e) -> System.out.print("," + e)). collect(Collectors.toList())
 *
 * map - выполнит действия над каждым элементом; вернет элементы с результатами функций
 * >>> Stream.of("3", "4", "5")   .map(Integer::parseInt)   .map(x -> x + 10)    .forEach(System.out::println);
 *
 * mapToInt, mapToDouble, mapToLong - cработает как map, только вернет числовой stream
 * >>> collection.stream().mapToInt((s) -> Integer.parseInt(s)).toArray()
 *
 * flatMap, flatMapToInt, flatMapToDouble, flatMapToLong - сработает как map, но преобразует один элемент в ноль,
 * один или множество других
 * >>> collection.stream().flatMap((p) -> Arrays.asList(p.split(",")).stream()).toArray(String[]::
 *
 * Терминальные методы:
 *
 * findFirst - вернет элемент, соответствующий условию, который стоит первым
 * >>> collection.stream().findFirst().orElse("10")
 *
 * findAny - вернет любой элемент, соответствующий условию
 * >>> collection.stream().findAny().orElse("10")
 *
 * collect - соберет результаты обработки в коллекции и не только
 * >>> collection.stream().filter((s) -> s.contains("10")).collect(Collectors.toList())
 *
 * count - посчитает и выведет, сколько элементов, соответствующих условию
 * >>> collection.stream().filter("f5"::equals).count()
 *
 * anyMatch - True, когда хоть один элемент соответствует условиям
 * >>> collection.stream().anyMatch("f5"::equals)
 *
 * noneMatch - True, когда ни один элемент не соответствует условиям
 * >>> collection.stream().noneMatch("b6"::equals)
 *
 * allMatch - True, когда все элементы соответствуют условиям
 * >>> collection.stream().allMatch((s) -> s.contains("8"))
 *
 * min - найдет самый маленький элемент, используя переданный сравнитель
 * >>> collection.stream().min(String::compareTo).get()
 *
 * max - найдет самый большой элемент, используя переданный сравнитель
 * >>> collection.stream().max(String::compareTo).get()
 *
 * forEach - применит функцию ко всем элементам, но порядок выполнения гарантировать не может
 * >>> set.stream().forEach((p) -> p.append("_2"));
 *
 * forEachOrdered - применит функцию ко всем элементам по очереди, порядок выполнения гарантировать может
 * >>> list.stream().forEachOrdered((p) -> p.append("_nv"));
 *
 * toArray - приведет значения стрима к массиву
 * >>> collection.stream().map(String::toLowerCase).toArray(String[]::new);
 * reduce - преобразует все элементы в один объект
 * >>> collection.stream().reduce((c1, c2) -> c1 + c2).orElse(0)
 *
 * toList — стрим приводится к списку;
 * toCollection — получаем коллекцию;
 * toSet — получаем множество;
 * toConcurrentMap, toMap — если нужен map;
 * summingInt, summingDouble, summingLong — если требуется получить сумму чисел;
 * averagingInt, averagingDouble, averagingLong — если хотите вернуть среднее значение;
 * groupingBy — если необходимо разбить коллекцию на части.
 */

public class StreamMethods {
}
