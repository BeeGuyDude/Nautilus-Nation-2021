package org.firstinspires.ftc.teamcode.commands.actions;

import org.firstinspires.ftc.teamcode.commands.basecommands.Command;
import org.firstinspires.ftc.teamcode.mechanisms.DriveTrain;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.MechanismEngine;

public class FlipDriveTrain extends Command {
    private DriveTrain localDriveTrain = MechanismEngine.getInstance().getMechanism(DriveTrain.class);

    public void initialize() {}

    public void execute() {
        localDriveTrain.flip();
    }

    public boolean isFinished() {
        return true;
    }

    public void end() {}
}
