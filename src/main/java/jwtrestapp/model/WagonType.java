package jwtrestapp.model;

public enum WagonType {
    PLAZKART("плацкарт", 60, 48),
    KUPE("купе", 120, 32),
    VIP("vip", 220, 16);

    private String name;
    private int price;
    private int places;

    WagonType(String name, int price, int places) {
        this.name = name;
        this.price = price;
        this.places = places;
    }

    public static WagonType find(String wagonType) {
        if(wagonType.toLowerCase().contentEquals("vip"))
            return VIP;
        if(wagonType.toLowerCase().contentEquals("купе"))
            return KUPE;
        if(wagonType.toLowerCase().contentEquals("плацкарт"))
            return PLAZKART;

        throw new RuntimeException("INCORRECT WAGON TYPE");
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getPlaces() {
        return places;
    }
}
