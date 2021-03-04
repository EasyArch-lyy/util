package initiative;
/**
 * 果汁生成器
 * 被动
 * 主动创建橙汁
 */
public class JuiceMaker {

    // 搅拌器
    private Blender blender = null;
    private String water;
    private String fruit;
    private String suger;

    /**
     * 果汁生成
     */
    public String makeJuice(){
        blender = new Blender();
        return blender.mix(water, fruit, suger);
    }

    public Blender getBlender() {
        return blender;
    }

    public void setBlender(Blender blender) {
        this.blender = blender;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getSuger() {
        return suger;
    }

    public void setSuger(String suger) {
        this.suger = suger;
    }
}
