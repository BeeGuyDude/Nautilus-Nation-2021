package org.firstinspires.ftc.teamcode.commands.auto;

import org.firstinspires.ftc.teamcode.commands.basecommands.Command;
import org.firstinspires.ftc.teamcode.framework.util.Timekeeper;
import org.firstinspires.ftc.teamcode.mechanisms.Shooter;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.MechanismEngine;

import static org.firstinspires.ftc.teamcode.framework.Constants.MAX_SHOOTER_POWER;

public class TimedShoot extends Command {
    private Shooter localShooter = MechanismEngine.getInstance().getMechanism(Shooter.class);
    private Timekeeper timekeeper;

    private double timeToShootFor;
    private double startTime;

    public TimedShoot(Timekeeper timekeeper, double timeToShootFor) {
        Requires(localShooter);

        this.timekeeper = timekeeper;
        this.timeToShootFor = timeToShootFor;
    }

    public void initialize() {
        this.startTime = timekeeper.getRuntime();
    }

    public void execute() {
        localShooter.setPower(0.95);
    }

    public boolean isFinished() {
        if (timekeeper.getRuntime() > startTime + timeToShootFor) {
            return true;
        } else {
            return false;
        }
    }

    public void end() {
        localShooter.setPower(0);
    }
}
