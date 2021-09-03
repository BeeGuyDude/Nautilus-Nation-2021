package org.firstinspires.ftc.teamcode.commands.auto;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.basecommands.Command;
import org.firstinspires.ftc.teamcode.framework.util.TelemetryHandler;
import org.firstinspires.ftc.teamcode.framework.util.Timekeeper;
import org.firstinspires.ftc.teamcode.mechanisms.DriveTrain;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.MechanismEngine;

public class TimedDrive extends Command {
    private DriveTrain localDriveTrain = MechanismEngine.getInstance().getMechanism(DriveTrain.class);
    private Timekeeper timekeeper;

    private double startTime;
    private double timeToDrive;
    private double speed;

    public TimedDrive(Timekeeper timekeeper, double timeToDrive, double speed) {
        Requires(localDriveTrain);

        this.timekeeper = timekeeper;
        this.timeToDrive = timeToDrive;
        this.speed = speed;
    }

    public void initialize() {
        startTime = timekeeper.getRuntime();
    }

    public void execute() {
        localDriveTrain.vectorDrive(speed, 0, 0);
        TelemetryHandler.getInstance().getTelemetry().addData("Test", TelemetryHandler.class);
    }

    public boolean isFinished() {
        if (timekeeper.getRuntime() > startTime + timeToDrive) {
            return true;
        } else {
            return false;
        }
    }

    public void end() {
        localDriveTrain.vectorDrive(0, 0, 0);
    }
}
