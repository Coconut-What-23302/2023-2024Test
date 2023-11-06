package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp
public class TestDrive extends LinearOpMode {
    RobotHardware robot = new RobotHardware();
    @Override

    // toggle vars

    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);






        waitForStart();

        if (isStopRequested()) return;

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

            // non drive controls;


            // logic to raise hang arm
            if( (gamepad1.x == true) && (robot.hangDeployServo.getPosition() == .2) ) {
                robot.hangDeployServo.setPosition(1);
            } else if ( (gamepad1.x == true) && (robot.hangDeployServo.getPosition() == 1) ) {
                robot.hangDeployServo.setPosition(.2);
            } else if (gamepad1.x == true ) {
                robot.hangDeployServo.setPosition(1);
            }

            // manual overrides driver 2
//            if( (gamepad2.x == true) && (robot.boardPixelDrop.getPosition() == 0) ) {
//                robot.boardPixelDrop.setPosition(1);
//            } else if ( (gamepad2.x == true) && (robot.boardPixelDrop.getPosition() == 1) ) {
//                robot.boardPixelDrop.setPosition(0);
//            } else if (gamepad2.x == true ) {
//                robot.boardPixelDrop.setPosition(1);
//            }



            telemetry.addData("Hang Servo", robot.hangDeployServo.getPosition());
            telemetry.update();










        }
    }
}