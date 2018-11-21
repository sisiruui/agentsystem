package ssru.myw.agentsystem.doye;

/**
 * @author: mayiwen
 * @date: 2018/11/16
 */
public class tesy {

    public void add(Ssru ssru) {
        ssru.setName("myw");
    }


    public static void main(String[] args) {
        Ssru ssru = new Ssru();
        ssru.setName("n");
        ssru.setId(1);
        tesy t = new tesy();
        t.add(ssru);
        System.out.println(ssru.toString());


    }
}
