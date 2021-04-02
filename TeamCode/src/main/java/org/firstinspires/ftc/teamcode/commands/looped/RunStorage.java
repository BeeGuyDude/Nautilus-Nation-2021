package org.firstinspires.ftc.teamcode.commands.looped;

import org.firstinspires.ftc.teamcode.commands.basecommands.Command;
import org.firstinspires.ftc.teamcode.framework.controllers.Axis;
import org.firstinspires.ftc.teamcode.mechanisms.Storage;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.MechanismEngine;

public class RunStorage extends Command {
    private Storage localStorage = MechanismEngine.getInstance().getMechanism(Storage.class);
    private Axis inputAxis;

    public RunStorage(Axis inputAxis) {
        Requires(localStorage);

        this.inputAxis = inputAxis;
    }

    public void initialize() {}

    public void execute() {
        localStorage.runStorage(inputAxis.get());
    }

    public boolean isFinished() {
        return false;
    }

    public void end() {

    }
}
