package org.firstinspires.ftc.teamcode.helperClasses.AutoPaths;

import androidx.annotation.NonNull;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryAccelerationConstraint;
import com.acmerobotics.roadrunner.*;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.helperClasses.RobotHardware;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

public class backstageRed {

    public static TrajectorySequence Middle(SampleMecanumDrive drive, RobotHardware robot) {
        Pose2d startPose = new Pose2d(-39, -70, Math.toRadians(90));

        drive.setPoseEstimate(startPose);

        return drive.trajectorySequenceBuilder(startPose)
                // logic here
                .splineToLinearHeading(new Pose2d(-38.50, -24.00, Math.toRadians(0.00)), Math.toRadians(0.00))
                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
//                    robot.spikeServoPos(false);
                })
                .waitSeconds(.3)
                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
//                    robot.spikeServoPos(true);
                })
                .waitSeconds(.3)
                .lineToLinearHeading(new Pose2d(-37.00, -13.00, Math.toRadians(-240.00)))
//                .lineToLinearHeading(new Pose2d(34.00, -14.00, Math.toRadians(-180.00)))
//                .lineToLinearHeading(new Pose2d(35.00, -36.00, Math.toRadians(-180.00)))
//                .setAccelConstraint(new TrajectoryAccelerationConstraint() {
//                    @Override
//                    public double get(double v, @NonNull Pose2d pose2d, @NonNull Pose2d pose2d1, @NonNull Pose2d pose2d2) {
//                        return 10;
//                    }
//                })
//                .splineToLinearHeading(new Pose2d(53.01, -44.00, Math.toRadians(-180.00)), Math.toRadians(-180.00))
//                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
//                    robot.boardPixelServoPos(false);
//                })
//                .waitSeconds(.6)
//                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
//                    robot.boardPixelServoPos(true);
//                })
//                .waitSeconds(.3)
//                .lineToLinearHeading(new Pose2d(45.85, -39.91, Math.toRadians(91.27)))
//                .lineToLinearHeading(new Pose2d(47.78, -17.00, Math.toRadians(-180.00)))
//                .lineToLinearHeading(new Pose2d(62.58, -17.01, Math.toRadians(-180.00)))
                // logic here
                .build();
    }

    public static TrajectorySequence Right(SampleMecanumDrive drive, RobotHardware robot) {
        Pose2d startPose = new Pose2d(-39, -70, Math.toRadians(90));

        drive.setPoseEstimate(startPose);

        return drive.trajectorySequenceBuilder(startPose)
                // logic here


                .splineToLinearHeading(new Pose2d(-33, -44.50, Math.toRadians(90.00)), Math.toRadians(90.00))
                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
//                    robot.spikeServoPos(false);
                })
                .waitSeconds(.3)
                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
//                    robot.spikeServoPos(true);
                })
                .lineToLinearHeading(new Pose2d(-37.00, -13.00, Math.toRadians(-240.00)))
//                .lineToLinearHeading(new Pose2d(34.00, -14.00, Math.toRadians(-180.00)))
//                .lineToLinearHeading(new Pose2d(35.00, -36.00, Math.toRadians(-180.00)))
//                .setAccelConstraint(new TrajectoryAccelerationConstraint() {
//                    @Override
//                    public double get(double v, @NonNull Pose2d pose2d, @NonNull Pose2d pose2d1, @NonNull Pose2d pose2d2) {
//                        return 10;
//                    }
//                })
//                .splineToLinearHeading(new Pose2d(50, -50.47, Math.toRadians(-180.00)), Math.toRadians(-180.00))
//                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
//                    robot.boardPixelServoPos(false);
//                })
//                .waitSeconds(.6)
//                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
//                    robot.boardPixelServoPos(true);
//                })
//                .waitSeconds(.3)
//                .lineToLinearHeading(new Pose2d(45.85, -39.91, Math.toRadians(91.27)))
//                .lineToLinearHeading(new Pose2d(47.78, -17.00, Math.toRadians(-180.00)))
//                .lineToLinearHeading(new Pose2d(62.58, -17.01, Math.toRadians(-180.00)))
                .build();
    }

    public static TrajectorySequence Left(SampleMecanumDrive drive, RobotHardware robot) {
        Pose2d startPose = new Pose2d(-39, -70, Math.toRadians(90));

        drive.setPoseEstimate(startPose);

        return drive.trajectorySequenceBuilder(startPose)
                // logic here
                .splineToLinearHeading(new Pose2d(-46.63, -58.13, Math.toRadians(30.00)), Math.toRadians(30.00))
                .splineToConstantHeading(new Vector2d(-47.36, -51.56), Math.toRadians(-10.02))
                .splineToLinearHeading(new Pose2d(-39.00, -41.00, Math.toRadians(-90.00)), Math.toRadians(-90.00))
                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
//                    robot.spikeServoPos(false);
                })
                .waitSeconds(.3)
                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
//                    robot.spikeServoPos(true);
                })
                .waitSeconds(.3)
                .lineToLinearHeading(new Pose2d(-29.48, -39.15, Math.toRadians(-90.00)))
//                .lineToLinearHeading(new Pose2d(-37.00, -13.00, Math.toRadians(-240.00)))
//                .lineToLinearHeading(new Pose2d(34.00, -14.00, Math.toRadians(-180.00)))
//                .lineToLinearHeading(new Pose2d(35.00, -36.00, Math.toRadians(-180.00)))
//                .setAccelConstraint(new TrajectoryAccelerationConstraint() {
//                    @Override
//                    public double get(double v, @NonNull Pose2d pose2d, @NonNull Pose2d pose2d1, @NonNull Pose2d pose2d2) {
//                        return 10;
//                    }
//                })
//                .splineToLinearHeading(new Pose2d(50.00, -36.00, Math.toRadians(-180.00)), Math.toRadians(-180.00))
//                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
//                    robot.boardPixelServoPos(false);
//                })
//                .waitSeconds(.6)
//                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
//                    robot.boardPixelServoPos(true);
//                })
//                .waitSeconds(.3)
//                .lineToLinearHeading(new Pose2d(47.78, -17.00, Math.toRadians(-180.00)))
//                .lineToLinearHeading(new Pose2d(62.58, -17.01, Math.toRadians(-180.00)))
                // logic here
                .build();
    }


}
