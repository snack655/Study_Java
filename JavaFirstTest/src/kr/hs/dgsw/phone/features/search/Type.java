package kr.hs.dgsw.phone.features.search;

public enum Type {
    NAME(0),
    PHONE(1);

    private final Integer value;

    Type(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
