package designpattern.behaviorpattern.command;

public class LightOffCommand  implements ICommand {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.switchOff();
    }
}
