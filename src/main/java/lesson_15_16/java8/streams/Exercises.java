package lesson_15_16.java8.streams;

import java.util.Arrays;
import java.util.List;
import lesson_15_16.java8.streams.People.Sex;

public class Exercises {

  public static void main(String[] args) {
    first();
  }

  private static List<String> strings = Arrays.asList("a8", "a2", "a2", "a7", "b4");

  private static void first() {
    // Tom Вернуть количество вхождений объекта «a1»
//    final long count = strings.stream()
//        .filter("a1"::equals)
//        .count();
//    System.out.println(count);


    // Всеволод Вернуть первый элемент коллекции или 0, если коллекция пуста
//    final String s = strings.stream()
//        .findFirst().orElse("0");
//    System.out.println(s);

    // Роман Вернуть последний элемент коллекции или «empty», если коллекция пуста
//    final String s = strings.stream()
//        .skip(strings.size() == 0 ? 0 : strings.size() - 1)
//        .findFirst()
//        .orElse("empty");
//    System.out.println(s);

    // Никита Дроздов Найти элемент в коллекции равный «a3» или кинуть ошибку
//    final String s = strings.stream()
//        .filter(element -> "a3".equals(element))
//        .findFirst()
//        .orElseThrow(() -> new RuntimeException("Custom message"));
//    System.out.println(s);

    // Елена Вернуть третий элемент коллекции по порядку
//    final String what = strings.stream()
//        .skip(2)
//        .findFirst()
//        .orElse("no third element");
//    System.out.println(what);

    // Александр Вернуть два элемента начиная со второго
//    final List<String> collect = strings.stream()
//        .skip(1)
//        .limit(2)
//        .collect(Collectors.toList());
//    System.out.println(collect);

    // Константин Выбрать все элементы, содержащие 1
//
//    strings.stream()
//        .filter(s -> s.equals(1))

    // Евгений Вернуть коллекцию без дубликатов
//    final List<String> collect = strings.stream()
//        .distinct()
//        .collect(Collectors.toList());
//    System.out.println(collect);

    // Маргарита Найти существуют ли хоть один «a1» элемент в коллекции
//    final boolean anyMatch = strings.stream()
//        .anyMatch("a1"::equals);
//    System.out.println(anyMatch);

    // Никита Чертов Найти есть ли символ «1» у всех элементов коллекции
//    final boolean allMatch = strings.stream()
//        .allMatch(s -> s.contains("1"));
//    System.out.println(allMatch);

    // Мария Проверить что не существуют ни одного «a7» элемента в коллекции
//    final boolean b = strings.stream()
//        .noneMatch(s -> "a7".equals(s));
//    System.out.println(b);

    //  Валерия Добавить "_1" к каждому элементу коллекции
//    final List<String> collect = strings.stream()
//        .map(s -> s + "_1")
//        .collect(Collectors.toList());
//    System.out.println(collect);

    //  Дмитрий Ващенко Убрать первый символ у каждого элемента и вернуть массив чисел (int[])
//    final int[] ints = strings.stream()
//        .map(s -> s.substring(1))
//        .mapToInt(Integer::parseInt)
//        .toArray();
//    System.out.println(Arrays.toString(ints));

    List<String> strings2 = Arrays.asList("1,2,0", "4,5");
    // Гамзат Из strings2 получить все числа, перечисленные через запятую из всех элементов
//    final int[] ints = strings2.stream()
//        .map(s -> s.split(","))
//        .flatMap(Stream::of)
//        .mapToInt(Integer::parseInt)
//        .toArray();
//    System.out.println(Arrays.toString(ints));

    // Антон Сегодник Из strings2 получить сумму всех чисел, перечисленных через запятую
//    final Integer integer = strings2.stream()
//        .map(s -> s.split(","))
//        .flatMap(Stream::of)
//        .map(Integer::parseInt)
//        .reduce((x, y) -> x + y)
//        .orElse(0);
//    System.out.println(integer);

    // Алина Отсортировать коллекцию по алфавиту
//    final List<String> collect = strings.stream()
//        .sorted()
//        .collect(Collectors.toList());
//    System.out.println(collect);

    // Регина Отсортировать коллекцию по алфавиту в обратном порядке и убрать дубликаты
//    final List<String> collect = strings.stream()
//        .sorted((Comparator.reverseOrder()))
//        .distinct()
//        .collect(Collectors.toList());
//    System.out.println(collect);

    // Светлана Найти максимальное значение среди коллекции строк
//    final String s = strings.stream()
//        .max(String::compareTo)
//        .orElse("");
//    System.out.println(s);

    final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 2);
    // Артем Зайцев Вернуть сумму нечетных чисел или 0
//    final int sum = integers.stream()
//        .filter(i -> i % 2 == 1)
//        .mapToInt(i -> i)
//        .sum();
//    System.out.println(sum);

    // Илья Получить массив строк без дубликатов и в верхнем регистре
//    final List<String> collect = strings.stream()
//        .distinct()
//        .map(String::toUpperCase)
//        .collect(Collectors.toList());
//    System.out.println(collect);

    // Кирилл Преобразовать в map, где первый символ ключ, второй символ значение
//    final Map<Character, Character> collect = strings.stream()
//        .collect(Collectors.toMap(s1 -> s1.charAt(0), s2 -> s2.charAt(1), (a, b) -> b));
//    System.out.println(collect);

    // Дмитрий Трошкин Преобразовать в map, сгруппировав по первому символу строки
//    final Map<String, String> collect = strings.stream()
//        .collect(Collectors.groupingBy((p) -> p.substring(0, 1),
//            Collectors.mapping((p) -> p.substring(1, 2), Collectors.joining(":"))));
//    System.out.println(collect);

    final List<String> strings3 = Arrays.asList("Artem", "Nikolaev", "anikolaev@epam.com");
    // Антон Мязин вернуть количество символов (не учитывая @ и .)
//    final int sum = strings3.stream()
//        .map(value -> value.replace("@", "").replace(".", ""))
//        .mapToInt(String::length)
//        .sum();
//    System.out.println(sum);

    List<People> people = Arrays.asList(
        new People("Вася", 16, Sex.MAN),
        new People("Петя", 23, Sex.MAN),
        new People("Елена", 42, Sex.WOMAN),
        new People("Иван Иванович", 69, Sex.MAN)
    );

    // Дмитрий Славинский Выбрать мужчин-военнообязанных (от 18 до 27 лет)
//    final List<People> collect = people.stream()
//        .filter(p -> 18 <= p.getAge() && p.getAge() <= 27 && p.getSex().equals(Sex.MAN))
//        .collect(Collectors.toList());
//    System.out.println(collect);

    // Дмитрий Приходько Найти средний возраст среди мужчин
//    final double v = people.stream()
//        .filter(p -> p.getSex().equals(Sex.MAN))
//        .mapToInt(People::getAge)
//        .average()
//        .orElse(0.0);
//    System.out.println(v);

    // Найти кол-во потенциально работоспособных людей в выборке
    // (т.е. от 18 лет и учитывая что женщины выходят в 55 лет, а мужчина в 60)
//    final long count = people.stream()
//        .filter(p -> p.getAge() >= 18)
//        .filter(p -> p.getAge() < (p.getSex().equals(Sex.MAN) ? 60 : 55))
//        .count();
//    System.out.println(count);
    //  Мария Найдем человека с минимальным возрастом
//    final People min = people.stream()
//        .min(Comparator.comparing(People::getAge))
//        .orElse(null);
//    System.out.println(min);
  }

}
