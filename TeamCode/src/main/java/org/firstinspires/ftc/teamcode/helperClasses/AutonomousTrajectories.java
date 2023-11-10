package org.firstinspires.ftc.teamcode.helperClasses;

import androidx.annotation.NonNull;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryAccelerationConstraint;
import com.acmerobotics.roadrunner.*;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.helperClasses.RobotHardware;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

public class AutonomousTrajectories {
    public static TrajectorySequence createBackstageRedTrajectory(SampleMecanumDrive drive, RobotHardware robot) {
        Pose2d startPose = new Pose2d(-39, -70, Math.toRadians(90));

        drive.setPoseEstimate(startPose);

        return drive.trajectorySequenceBuilder(startPose)

                .splineToLinearHeading(new Pose2d(-38.5, -24.00, Math.toRadians(0.00)), Math.toRadians(0.00))
                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
                    robot.spikeServoPos(false);
                })
                .waitSeconds(.5)
                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
                    robot.spikeServoPos(true);
                })
                .lineToLinearHeading(new Pose2d(-36.79, -12.79, Math.toRadians(-240.00)))
                .lineToLinearHeading(new Pose2d(33.93, -14.40, Math.toRadians(-180.00)))
                .lineToConstantHeading(new Vector2d(34.76, -36.54))
                .setAccelConstraint(new TrajectoryAccelerationConstraint() {
                    @Override
                    public double get(double v, @NonNull Pose2d pose2d, @NonNull Pose2d pose2d1, @NonNull Pose2d pose2d2) {
                        return 10;
                    }
                })
                .splineToLinearHeading(new Pose2d(53.00, -44, Math.toRadians(-180.00)), Math.toRadians(-180.00))





                .build();
    }
    public static TrajectorySequence createBackstageBlueTrajectory(SampleMecanumDrive drive, RobotHardware robot) {
        Pose2d startPose = new Pose2d(-39, 70, Math.toRadians(-90));

        drive.setPoseEstimate(startPose);

        return drive.trajectorySequenceBuilder(startPose)

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
    }

    public static TrajectorySequence createFrontstageRedTrajectory(SampleMecanumDrive drive, RobotHardware robot) {
        // trajectory logic for Frontstage Red
        return null;
    }

    public static TrajectorySequence createFrontstageBlueTrajectory(SampleMecanumDrive drive, RobotHardware robot) {
        //  trajectory logic for Frontstage Blue
        return null;
    }

    public static TrajectorySequence returnHomeBRTrajectory(SampleMecanumDrive drive, RobotHardware robot) {
        drive.setPoseEstimate(PoseStorage.transferedPose);

        return drive.trajectorySequenceBuilder(PoseStorage.transferedPose)
                .lineToLinearHeading(new Pose2d(33.50, -11.04, Math.toRadians(107.41)))
                .lineToLinearHeading(new Pose2d(-41.61, -10.66, Math.toRadians(179.71)))
                .lineToLinearHeading(new Pose2d(-39.00, -70.00, Math.toRadians(90.00)))
                .build();

    }

    public static TrajectorySequence returnHomeBBTrajectory(SampleMecanumDrive drive, RobotHardware robot) {
        drive.setPoseEstimate(PoseStorage.transferedPose);

        return drive.trajectorySequenceBuilder(PoseStorage.transferedPose)
             //insert trajectory logic here
                .build();

    }

    public static TrajectorySequence returnHomeFRTrajectory(SampleMecanumDrive drive, RobotHardware robot) {
        drive.setPoseEstimate(PoseStorage.transferedPose);

        return drive.trajectorySequenceBuilder(PoseStorage.transferedPose)
                //insert trajectory logic here
                .build();

    }

    public static TrajectorySequence returnHomeFBTrajectory(SampleMecanumDrive drive, RobotHardware robot) {
        drive.setPoseEstimate(PoseStorage.transferedPose);

        return drive.trajectorySequenceBuilder(PoseStorage.transferedPose)
                //insert trajectory logic here
                .build();

    }


// class close
}




