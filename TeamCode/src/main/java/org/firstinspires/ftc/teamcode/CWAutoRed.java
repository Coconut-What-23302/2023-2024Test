// Package declaration and imports
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.helperClasses.AutoPaths.backstageRed;
import org.firstinspires.ftc.teamcode.helperClasses.PoseStorage;
import org.firstinspires.ftc.teamcode.helperClasses.RobotHardware;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import org.openftc.easyopencv.OpenCvCameraRotation;

// Declare the op mode as an Autonomous op mode
@Autonomous
public class CWAutoRed extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        // Initialize OpenCV and PropDetector
        final OpenCvAbstraction opencv = new OpenCvAbstraction(this);
        final PropDetector tseDetector = new PropDetector(telemetry, PropColors.Red);

        // Configure OpenCV
        opencv.init(hardwareMap);
        opencv.setInternalCamera(false);
        opencv.setCameraName("Webcam 1");
        opencv.setCameraOrientation(OpenCvCameraRotation.UPRIGHT);
        opencv.onNewFrame(tseDetector::processFrame);

        // Create instances of SampleMecanumDrive and RobotHardware, then initialize robot hardware
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        RobotHardware robot = new RobotHardware();
        robot.init(hardwareMap);


        waitForStart();
        if (isStopRequested()) return;

        // Get the position of the prop using PropDetector
        tseDetector.getPropPosition();
        telemetry.addData("Prop Position", tseDetector.getPropPosition());
        telemetry.update();

        // Determine the final spike location based on the prop position
        final PropPosition finalSpikeLoc = tseDetector.getPropPosition();

        // Execute trajectory sequence based on the final spike location
        switch (finalSpikeLoc) {
            case Left:
                // Spike is on the left
                TrajectorySequence spikeLeftTrajectory = backstageRed.Left(drive, robot);
                drive.followTrajectorySequence(spikeLeftTrajectory);
                break;
            case Center:
                // Spike is in the center
                TrajectorySequence spikeMiddleTrajectory = backstageRed.Middle(drive, robot);
                drive.followTrajectorySequence(spikeMiddleTrajectory);
                break;
            case Right:
                // Spike is on the right
                TrajectorySequence spikeRightTrajectory = backstageRed.Right(drive, robot);
                drive.followTrajectorySequence(spikeRightTrajectory);
                break;
        }

        // Transfer the robot's pose between op modes
        PoseStorage.transferedPose = drive.getPoseEstimate();
    }
}
