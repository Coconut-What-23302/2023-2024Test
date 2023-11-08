package org.firstinspires.ftc.teamcode.helperClasses;

import androidx.annotation.NonNull;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryAccelerationConstraint;
import com.acmerobotics.roadrunner.*;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.helperClasses.RobotHardware;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

public class AutonomousTrajectories {
    public static TrajectorySequence createBackstageRedTrajectory(SampleMecanumDrive drive, RobotHardware robot) {
        Pose2d startPose = new Pose2d(-39, -70, Math.toRadians(90));

        return drive.trajectorySequenceBuilder(startPose)
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
}
