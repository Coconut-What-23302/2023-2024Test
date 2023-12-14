package org.firstinspires.ftc.teamcode.helperClasses.AutoPaths;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.helperClasses.AutoPaths.backstageRed;
import org.firstinspires.ftc.teamcode.helperClasses.PoseStorage;
import org.firstinspires.ftc.teamcode.helperClasses.RobotHardware;

public class DriveForwardAuto {

    public void runOpMode() throws InterruptedException {


        RobotHardware robot = new RobotHardware();

        robot.frontLeft.setPower(0.2);
        robot.frontLeft.setPower(0.2);
        robot.backRight.setPower(0.2);
        robot.backLeft.setPower(0.2);

        sleep(8000);




    }








}
