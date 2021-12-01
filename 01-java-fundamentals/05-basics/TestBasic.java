public class TestBasic {
    public static void main(String[] args) {
        BasicJava tester = new BasicJava();
        System.out.println(tester.sumNums());
        tester.printNums();
        tester.printOdds();
        int testar[] = {1,3,5,7,9,13};
        int testar2[] = {-1,-3,-5,-7,-9,-13, 5};
        int avgarr[] = {2,3,10};
        tester.iterateArray(testar);
        tester.maxArray(testar);
        tester.maxArray(testar2);
        System.out.println(tester.oddArray());
        System.out.println(tester.getAverage(avgarr));
        System.out.println(tester.greaterY(avgarr, 1));
        System.out.println(tester.squared(avgarr));
        System.out.println(tester.noNegatives(testar2));
        System.out.println(tester.maxMinAvg(testar));
        tester.shiftArray(testar);
    }
}
