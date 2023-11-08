package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.helperClasses.RobotHardware;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous

public class CWAuto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        RobotHardware robot = new RobotHardware();
        robot.init(hardwareMap);

        Pose2d startPose = new Pose2d(-39, -70, Math.toRadians(90));

        drive.setPoseEstimate(startPose);

        TrajectorySequence untitled0 = drive.trajectorySequenceBuilder(startPose)
//
                .splineToLinearHeading(new Pose2d(-36.00, -22.00, Math.toRadians(0.00)), Math.toRadians(0.00))

                .build();
        waitForStart();
        if(isStopRequested()) return;

        drive.followTrajectorySequence(untitled0);

    }
}