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
                        drive.trajectorySequenceBuilder(new Pose2d(-39, -70, Math.toRadians(90)))

                                // don't touch

//                                .splineToConstantHeading(new Vector2d(-55.73, -34.66), Math.toRadians(115.52))

                                .splineToLinearHeading(new Pose2d(-57.61, -36.98, Math.toRadians(70.94)), Math.toRadians(70.94))
                                .splineToLinearHeading(new Pose2d(-36.00, -23.00, Math.toRadians(0.00)), Math.toRadians(0.00))
                                .addDisplacementMarker(() -> {
                                    // grab wobble goal
                                })
                                .lineTo(new Vector2d(-40.61, -14.75))
                                .splineToConstantHeading(new Vector2d(-28.55, -9.52), Math.toRadians(8.87))
                                .splineToConstantHeading(new Vector2d(-16.06, -13.15), Math.toRadians(-9.82))
                                .splineToConstantHeading(new Vector2d(-4.00, -10.53), Math.toRadians(15.87))
                                .splineToConstantHeading(new Vector2d(7.63, -9.52), Math.toRadians(10.45))
                                .splineToConstantHeading(new Vector2d(17.22, -16.20), Math.toRadians(7.22))
                                .splineToConstantHeading(new Vector2d(28.99, -10.97), Math.toRadians(30.68))
                                .splineToConstantHeading(new Vector2d(33.35, -8.06), Math.toRadians(42.85))
                                .splineToConstantHeading(new Vector2d(27.39, -65.17), Math.toRadians(252.09))
                                .lineToSplineHeading(new Pose2d(47.73, -35.24, Math.toRadians(180.00)))











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