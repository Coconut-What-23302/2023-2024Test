package org.firstinspires.ftc.teamcode.helperClasses.AutoPaths;
import androidx.annotation.NonNull;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryAccelerationConstraint;
import com.acmerobotics.roadrunner.*;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.helperClasses.RobotHardware;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
public class backstageBlue {

    public static TrajectorySequence Middle(SampleMecanumDrive drive, RobotHardware robot) {
        Pose2d startPose = new Pose2d(-39, -70, Math.toRadians(90));

        drive.setPoseEstimate(startPose);

        return drive.trajectorySequenceBuilder(startPose)
                // logic here
                .splineTo(new Vector2d(-36.93, 0.69), Math.toRadians(93.18))
                .waitSeconds(4.5)
                .splineTo(new Vector2d(15.18, 0.10), Math.toRadians(-0.65))
                                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
                    robot.boardPixelServoPos(false);
                })
                .waitSeconds(.6)
                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
                    robot.boardPixelServoPos(true);
                })
                .waitSeconds(.3)
                .splineTo(new Vector2d(11.85, -37.52), Math.toRadians(264.94))
                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
                    robot.spikeServoPos(false);
                })
                .waitSeconds(.3)
                .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
                    robot.spikeServoPos(true);
                })
                .waitSeconds(.3)
                .splineTo(new Vector2d(52.60, -31.44), Math.toRadians(90.00))



                // logic here
                .build();
    }

    public static TrajectorySequence Left(SampleMecanumDrive drive, RobotHardware robot) {
        Pose2d startPose = new Pose2d(-39, 70, Math.toRadians(-90));

        drive.setPoseEstimate(startPose);

        return drive.trajectorySequenceBuilder(startPose)
                // logic here

                // logic here
                .build();
    }

    public static TrajectorySequence Right(SampleMecanumDrive drive, RobotHardware robot) {
        Pose2d startPose = new Pose2d(-39, 70, Math.toRadians(-90));

        drive.setPoseEstimate(startPose);

        return drive.trajectorySequenceBuilder(startPose)
                // logic here

                // logic here
                .build();
    }



}
