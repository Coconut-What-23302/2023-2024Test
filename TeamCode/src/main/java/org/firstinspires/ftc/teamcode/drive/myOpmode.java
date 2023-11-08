package org.firstinspires.ftc.teamcode.drive;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.acmerobotics.roadrunner.*;
import com.qualcomm.robotcore.hardware.HardwareMap;


import org.firstinspires.ftc.teamcode.RobotHardware;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous

public class myOpmode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        RobotHardware robot = new RobotHardware();
        robot.init(hardwareMap);

        Pose2d startPose = new Pose2d(-39, -70, Math.toRadians(90));

        drive.setPoseEstimate(startPose);

        TrajectorySequence untitled0 = drive.trajectorySequenceBuilder(startPose)
//


                // path to the middle spike mark
                .splineToLinearHeading(new Pose2d(-36.00, -22.00, Math.toRadians(0.00)), Math.toRadians(0.00))
                .splineToLinearHeading(new Pose2d(-37.79, -10.92, Math.toRadians(0.00)), Math.toRadians(0.00))
                .splineToLinearHeading(new Pose2d(35.71, -13.20, Math.toRadians(-90.00)), Math.toRadians(0.00))
                .lineToLinearHeading(new Pose2d(34.44, -35.01, Math.toRadians(-61.00)))
                .splineToLinearHeading(new Pose2d(36.48, -41.31, Math.toRadians(10.60)), Math.toRadians(10.60))
                .splineToLinearHeading(new Pose2d(53.00, -40.00, Math.toRadians(180.00)), Math.toRadians(180.00))

                .build();
        waitForStart();
        if(isStopRequested()) return;

        drive.followTrajectorySequence(untitled0);

    }
}