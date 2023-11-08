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
                .splineToLinearHeading(new Pose2d(-36.20, -22.50, Math.toRadians(0.00)), Math.toRadians(0.00))
                .UNSTABLE_addTemporalMarkerOffset(.01, () -> {
                    robot.spikeMarkDrop.setPosition(-.7);
                })
                .waitSeconds(.8)
                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
                    robot.spikeMarkDrop.setPosition(.45);
                })
                .splineToLinearHeading(new Pose2d(-32.75, -12.43, Math.toRadians(-3.02)), Math.toRadians(-3.02))
                .splineToLinearHeading(new Pose2d(9.47, -10.65, Math.toRadians(-19.62)), Math.toRadians(-19.62))
                .splineToLinearHeading(new Pose2d(39.45, -21.50, Math.toRadians(-90.00)), Math.toRadians(-80.00))
                .splineToLinearHeading(new Pose2d(53.00, -41.50, Math.toRadians(-180.00)), Math.toRadians(0.00))
                .build();


        waitForStart();
        if(isStopRequested()) return;



        drive.followTrajectorySequence(untitled0);
        robot.boardPixelServoPos(false);
        sleep(800);
        robot.boardPixelServoPos(true);
        sleep(1000);

    }
}