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
//
                                        .lineToSplineHeading(new Pose2d(-28.82, -32.78, Math.toRadians(90.00)))
                                        .lineToLinearHeading(new Pose2d(-48.23, -32.98, Math.toRadians(-240.00)))
                                        .splineToConstantHeading(new Vector2d(-35.16, -10.99), Math.toRadians(12.26))
                                        .lineToLinearHeading(new Pose2d(33.93, -14.40, Math.toRadians(-180.00)))
                                        .lineToConstantHeading(new Vector2d(34.76, -36.54))
                                        .splineToLinearHeading(new Pose2d(53.00, -42.50, Math.toRadians(-180.00)), Math.toRadians(-180.00))
                                        .build()

                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}