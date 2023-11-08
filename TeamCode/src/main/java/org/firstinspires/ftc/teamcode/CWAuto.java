package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.helperClasses.RobotHardware;
import org.firstinspires.ftc.teamcode.helperClasses.AutonomousTrajectories;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import java.util.Dictionary;
import java.util.Hashtable;

@Autonomous

public class CWAuto extends LinearOpMode {


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
                telemetry.addLine("Select Robot Start Location");
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
        telemetry.addData("Select Robot Start Location", startLocationText.get(startLocation));
        telemetry.update();

        /*
         *   Division between main code loop and initialization code because i'm blind
         */
        waitForStart();
        if(isStopRequested()) return;





        switch(startLocation) {
            case 0:
                // If start location is 0, execute Backstage Red Trajectory
                TrajectorySequence backstageRedTrajectory = AutonomousTrajectories.createBackstageRedTrajectory(drive, robot);
                drive.followTrajectorySequence(backstageRedTrajectory);
                robot.boardPixelServoPos(false);
                sleep(800);
                robot.boardPixelServoPos(true);
                sleep(1000);
                telemetry.addLine("Backstage Red Trajectory Executed");
                telemetry.update();
                sleep(1000);
                break;
            case 1:
                TrajectorySequence backstageBlueTrajectory = AutonomousTrajectories.createBackstageRedTrajectory(drive, robot);
                drive.followTrajectorySequence(backstageBlueTrajectory);
                telemetry.addLine("Backstage Blue Trajectory Executed");
                telemetry.update();
                sleep(1000);

                break;
            case 2:
                // If start location is 2, run frontstage Red Trajectory

                break;
            case 3:
                // If start location is 3, run Frontstage Blue Trajectory

                break;
            default:
                // Handle any and all other unhandled cases and default to backstage red (though should not ever happen)
                break;

    }
}
}