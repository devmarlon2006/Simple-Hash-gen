import io.github.devmarlon.simplehash.hash.Hash;
import io.github.devmarlon.simplehash.hash.HashBuilder;

public class InitTest {

    public static void main(String[] args) {
        InitTest.start();
    }

    private static void start() {
        Hash haf = HashBuilder.of().configure((S) -> S
                .addParams("Hello" , "main" , "case")).toHash();
        System.out.print(haf.HashtoString());
    }

}
