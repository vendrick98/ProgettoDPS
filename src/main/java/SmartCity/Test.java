package SmartCity;

public class Test {
    public static void main(String[] args) {
        for (int i = 0; i != 10; i++) {
            Position pos = MapHelper.getRandomPosition();
            System.out.println(pos);
            System.out.println(MapHelper.getDistrict(pos));
            Position station = MapHelper.getRechargeStationPosition(MapHelper.getDistrict(pos));
            System.out.println(station+"\n");
        }
    }
}
