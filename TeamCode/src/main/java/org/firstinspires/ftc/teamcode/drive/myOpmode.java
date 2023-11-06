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
                .splineTo(new Vector2d(-46.66, -9.41), Math.toRadians(103.71))
                .splineTo(new Vector2d(-40.52, -6.24), Math.toRadians(0.00))
                .splineTo(new Vector2d(37.72, -21.14), Math.toRadians(-6.37))
                .build();


        Trajectory untitled1 = drive.trajectoryBuilder(untitled0.end())
                .splineTo(new Vector2d(-46.66, -9.41), Math.toRadians(103.71))
                .splineTo(new Vector2d(-40.52, -6.24), Math.toRadians(0.00))
                .splineTo(new Vector2d(37.72, -21.14), Math.toRadians(-6.37))
                .build();

        drive.followTrajectory(untitled0);
        robot.spikeMarkDrop.setPosition(-1);
     sleep(200);
        robot.spikeMarkDrop.setPosition(1);
        sleep(600);
        drive.followTrajectory(untitled1);


    }
}
