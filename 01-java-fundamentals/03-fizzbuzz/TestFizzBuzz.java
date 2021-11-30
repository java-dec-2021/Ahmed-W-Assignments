public class TestFizzBuzz {
    public static void main(String[] args) {
        FizzBuzz tester = new FizzBuzz();
        System.out.println(tester.fizzBuzz(9, "multiple of 15", "multiple of 5","multiple of 3")); // Fizz
        System.out.println(tester.fizzBuzz(10, "multiple of 15", "multiple of 5", "multiple of 3")); // Buzz
        System.out.println(tester.fizzBuzz(15, "multiple of 15", "multiple of 5", "multiple of 3")); // FizzBuzz
        System.out.println(tester.fizzBuzz(16, "multiple of 15", "multiple of 5", "multiple of 3")); // 16
        System.out.println(tester.fizzBuzz(2, "multiple of 15", "multiple of 5", "multiple of 3")); // 2

        for (int i = 1; i <= 50; i++) {
            System.out.println(tester.fizzBuzz(i));
        }
    }
}
