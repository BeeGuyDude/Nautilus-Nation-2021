package org.firstinspires.ftc.teamcode.commands.auto;

import org.firstinspires.ftc.teamcode.commands.basecommands.CommandGroup;
import org.firstinspires.ftc.teamcode.framework.util.Timekeeper;

public class TestJankierAuto extends CommandGroup {
    public TestJankierAuto(Timekeeper timekeeper) {
        addParallel(new TimedDrive(timekeeper, 0.5, 0.5));
    }
}
