package org.firstinspires.ftc.teamcode.commands.auto;

import org.firstinspires.ftc.teamcode.commands.actions.ExtendIntake;
import org.firstinspires.ftc.teamcode.commands.actions.LoadShooter;
import org.firstinspires.ftc.teamcode.commands.basecommands.CommandGroup;
import org.firstinspires.ftc.teamcode.framework.util.Timekeeper;

public class TestJankAuto extends CommandGroup {

    public TestJankAuto(Timekeeper timekeeper) {
        addParallel(new ExtendIntake());
        addSequential(new TimedDrive(timekeeper, 3, 0.15));

        addSequential(new TimedDrive(timekeeper, 1.3, 0.5));

        addParallel(new DelayedLoadShooter(timekeeper, 2, 13));
        addSequential(new TimedShoot(timekeeper, 15));

        addSequential(new TimedDrive(timekeeper, 0.8, 0.5));
    }
}
