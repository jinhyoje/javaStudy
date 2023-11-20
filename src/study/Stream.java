package study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream{
    @FunctionalInterface
    interface StringLengthCalculator {
        int calculateLength(String s);
    }
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry");

//        1. 6자리 이상인 문자열을 소문자로 만드시오.
        list.stream()
                .filter(s -> s.length() >= 6)
                .map(String::toLowerCase)
                .forEach(System.out::println);
//        2. 각 스트림문자열을 "1,2,3,4,5" 하나의 콤마가 들어간 문자열로 변경하시오.
        String collect = list.stream().collect(Collectors.joining(", "));
        System.out.println(collect);


        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7);
//        1. 전체 합 구하기
        System.out.println(integers.stream().reduce(0, Integer::sum));
//        2. 짝수합 구하기
        System.out.println(integers.stream().filter(i -> i % 2 == 0).reduce(0, Integer::sum));
//        3. 홀수합 구하기
        System.out.println(integers.stream().filter(i -> i % 2 == 1).reduce(0, Integer::sum));
//        4. 전체평균 구하기
        System.out.println(integers.stream().mapToInt(Integer::intValue).average().getAsDouble());
//        5. 짝수끼리 그룹핑 하기
//        6. 홀수끼리 그룹핑 하기

        integers.stream().filter(i -> i % 2 == 0).reduce(Integer::sum).ifPresent(System.out::println);
        integers.stream().filter(i -> i % 3 == 0).reduce(Integer::sum).ifPresent(System.out::println);

        Map<Integer, List<Integer>> groupedByEvenOdd;
        groupedByEvenOdd = integers.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? 0 : 1));

        System.out.println(groupedByEvenOdd);
/*        1. **람다 표현식 활용 문제**:
        - 예시 데이터: 정수 리스트 `[1, 2, 3, 4, 5]`
        - 문제: 위 리스트에서 짝수만 필터링하여 각 숫자의 제곱으로 이루어진 새 리스트 `[4, 16]`를 생성하세요.
 */
        List<Integer> list2 = List.of(1, 2, 3, 4, 5);
        List<Integer> squaredEvenNumber = list2.stream().filter(i -> i % 2 == 0).map(i -> i * i).collect(Collectors.toList());
        System.out.println(squaredEvenNumber);

/*
        2. **스트림 API 활용 문제**:
        - 예시 데이터: 문자열 리스트 `["Apple", "banana", "Cherry", "apricot"]`
        - 문제: 이 리스트에서 길이가 3 이상인 문자열만 선택하고 대문자로 변환한 다음, 알파벳 순으로 정렬하여 `["APPLE", "APRICOT", "BANANA", "CHERRY"]`를 출력하세요.
*/
        List<String> list3 = Arrays.asList("Apple", "banana", "Cherry", "apricot");
        List<String> str = list3.stream().filter(s -> s.length() >= 3).map(String::toUpperCase).sorted().collect(Collectors.toList());
        System.out.println(str);
/*
        3. **함수형 인터페이스 적용 문제**:
        - 예시: 문자열 "Hello, World!"
        - 문제: 위 문자열의 길이를 반환하는 람다 함수를 자신만의 함수형 인터페이스를 사용하여 작성하세요.
*/
        String inputString = "Hello, World!";
        StringLengthCalculator calculator = s -> s.length();
        int length = calculator.calculateLength(inputString);
        System.out.println(length);
/*
        4. **컬렉션 조작 문제**:
        - 예시 데이터: `Map<String, Integer>` 형태의 맵 `{"A": 2, "B": 3, "C": 4}`
        - 문제: 위 맵의 각 값을 제곱하여 새 맵 `{"A": 4, "B": 9, "C": 16}`을 생성하세요.
*/
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 2);
        inputMap.put("B", 3);
        inputMap.put("C", 4);

        Map<String, Integer> squaredValuesMap;
        squaredValuesMap = inputMap.entrySet().stream()
                        .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue() * entry.getValue()
                ));

        System.out.println(squaredValuesMap);
/*
        5. **스트림과 람다를 결합한 문제**:
        - 예시 데이터: `Person` 객체 리스트 `[new Person("Alice", 30), new Person("Bob", 35), new Person("Charlie", 40)]`
        - 문제: 이 리스트에서 `age` 필드를 기준으로 평균 나이를 계산하세요. (정답: 35)
*/
        List<Person> people = List.of(
                new Person(30),
                new Person(35),
                new Person(40)
        );

        double averageAge = people.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);

        System.out.println(averageAge);
    }

}


