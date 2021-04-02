package org.firstinspires.ftc.teamcode.commands.actions;

import org.firstinspires.ftc.teamcode.commands.basecommands.Command;
import org.firstinspires.ftc.teamcode.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.mechanisms.Storage;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.MechanismEngine;

import static org.firstinspires.ftc.teamcode.framework.Constants.*;

public class LoadShooter extends Command {
    private Storage localStorage = MechanismEngine.getInstance().getMechanism(Storage.class);
    private Intake localIntake = MechanismEngine.getInstance().getMechanism(Intake.class);

    public LoadShooter() {
        Requires(localStorage);
        Requires(localIntake);
    }

    public void initialize() {

    }

    public void execute() {
        localStorage.runStorage(STORAGE_FEED_SPEED);
        localIntake.runIntake(STORAGE_FEED_SPEED);
    }

    public boolean isFinished() {
        return false;
    }

    public void end() {
        localStorage.runStorage(0);
        localIntake.runIntake(0);
    }
}
