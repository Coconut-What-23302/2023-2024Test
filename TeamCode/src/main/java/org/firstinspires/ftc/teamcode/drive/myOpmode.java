package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.teamcode.RobotHardware;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

/*
 * This is an example of a more complex path to really test the tuning.
 */
@Autonomous(group = "drive")

public class myOpmode extends LinearOpMode {

    RobotHardware robot = new RobotHardware();
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        robot.init(hardwareMap);




        waitForStart();

        if (isStopRequested()) return;

        Pose2d startPose = new Pose2d(-39, -70, Math.toRadians(90));
        drive.setPoseEstimate(startPose);

        Trajectory untitled0 = drive.trajectoryBuilder(startPose)
                //
                .splineToLinearHeading(new Pose2d(-57.61, -36.98, Math.toRadians(70.94)), Math.toRadians(70.94))
                .splineToLinearHeading(new Pose2d(-36.00, -23.00, Math.toRadians(0.00)), Math.toRadians(0.00))
                .addDisplacementMarker(() -> {
                    // drop the servo which i totally did not break
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
                //
                .build();



        drive.followTrajectory(untitled0);



    }
}
