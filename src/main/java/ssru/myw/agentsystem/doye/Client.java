package ssru.myw.agentsystem.doye;

public class Client {
    public static void main(String[] args) {
        User user = new User();
        user.setRed(100);
        user.setBlue(100);
        CareTaker careTaker = new CareTaker();


        careTaker.setMemento(user.createMemento());
        user.setRed(-100);
        user.setBlue(-100);

       user.setMemento(careTaker.getMemento());

        System.out.println(user.toString());






    }


}
