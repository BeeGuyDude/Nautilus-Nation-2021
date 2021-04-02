package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.devicehandlers.DCMotorHandler;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.Mechanism;

public class Shooter extends Mechanism {

    private DCMotorHandler primaryMotor = new DCMotorHandler("shooter_primary_motor", false, false);
    private DCMotorHandler secondaryMotor = new DCMotorHandler("shooter_secondary_motor", false, false);

    public void init(HardwareMap hwmap) {
        primaryMotor.init(hwmap);
        secondaryMotor.init(hwmap);
    }

    public void setPower(double power) {
        primaryMotor.setPower(power);
        secondaryMotor.setPower(power);
    }
}
