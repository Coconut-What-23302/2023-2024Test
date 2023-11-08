package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryAccelerationConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryVelocityConstraint;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.helperClasses.RobotHardware;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous

public class TempREd extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        RobotHardware robot = new RobotHardware();
        robot.init(hardwareMap);

        Pose2d startPose = new Pose2d(-39, 70, Math.toRadians(-90));

        drive.setPoseEstimate(startPose);

        TrajectorySequence untitled0 = drive.trajectorySequenceBuilder(startPose)
//
                .splineToLinearHeading(new Pose2d(-36.00, 22.00, Math.toRadians(-180.00)), Math.toRadians(0.00))
                .UNSTABLE_addTemporalMarkerOffset(.01, () -> {
                    robot.spikeMarkDrop.setPosition(-.7);
                })
                .waitSeconds(.8)
                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
                    robot.spikeMarkDrop.setPosition(.45);
                })
                .splineToLinearHeading(new Pose2d(-33.81, 11.83, Math.toRadians(-180.00)), Math.toRadians(0.00))
                .lineToSplineHeading(new Pose2d(36.23, 12.39, Math.toRadians(-180.00)))
                .lineToSplineHeading(new Pose2d(34.74, 36.23, Math.toRadians(-180.00)))
                .setAccelConstraint(new TrajectoryAccelerationConstraint() {
                    @Override
                    public double get(double v, @NonNull Pose2d pose2d, @NonNull Pose2d pose2d1, @NonNull Pose2d pose2d2) {
                        return 2;
                    }
                })
                .splineToLinearHeading(new Pose2d(53.00, 41.50, Math.toRadians(180.00)), Math.toRadians(180.00))
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