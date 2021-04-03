package org.firstinspires.ftc.teamcode.commands.auto;

import org.firstinspires.ftc.teamcode.commands.basecommands.Command;

public class TestSleep extends Command {
    private double sleepTime;

    public TestSleep(double sleepTime) {
        this.sleepTime = sleepTime;
    }

    public void initialize() {

    }

    public void execute() {
        try {
            Thread.sleep((long)sleepTime);
        } catch (Exception e) {

        }
    }

    public boolean isFinished() {
        return true;
    }

    public void end() {

    }
}
