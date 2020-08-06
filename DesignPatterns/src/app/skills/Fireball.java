package app.skills;

public class Fireball implements ExecuteSkill {
    @Override
    public void execute() {
        System.out.println("Mage is casting FireBall");
    }
}
