package initiative;
/**
 * 搅拌机
 */
public class Blender {

    /**
     * 搅拌
     *
     * @param water
     * @param fruit
     * @param suger
     */
    public String mix(String water, String fruit, String suger) {
        String juice = "这是一杯液体:" + water + "\n水果:" + fruit + "\n糖量:" + suger + "\n组成的果汁";
        return juice;
    }
}
