package designpattern.behaviorpattern.command;

public class Client {
    public static void main(String[] args) {
        //create a remote control
        RemoteControl control = new RemoteControl();
        //create a light

        Light light = new Light();
        //Create 2 command

        ICommand lightsOn = new LightOnCommand(light);
        ICommand lightsOff = new LightOffCommand(light);
        //switch on
        control.setCommand(lightsOn);
        control.pressButton();
        //switch off
        control.setCommand(lightsOff);
        control.pressButton();
    }

}
