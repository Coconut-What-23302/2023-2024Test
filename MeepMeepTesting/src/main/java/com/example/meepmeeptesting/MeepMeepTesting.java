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




                                        .splineTo(new Vector2d(-36.93, 0.69), Math.toRadians(93.18))
                                        .waitSeconds(2.2)
                                        .splineTo(new Vector2d(15.18, 0.10), Math.toRadians(-0.65))
                                        .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
//                                            robot.boardPixelServoPos(false);
                                        })
                                        .waitSeconds(.6)
                                        .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
//                                            robot.boardPixelServoPos(true);
                                        })
                                        .waitSeconds(.3)
                                        .splineTo(new Vector2d(11.85, -37.52), Math.toRadians(264.94))
                                        .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
//                                            robot.spikeServoPos(false);
                                        })
                                        .waitSeconds(.3)
                                        .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
//                                            robot.spikeServoPos(true);
                                        })
                                        .waitSeconds(.3)
                                        .splineTo(new Vector2d(52.60, -31.44), Math.toRadians(90.00))
                                        .build()

                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}