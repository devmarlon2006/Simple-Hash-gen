package io.github.devmarlon.simplehash.hash;

import java.util.List;

public class Hash {

    private final String hash;

    private Hash(String hash) {
        this.hash = hash;
    }

    public static Hash from(HashBuilder hashBuilder) {
        return new Hash(hashBuilder.getHash());
    }

    public String HashtoString() {
        return this.hash;
    }
}
