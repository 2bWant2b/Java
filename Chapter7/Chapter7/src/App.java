interface DogState{
    public void showState();
}

class SoftlyState implements DogState{

    @Override
    public void showState() {
        System.out.println("Follow the master's orders");
    }
    
}

class MeetEnemyState implements DogState{

    @Override
    public void showState() {
        System.out.println("Attack the enemy");
    }
    
}

class MeetFriendState implements DogState{

    @Override
    public void showState() {
        System.out.println("Shaking the tail to welcome");
    }
    
}

class Dog{
    DogState state;
    public void cry(){
        state.showState();
    }
    public void setState(DogState s){
        state=s;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Dog yellowDog=new Dog();
        yellowDog.setState(new SoftlyState());
        yellowDog.cry();
        yellowDog.setState(new MeetEnemyState());
        yellowDog.cry();
        yellowDog.setState(new MeetFriendState());
        yellowDog.cry();
    }
}
