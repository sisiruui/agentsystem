package ssru.myw.agentsystem.doye;

public class User {
    private int red; // 人物的血
    private int blue; // 人物的蓝


    public Memento createMemento(){
        Memento memento = new Memento();
        memento.setRed(red);
        memento.setBlue(blue);
        return memento;
    }


    public void setMemento(Memento memento){
        this.red = memento.getRed();
        this.blue = memento.getBlue();

    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    @Override
    public String toString() {
        return "User{" +
                "red=" + red +
                ", blue=" + blue +
                '}';
    }
}
