package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.framework.util.TelemetryHandler;
import org.firstinspires.ftc.teamcode.mechanisms.devicehandlers.DCMotorHandler;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.Mechanism;

public class Storage extends Mechanism {

    private DCMotorHandler storageMotor = new DCMotorHandler("storage_motor", true, true);
    private DistanceSensor storageSensor;

    public void init(HardwareMap hwmap) {
        storageMotor.init(hwmap);
        storageSensor = hwmap.get(DistanceSensor.class, "storage_distance_sensor");
    }

    public void runStorage(double power) {
        storageMotor.setPower(power);
        TelemetryHandler.getInstance().getTelemetry().addData("Distance Sensor Value", storageSensor.getDistance(DistanceUnit.CM));
    }
}
