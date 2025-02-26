package AbstractClass;

import Intarface.Dishes;

import java.util.Objects;


public abstract class DishesAbstract implements Dishes {
    protected String name;
    protected String material;
    protected boolean dirty;

    public DishesAbstract(String name, String material, boolean dirty) {
        setName(name);
        this.material = material;
        this.dirty = dirty;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setDirty(boolean dirty){
        this.dirty = dirty;
    }

    public boolean getdirty(){
        return dirty;
    }

    public void gettingDirty(){
        this.dirty = true;
//        что-то еще надо написать
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DishesAbstract dishesAbstract = (DishesAbstract) o;

        return Objects.equals(material, dishesAbstract.material) &&
                dirty == dishesAbstract.dirty &&
                Objects.equals(name, dishesAbstract.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, material, dirty);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name= " + name  +
                ", dirty=" + dirty +
                "}";
    }


}
