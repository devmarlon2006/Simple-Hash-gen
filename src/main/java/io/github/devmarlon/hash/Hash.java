package io.github.devmarlon.hash;

public class Hash {

    private final String hash;

    private Hash(String hash) {
        this.hash = hash;
    }

    public static Hash from(HashBuilder hash) {
        return new Hash(hash.getHash());
    }
}
