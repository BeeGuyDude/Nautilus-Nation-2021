package org.firstinspires.ftc.teamcode.opmodes.opmodesteleop;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.actions.ExtendIntake;
import org.firstinspires.ftc.teamcode.commands.actions.FlipDriveTrain;
import org.firstinspires.ftc.teamcode.commands.actions.RetractIntake;
import org.firstinspires.ftc.teamcode.commands.looped.RunStorage;
import org.firstinspires.ftc.teamcode.commands.looped.TankDrive;
import org.firstinspires.ftc.teamcode.commands.looped.VectorDrive;
import org.firstinspires.ftc.teamcode.commands.looped.RunIntake;

@TeleOp
public class DriveAll extends TeleOpModeWrapper {

    @Override
    public void teleOpInit() {
        scheduler.enableDebugTelemetry();
        scheduler.add(new ExtendIntake());

    }

    @Override
    public void teleOpLoop() {
        scheduler.add(new RunIntake(DriverRightTrigger));
        scheduler.add(new TankDrive(DriverLeftYAxis, DriverRightYAxis, DriverLeftXAxis, DriverRightXAxis));
        scheduler.add(new RunStorage(DriverRightTrigger));

        DriverLeftBumper.whenPressed(new FlipDriveTrain());
        DriverAButton.whileHeld(new ExtendIntake());
        DriverBButton.whileHeld(new RetractIntake());
    }
}

