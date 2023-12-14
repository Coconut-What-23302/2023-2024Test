package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.helperClasses.AutoPaths.backstageBlue;
import org.firstinspires.ftc.teamcode.helperClasses.AutoPaths.backstageRed;
import org.firstinspires.ftc.teamcode.helperClasses.PoseStorage;
import org.firstinspires.ftc.teamcode.helperClasses.RobotHardware;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import org.openftc.easyopencv.OpenCvCameraRotation;

@Autonomous

public class CWAutoBlue extends LinearOpMode {



    @Override

    public void runOpMode() {
        final OpenCvAbstraction opencv = new OpenCvAbstraction(this);
        final PropDetector tseDetector = new PropDetector(telemetry, PropColors.Blue);


        opencv.init(hardwareMap);
        opencv.setInternalCamera(false);
        opencv.setCameraName("Webcam 1");
        opencv.setCameraOrientation(OpenCvCameraRotation.UPRIGHT);
        opencv.onNewFrame(tseDetector::processFrame);

        // Insert whatever initialization your own code does

        // Assuming you're using StandardTrackingWheelLocalizer.java
        // Switch this class to something else (Like TwoWheeTrackingLocalizer.java) if your configuration is different
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        RobotHardware robot = new RobotHardware();
        robot.init(hardwareMap);

        // Set your initial pose to x: 10, y: 10, facing 90 degrees
        drive.setPoseEstimate(new Pose2d(-39, -70, Math.toRadians(90)));

        waitForStart();

        while(opModeIsActive()) {
            // Make sure to call drive.update() on *every* loop
            // Increasing loop time by utilizing bulk reads and minimizing writes will increase your odometry accuracy

            tseDetector.getPropPosition();


//            final PropPosition finalSpikeLoc = tseDetector.getPropPosition();
            final PropPosition finalSpikeLoc = PropPosition.Center;

            drive.update();

            // Retrieve your pose
            Pose2d postInitPose = drive.getPoseEstimate();
            telemetry.addData("x", postInitPose.getX());
            telemetry.addData("y", postInitPose.getY());
            telemetry.addData("heading", postInitPose.getHeading());
            telemetry.update();


            PoseStorage.transferedPose = drive.getPoseEstimate(); // transfer pose between op modes


//                            .splineTo(new Vector2d(-39.60, 10.57), Math.toRadians(10.02))
//                    .splineTo(new Vector2d(26.77, 9.98), Math.toRadians(6.73))
//                    .splineToLinearHeading(new Pose2d(32.10, 45.33, Math.toRadians(1.68)), Math.toRadians(1.68))


            // Insert whatever teleop code you're using
//            PoseStorage.transferedPose = drive.getPoseEstimate(); // transfer pose between op modes
        }
    }
}

