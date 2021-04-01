package org.firstinspires.ftc.teamcode.commands.actions;

import org.firstinspires.ftc.teamcode.commands.basecommands.Command;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.MechanismEngine;
import org.firstinspires.ftc.teamcode.mechanisms.Intake;

public class ExtendIntake extends Command {

    private Intake localIntake = MechanismEngine.getInstance().getMechanism(Intake.class);

    public ExtendIntake() {
        Requires(localIntake);
    }

    public void initialize() {}

    public void execute() {
        localIntake.extend();
    }

    public boolean isFinished() {
        return false;
    }

    public void end() {

    }
}
