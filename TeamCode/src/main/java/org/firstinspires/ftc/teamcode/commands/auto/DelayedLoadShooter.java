package org.firstinspires.ftc.teamcode.commands.auto;

import org.firstinspires.ftc.teamcode.commands.basecommands.Command;
import org.firstinspires.ftc.teamcode.framework.util.Timekeeper;
import org.firstinspires.ftc.teamcode.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.mechanisms.Storage;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.MechanismEngine;

import static org.firstinspires.ftc.teamcode.framework.Constants.STORAGE_FEED_SPEED;

public class DelayedLoadShooter extends Command {
    private Storage localStorage = MechanismEngine.getInstance().getMechanism(Storage.class);
    private Intake localIntake = MechanismEngine.getInstance().getMechanism(Intake.class);

    private Timekeeper timekeeper;
    private double delay;
    private double timeToLoad;

    private double startTime;

    public DelayedLoadShooter(Timekeeper timekeeper, double delay, double timeToLoad) {
        Requires(localStorage);
        Requires(localIntake);

        this.timekeeper = timekeeper;
        this.delay = delay;
        this.timeToLoad = timeToLoad;
    }

    public void initialize() {
        startTime = timekeeper.getRuntime();
    }

    public void execute() {
        if (timekeeper.getRuntime() >= startTime + delay) {
            localStorage.runStorage(STORAGE_FEED_SPEED);
            localIntake.runIntake(STORAGE_FEED_SPEED);
        }
    }

    public boolean isFinished() {
        if (timekeeper.getRuntime() > startTime + timeToLoad) {
            return true;
        } else {
            return false;
        }
    }

    public void end() {
        localStorage.runStorage(0);
        localIntake.runIntake(0);
    }
}
