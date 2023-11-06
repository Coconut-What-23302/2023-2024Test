package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.teamcode.RobotHardware;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

/*
 * This is an example of a more complex path to really test the tuning.
 */
@Autonomous(group = "drive")

public class myOpmode extends LinearOpMode {

    RobotHardware robot = new RobotHardware();
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        robot.init(hardwareMap);




        waitForStart();

        if (isStopRequested()) return;

        Pose2d startPose = new Pose2d(-39, -70, Math.toRadians(90));
        drive.setPoseEstimate(startPose);

        Trajectory untitled0 = drive.trajectoryBuilder(startPose)
                .splineTo(new Vector2d(-36.79, -23.00), Math.toRadians(0.00))
                .build();


        Trajectory untitled1 = drive.trajectoryBuilder(untitled0.end())
                .splineTo(new Vector2d(-42.01, -10.71), Math.toRadians(128.16))
                .splineTo(new Vector2d(-35.30, -11.46), Math.toRadians(-18.76))
                .splineTo(new Vector2d(-26.73, -13.51), Math.toRadians(-12.68))
                .splineTo(new Vector2d(-4.75, -11.64), Math.toRadians(-11.70))
                .splineTo(new Vector2d(28.04, -11.46), Math.toRadians(0.33))
                .splineTo(new Vector2d(36.61, -35.67), Math.toRadians(270.00))
                .build();


        drive.followTrajectory(untitled0);
        sleep(4000);
        drive.followTrajectory(untitled1);


    }
}
