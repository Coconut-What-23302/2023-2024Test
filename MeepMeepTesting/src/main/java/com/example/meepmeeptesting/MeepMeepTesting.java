package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
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
                        drive.trajectorySequenceBuilder(new Pose2d(-39, 70, Math.toRadians(-90)))

                                // don't touch
                                .splineToLinearHeading(new Pose2d(-36.00, 22.00, Math.toRadians(-180.00)), Math.toRadians(0.00))
                                .splineToLinearHeading(new Pose2d(-33.81, 11.83, Math.toRadians(-180.00)), Math.toRadians(0.00))
                                .lineToSplineHeading(new Pose2d(36.23, 12.39, Math.toRadians(-180.00)))
                                .lineToSplineHeading(new Pose2d(34.74, 36.23, Math.toRadians(-180.00)))
                                .splineToLinearHeading(new Pose2d(53.00, 41.50, Math.toRadians(180.00)), Math.toRadians(180.00))


        // do not touch
                                .build()

                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}