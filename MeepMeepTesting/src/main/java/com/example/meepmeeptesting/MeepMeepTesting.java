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
                                drive.trajectorySequenceBuilder(new Pose2d( 10, 64, Math.toRadians(180)))

                                        .splineToLinearHeading(new Pose2d(-36.20, -22.50, Math.toRadians(0.00)), Math.toRadians(0.00))
                                        .UNSTABLE_addTemporalMarkerOffset(.01, () -> {
//                                            robot.spikeMarkDrop.setPosition(-.7);
                                        })
                                        .waitSeconds(.8)
                                        .UNSTABLE_addTemporalMarkerOffset(.0001, () -> {
//                                            robot.spikeMarkDrop.setPosition(.45);
                                        })
                                        .splineToLinearHeading(new Pose2d(-32.75, -12.43, Math.toRadians(-3.02)), Math.toRadians(-3.02))
                                        .splineToLinearHeading(new Pose2d(9.47, -10.65, Math.toRadians(-19.62)), Math.toRadians(-19.62))
                                        .splineToLinearHeading(new Pose2d(39.45, -21.50, Math.toRadians(-90.00)), Math.toRadians(-80.00))
                                        .splineToLinearHeading(new Pose2d(53.00, -41.50, Math.toRadians(-180.00)), Math.toRadians(0.00))

                                .build()

                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}