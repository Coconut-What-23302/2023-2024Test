package org.firstinspires.ftc.teamcode.helperClasses.AutoPaths;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.helperClasses.PoseStorage;
import org.firstinspires.ftc.teamcode.helperClasses.RobotHardware;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

public class homeTrajectories {
    public static TrajectorySequence returnHomeBRTrajectory(SampleMecanumDrive drive, RobotHardware robot) {
        drive.setPoseEstimate(PoseStorage.transferedPose);

        return drive.trajectorySequenceBuilder(PoseStorage.transferedPose)
                .lineToLinearHeading(new Pose2d(33.50, -11.04, Math.toRadians(107.41)))
                .lineToLinearHeading(new Pose2d(-41.61, -12, Math.toRadians(179.71)))
                .lineToLinearHeading(new Pose2d(-39.00, -70.00, Math.toRadians(90.00)))
                .build();

    }

    public static TrajectorySequence returnHomeBBTrajectory(SampleMecanumDrive drive, RobotHardware robot) {
        drive.setPoseEstimate(PoseStorage.transferedPose);

        return drive.trajectorySequenceBuilder(PoseStorage.transferedPose)
                .splineToConstantHeading(new Vector2d(35.46, 6.62), Math.toRadians(107.41))
                .lineTo(new Vector2d(-47.51, 1.09))
                .lineToLinearHeading(new Pose2d(-39.00, 70.00, Math.toRadians(-90.00)))
                .build();

    }

    public static TrajectorySequence returnHomeFRTrajectory(SampleMecanumDrive drive, RobotHardware robot) {
        drive.setPoseEstimate(PoseStorage.transferedPose);

        return drive.trajectorySequenceBuilder(PoseStorage.transferedPose)
                .lineToLinearHeading(new Pose2d(24.00, 1.0, Math.toRadians(90.00)))
                .lineToLinearHeading(new Pose2d(39.00, -70.00, Math.toRadians(90.00)))
                .build();

    }

    public static TrajectorySequence returnHomeFBTrajectory(SampleMecanumDrive drive, RobotHardware robot) {
        drive.setPoseEstimate(PoseStorage.transferedPose);

        return drive.trajectorySequenceBuilder(PoseStorage.transferedPose)
                .lineToLinearHeading(new Pose2d(24.00, 1.0, Math.toRadians(-90.00)))
                .lineToLinearHeading(new Pose2d(39.00, 70.00, Math.toRadians(-90.00)))
                .build();

    }


// class close
}




