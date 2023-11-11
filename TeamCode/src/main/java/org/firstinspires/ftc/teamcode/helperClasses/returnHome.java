package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.helperClasses.PoseStorage;
import org.firstinspires.ftc.teamcode.helperClasses.RobotHardware;
import org.firstinspires.ftc.teamcode.helperClasses.AutoPaths.homeTrajectories;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import java.util.Dictionary;
import java.util.Hashtable;

@TeleOp

public class returnHome extends LinearOpMode {


    int startLocation = -1;
    boolean startVarsPicked = false;
    @Override
    public void runOpMode() throws InterruptedException {
// Define variables to track previous DPad which is false
        boolean previousDPadUp = false;
        boolean previousDPadDown = false;
        boolean previousDPadLeft = false;
        boolean previousDPadRight = false;
        // Create instances of SampleMecanumDrive and RobotHardware - allowing for access to hardware and path methods then init robot hardware
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        RobotHardware robot = new RobotHardware();
        robot.init(hardwareMap);

        // Create a dictionary mapping start locations to text descriptions
        Dictionary<Integer, String> startLocationText = new Hashtable<>();
        startLocationText.put(0, "Backstage Red");
        startLocationText.put(1, "Backstage Blue");
        startLocationText.put(2, "Frontstage Red");
        startLocationText.put(3, "Frontstage Blue");


        while (!startVarsPicked) {

            boolean currentDPadUp = gamepad1.dpad_up;
            boolean currentDPadDown = gamepad1.dpad_down;
            boolean currentDPadLeft = gamepad1.dpad_left;
            boolean currentDPadRight = gamepad1.dpad_right;
            if(startLocation == -1) {
                telemetry.addLine("Select Home to Return to");
                telemetry.update();
                if (currentDPadUp && !previousDPadUp) {
                    startLocation = 0;
                } else if (currentDPadRight && !previousDPadRight) {
                    startLocation = 1;
                } else if (currentDPadDown && !previousDPadDown) {
                    startLocation = 2;
                } else if (currentDPadLeft && !previousDPadLeft) {
                    startLocation = 3;
                }

            } else {
                startVarsPicked = true;
            }
            previousDPadLeft = currentDPadLeft;
            previousDPadRight = currentDPadRight;
            previousDPadUp = currentDPadUp;
            previousDPadDown = currentDPadDown;
        }

// Display the correct robot start location
        telemetry.addData("Select Home", startLocationText.get(startLocation));
        telemetry.update();

        /*
         *   Division between main code loop and initialization code because i'm blind
         */
        waitForStart();
        if(isStopRequested()) return;


        switch(startLocation) {
            case 0:
                // If start location is 0, execute Backstage Red Trajectory
                TrajectorySequence backstageRedHomeTrajectory = homeTrajectories.returnHomeBRTrajectory(drive, robot);
                drive.followTrajectorySequence(backstageRedHomeTrajectory);
                break;
            case 1:
                TrajectorySequence backstageBlueHomeTrajectory = homeTrajectories.returnHomeBBTrajectory(drive, robot);
                drive.followTrajectorySequence(backstageBlueHomeTrajectory);
                break;
            case 2:
                TrajectorySequence frontstageRedHomeTrajectory = homeTrajectories.returnHomeFRTrajectory(drive, robot);
                drive.followTrajectorySequence(frontstageRedHomeTrajectory);
                break;
            case 3:
                TrajectorySequence frontstageBlueHomeTrajectory = homeTrajectories.returnHomeFBTrajectory(drive, robot);
                drive.followTrajectorySequence(frontstageBlueHomeTrajectory);
                break;
        }
        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;


            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            robot.frontLeft.setPower(frontLeftPower);
            robot.backLeft.setPower(backLeftPower);
            robot.frontRight.setPower(frontRightPower);
            robot.backRight.setPower(backRightPower);

        }
        PoseStorage.transferedPose = drive.getPoseEstimate(); // transfer pose between op modes

    }
}