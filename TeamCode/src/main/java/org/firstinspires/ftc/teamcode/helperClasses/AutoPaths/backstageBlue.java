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
        Pose2d startPose = new Pose2d(-39, 70, Math.toRadians(-90));

        drive.setPoseEstimate(startPose);

        return drive.trajectorySequenceBuilder(startPose)
                // logic here

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
