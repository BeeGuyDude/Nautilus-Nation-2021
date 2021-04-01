package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.devicehandlers.DCMotorHandler;
import org.firstinspires.ftc.teamcode.mechanisms.devicehandlers.ServoHandler;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.Mechanism;

import static org.firstinspires.ftc.teamcode.framework.Constants.*;

public class Intake extends Mechanism {

    private boolean extended = false;
    private ServoHandler leftServo = new ServoHandler("left_servo");
    private ServoHandler rightServo = new ServoHandler("right_servo");

    private DCMotorHandler intakeMotor = new DCMotorHandler("intake_motor", true, false);

    @Override
    public void init(HardwareMap hwmap) {
        leftServo.init(hwmap);
        rightServo.init(hwmap);

        intakeMotor.init(hwmap);
    }

    public void extend() {
        leftServo.setPosition(LEFT_SERVO_EXTENDED_POSITION);
        rightServo.setPosition(RIGHT_SERVO_EXTENDED_POSITION);
        extended = true;
    }

    public void retract() {
        leftServo.setPosition(LEFT_SERVO_RETRACTED_POSITION);
        rightServo.setPosition(RIGHT_SERVO_RETRACTED_POSITION);
        extended = false;
    }

    public void toggle() {
        if (extended) {
            retract();
        } else {
            extend();
        }
    }

    public void runIntake(double input_power) {
        intakeMotor.setPower(input_power);
    }
}
