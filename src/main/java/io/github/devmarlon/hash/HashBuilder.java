package io.github.devmarlon.hash;

import java.util.function.UnaryOperator;

public class HashBuilder {

    private String[] rawParams;
    private String buildedHash;
    private final int defaultSize = 5;


    public HashBuilder() {
    }

    public static HashBuilder of() {
        return new HashBuilder();
    }

    public static HashBuilder create(String[] rawParams) {
        return HashBuilder.of().configure( (S) -> S.addParams(rawParams) );
    }

    public HashBuilder configure(UnaryOperator<HashBuilder> configurator) {
        return configurator.apply(this);
    }

    public HashBuilder addParams(String... buildHash) {
        if (buildHash.length !=  defaultSize) {
            throw new IllegalArgumentException();
        }
        if (this.buildedHash == null) {
            this.rawParams = buildHash;
        }
        return this;
    }

    private String generateHash(String[] par) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < par.length - 1; i++) {
            if (i != par.length - 1) {
                sb.append(par[i].toUpperCase()).append("-");
            }else {
                sb.append(par[i].toUpperCase());
            }
        }
        return sb.toString();
    }

    public String getHash() {
        return this.buildedHash;
    }
}
