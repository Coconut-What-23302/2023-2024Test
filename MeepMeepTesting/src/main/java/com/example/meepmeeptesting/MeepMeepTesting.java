package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryAccelerationConstraint;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setDimensions(15,17)
                .setConstraints(52.48180821614297, 52.48180821614297,  2.793466, Math.toRadians(184.02607784577722), 13.7)
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d( -39, -70, Math.toRadians(90)))

                                        .splineToLinearHeading(new Pose2d(-33.75, -44.50, Math.toRadians(-90.00)), Math.toRadians(-90.00))
                                        .lineToLinearHeading(new Pose2d(-37.00, -13.00, Math.toRadians(-240.00)))
                                        .lineToLinearHeading(new Pose2d(34.00, -14.00, Math.toRadians(-180.00)))
                                        .lineToLinearHeading(new Pose2d(35.00, -36.00, Math.toRadians(-180.00)))
                                        .splineToLinearHeading(new Pose2d(50.00, -20.00, Math.toRadians(-180.00)), Math.toRadians(-180.00))

//                                        .lineToLinearHeading(new Pose2d(47.78, -17.00, Math.toRadians(-180.00)))
//                                        .lineToLinearHeading(new Pose2d(62.58, -17.01, Math.toRadians(-180.00)))

                                        .build()

                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}