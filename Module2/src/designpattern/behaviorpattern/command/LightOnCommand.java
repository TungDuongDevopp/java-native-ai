package designpattern.behaviorpattern.command;

public class LightOnCommand  implements ICommand{
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.switchOn();
    }
}
