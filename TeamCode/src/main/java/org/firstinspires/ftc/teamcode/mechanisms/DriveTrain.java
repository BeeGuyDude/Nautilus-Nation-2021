package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.devicehandlers.DCMotorHandler;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.Mechanism;

import static org.firstinspires.ftc.teamcode.framework.Constants.*;

public class DriveTrain extends Mechanism {

    //Yes, I know that all 4 motors are flipped. No, that's not how this should work. Yes, that's how it does work. I'm not a lawyer, I'm a programmer.
    private DCMotorHandler frontLeft = new DCMotorHandler("drivetrain_front_left", true, true);
    private DCMotorHandler frontRight = new DCMotorHandler("drivetrain_front_right", false, true);
    private DCMotorHandler backLeft = new DCMotorHandler("drivetrain_back_left", true, true);
    private DCMotorHandler backRight = new DCMotorHandler("drivetrain_back_right", false, true);

    public void init(HardwareMap hwmap) {
        frontLeft.init(hwmap);
        frontRight.init(hwmap);
        backLeft.init(hwmap);
        backRight.init(hwmap);
    }

    //I'm just gonna assume we know how to feed the motors proper values at this point, I'm not clipping their speeds anymore
    public void setRawSpeeds(double frontLeftSpeed, double frontRightSpeed, double backLeftSpeed, double backRightSpeed) {
        frontLeft.setPower(frontLeftSpeed * DRIVETRAIN_MOTOR_POWER_LIMIT);
        frontRight.setPower(frontRightSpeed * DRIVETRAIN_MOTOR_POWER_LIMIT);
        backLeft.setPower(backLeftSpeed * DRIVETRAIN_MOTOR_POWER_LIMIT);
        backRight.setPower(backRightSpeed * DRIVETRAIN_MOTOR_POWER_LIMIT);
    }

    public void vectorDrive(double forwardSpeed, double strafeSpeed, double rotateSpeed) {
        setRawSpeeds(forwardSpeed + strafeSpeed + rotateSpeed,
                     forwardSpeed - strafeSpeed - rotateSpeed,
                     forwardSpeed - strafeSpeed + rotateSpeed,
                     forwardSpeed + strafeSpeed - rotateSpeed
        );
    }
}
