package SmartCity;

import java.util.Random;

public final class MapHelper {
   static final Random rand = new Random();

    public static Position getRandomPosition(){
        return new Position(rand.nextInt(10),rand.nextInt(10));
    }
    public static int getDistrict(Position position){
        if (position.ascissa < 5) return position.ordinata < 5 ? 1 : 2;
        else return position.ordinata < 5 ? 4 : 3;
    }

    public static Position getRechargeStationPosition(int distretto){
        return switch (distretto) {
            case 1 -> new Position(0, 0);
            case 2 -> new Position(0, 9);
            case 3 -> new Position(9, 9);
            case 4 -> new Position(9, 0);
            default -> throw new IllegalStateException("Unexpected value: " + distretto);
        };
    }

    public static Position getRandomRechargeStation() {
        return getRechargeStationPosition(getDistrict(getRandomPosition()));
    }
}
