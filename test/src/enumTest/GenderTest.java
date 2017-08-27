package enumTest;

public class GenderTest {
    public static void main(String[] args) {
        Gender man = Gender.MALE;
        System.out.println(man.getName());

        Gender woman = Gender.valueOf("FEMALE");
        System.out.println(woman.getName());
    }
}
