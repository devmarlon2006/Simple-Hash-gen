package io.github.devmarlon.simplehash.hash;

public class Hash {

    private final String hash;
    private final int size;

    private Hash(String h , int s) {
        this.hash = h;
        this.size = s;
    }

    public static Hash from(HashBuilder hashBuilder) {
        return new Hash(hashBuilder.getHash() , hashBuilder.getHashSize(0));
    }

    public String HashtoString() {
        return this.hash;
    }

    public int hashSize() {
        return this.size;
    }
}
