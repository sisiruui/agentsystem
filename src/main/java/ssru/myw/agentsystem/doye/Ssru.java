package ssru.myw.agentsystem.doye;

/**
 * @author: mayiwen
 * @date: 2018/11/16
 */
public class Ssru {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ssru{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
