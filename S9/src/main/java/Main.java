import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 6, 28 , 496, 8128);

        System.out.println(sumOddNumbers(numbers));
        System.out.println(productPowerNumbers(numbers));
        System.out.println(maxPerfectNumber(numbers));

        List<Pair<Student, Integer>> studentGrades = List.of(
//                new Pair<>(new Student("John", "Harvard"), 10),
//                new Pair<>(new Student("Mary", "Oxford"), 8),
//                new Pair<>(new Student("Pete", "Harvard"), 10),
//                new Pair<>(new Student("John", "Oxford"), 6),
//                new Pair<>(new Student("Mary", "Harvard"), 7),
//                new Pair<>(new Student("Pete", "Oxford"), 9)
                new Pair<>(new Student("John", "Harvard", List.of(new Pair<>("Math", 10), new Pair<>("English", 9))), 10),
                new Pair<>(new Student("Mary", "Oxford", List.of(new Pair<>("Math", 8), new Pair<>("English", 7))), 8),
                new Pair<>(new Student("Pete", "Harvard", List.of(new Pair<>("Math", 10), new Pair<>("English", 9))), 10),
                new Pair<>(new Student("John", "Oxford", List.of(new Pair<>("Math", 6), new Pair<>("English", 5))), 6),
                new Pair<>(new Student("Mary", "Harvard", List.of(new Pair<>("Math", 7), new Pair<>("English", 6))), 7),
                new Pair<>(new Student("Pete", "Oxford", List.of(new Pair<>("Math", 9), new Pair<>("English", 8))), 9)
        );

        System.out.println(maxGrade(studentGrades));
        System.out.println(numberOfStudentsByUni(studentGrades));
        System.out.println(averageNoteByCourse(studentGrades.stream().map(Pair::getFirst).toList()));
    }
    public static int sumOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(x -> x % 2 != 0)
                .mapToInt(Integer::valueOf)
                .sum();
    }

    public static int productPowerNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(x -> x * x)
                .reduce(1, (x, y) -> x * y);
    }

    public static boolean isPerfectNumber(int n) {
        int sum = 1;
        for(int i = 2; i <= n / 2; i++) {
            if(n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }

    public static int maxPerfectNumber(List<Integer> numbers) {
        return numbers.stream()
//                .filter(Main::isPerfectNumber)
                .filter(num -> (num == IntStream
                        .rangeClosed(1, num / 2)
                        .filter(div -> num % div == 0)
                        .sum()))
                .max(Integer::compareTo)
                .orElse(0);
    }

    public static List<Student> maxGrade(List<Pair<Student, Integer>> studentGrades) {
//        return studentGrades.stream()
//                .filter(x -> x.getSecond() == studentGrades.stream()
//                        .mapToInt(Pair::getSecond)
//                        .max()
//                        .orElse(0))
//                .map(Pair::getFirst)
//                .toList();
        int maxGrade = studentGrades.stream()
                .mapToInt(Pair::getSecond)
                .max()
                .orElse(0);

        return studentGrades.stream()
                .filter(x -> x.getSecond() == maxGrade)
                .map(Pair::getFirst)
                .toList();
    }

    public static Map<String, Long> numberOfStudentsByUni(List<Pair<Student, Integer>> studentList) {
        return studentList.stream()
                .collect(Collectors
                        .groupingBy(x -> x
                                .getFirst()
                                .getUniversity(), Collectors.counting()));
    }

    public static Map<String, Double> averageNoteByCourse(List<Student> studentList) {
        return studentList
                .stream()
                .flatMap(x -> x.getCourse()
                        .stream())
                        .collect(Collectors
                                .groupingBy(Pair::getFirst, Collectors.averagingDouble(Pair::getSecond)));


    }
}
