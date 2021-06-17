package dao.entity;

public enum Genre {
    CHILDREN(1, "Детская литература"),
    CLASSIC(2, "Классическая литература"),
    COMEDY(3, "Юмористическая литература"),
    FOLKLORE(4, "Народный фольклор"),
    TRILLER(5, "Остросюжетная литература"),
    ACTION(6, "Приключенческая литература"),
    CRIME(7, "Детектив"),
    FANTASY(8, "Фэнтези"),
    HORROR(9, "Ужасы, мистика"),
    ROMANCE(10, "Романтическая литература"),
    ScienceFICTION(11, "Научная фантастика"),
    NonFICTION(12, "Публицистика");

    private int number;
    private String value;

    private Genre(int number, String value) {
        this.number = number;
        this.value = value;
    }

    public int getNumber() {
        return this.number;
    }
}

