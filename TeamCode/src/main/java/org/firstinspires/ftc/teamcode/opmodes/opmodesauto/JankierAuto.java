package org.firstinspires.ftc.teamcode.opmodes.opmodesauto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.commands.auto.TestJankierAuto;

@Autonomous
public class JankierAuto extends AutoOpModeWrapper {
    @Override
    public void autoInit() {

    }

    @Override
    public void autoLoop() {
        scheduler.add(new TestJankierAuto(timekeeper));
    }
}
