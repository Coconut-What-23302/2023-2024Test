package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.helperClasses.AutoPaths.backstageRed;
import org.firstinspires.ftc.teamcode.helperClasses.PoseStorage;
import org.firstinspires.ftc.teamcode.helperClasses.RobotHardware;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import org.openftc.easyopencv.OpenCvCameraRotation;

@Autonomous

public class CWAutoRed extends LinearOpMode {



    @Override
    public void runOpMode() throws InterruptedException {


        final OpenCvAbstraction opencv = new OpenCvAbstraction(this);
        final PropDetector tseDetector = new PropDetector(telemetry, PropColors.Red);


        opencv.init(hardwareMap);
        opencv.setInternalCamera(false);
        opencv.setCameraName("Webcam 1");
        opencv.setCameraOrientation(OpenCvCameraRotation.UPRIGHT);
        opencv.onNewFrame(tseDetector::processFrame);


// Define variables to track previous DPad which is false
        boolean previousDPadUp = false;
        boolean previousDPadDown = false;
        boolean previousDPadLeft = false;
        boolean previousDPadRight = false;
        // Create instances of SampleMecanumDrive and RobotHardware - allowing for access to hardware and path methods then init robot hardware
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        RobotHardware robot = new RobotHardware();
        robot.init(hardwareMap);

        waitForStart();
        if (isStopRequested()) return;

        tseDetector.getPropPosition();
        telemetry.addData("Prop Position", tseDetector.getPropPosition());
        telemetry.update();

        final PropPosition finalSpikeLoc = tseDetector.getPropPosition();

        switch (finalSpikeLoc) {
            case Left: // spike is on the left
                TrajectorySequence spikeLeftTrajectory = backstageRed.Left(drive, robot);
                drive.followTrajectorySequence(spikeLeftTrajectory);
                break;
            case Center: // spike is on the middle
                TrajectorySequence spikeMiddleTrajectory = backstageRed.Middle(drive, robot);
                drive.followTrajectorySequence(spikeMiddleTrajectory);
                break;
            case Right: //spike is on the right
                TrajectorySequence spikeRightTrajectory = backstageRed.Right(drive, robot);
                drive.followTrajectorySequence(spikeRightTrajectory);
                break;
        }


        PoseStorage.transferedPose = drive.getPoseEstimate(); // transfer pose between op modes

    }
}