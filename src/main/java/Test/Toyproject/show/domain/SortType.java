package Test.Toyproject.show.domain;

public enum SortType {
    LATEST,
    POPULAR,
    SOONEST;


    public static SortType from(String value) {
        return switch (value.toLowerCase()) {
            case "latest" -> LATEST;
            case "popular" -> POPULAR;
            case "soonest" -> SOONEST;
            default -> throw new IllegalArgumentException("잘못된 sort 값 입니다." + value);
        };
    }
}
