package org.firstinspires.ftc.teamcode.opmodes.opmodesteleop;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.actions.ExtendIntake;
import org.firstinspires.ftc.teamcode.commands.actions.RetractIntake;

@TeleOp
public class DriveAll extends TeleOpModeWrapper {

    @Override
    public void teleOpInit() {
        scheduler.enableDebugTelemetry();
        scheduler.add(new ExtendIntake());

    }

    @Override
    public void teleOpLoop() {
        DriverAButton.whileHeld(new ExtendIntake());
        DriverBButton.whileHeld(new RetractIntake());
    }
}

