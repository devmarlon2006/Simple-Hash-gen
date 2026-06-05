package io.github.devmarlon.simplehash.hash;

import java.util.function.UnaryOperator;

public class HashBuilder {

    private String[] rawParams;
    private String buildedHash;
    private boolean hashHasBuilded;


    public HashBuilder() {
    }

    public static HashBuilder of() {
        return new HashBuilder().configure((S) -> S.updateStatus(false) );
    }

    public Hash toHash() {
        this.gen();
        return Hash.from( this );
    }

    private HashBuilder updateStatus(boolean s) {
        this.hashHasBuilded = s;
        return this;
    }


    public HashBuilder configure(UnaryOperator<HashBuilder> configurator) {
        return configurator.apply(this);
    }


    public HashBuilder addParams(String... buildHash) {
        hashHasBuilded = false;
        if (this.buildedHash == null) {
            this.rawParams = buildHash;
        }
        return this;
    }

    private void gen() {
        this.buildedHash = this.generateHash(rawParams);
    }

    private String generateHash(String[] par) {
        StringBuilder sb = new StringBuilder();
        int arraySize = getHashSize(0);
        for (int i = 0; i < arraySize; i++) {
            if (i != arraySize - 1) {
                sb.append(par[i].toUpperCase()).append("-");
            }else {
                sb.append(par[i].toUpperCase());
            }
            this.updateStatus(true);
        }
        return sb.toString();
    }

    public String getHash() {
        if (!hashHasBuilded) {
            throw new IllegalArgumentException("Hash não está criado");
        }
        return this.buildedHash;
    }

    public int getHashSize(int decrement) {
        return this.rawParams.length == 0 ? 0 : this.rawParams.length - decrement;
    }
}
